package com.sensedia.apix.payment.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensedia.apix.payment.PaymentScheduler;
import com.sensedia.apix.payment.entity.PaymentEntity;
import com.sensedia.apix.payment.entity.PaymentProviderEnum;
import com.sensedia.apix.payment.entity.json.PaymentBody;

@Service
public class PaymentService {

	@Autowired
	private LioService lioService;

	@Autowired
	private VisaService visaService;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private PaymentScheduler paymentScheduler;

	public String createPayment(PaymentBody paymentBody) throws Exception {
		PaymentEntity paymentEntity = new PaymentEntity();

		switch(paymentBody.getPaymentProvider()){
		case CIELO_LIO:
			BeanUtils.copyProperties(paymentBody, paymentEntity);
			try {
				paymentEntity.setOrderID(lioService.createPayment(paymentEntity));
				paymentRepository.createOrUpdate(paymentEntity);
				paymentScheduler.createJob(paymentEntity.getOrderID());
			} catch (Exception e) {
				throw new Exception("Create payment error: "+ e.getMessage());
			}
			
			break;
			
		case VISA_CHECKOUT:
			//visaService.createPayment(paymentEntity);
			//paymentRepository.createOrUpdate(paymentEntity);
			
			break;
			
		default:
			
		}
		
		return paymentEntity.getOrderID();
	}

	public PaymentEntity checkPaymentStatus(String id) {
		PaymentEntity paymentEntity = new PaymentEntity();
		paymentEntity.setStatus("PAID");
		return paymentEntity;
	}

	public Boolean isPaid(String orderId, PaymentProviderEnum paymentProviderEnum) {
		Boolean paid = false;
		
		switch(paymentProviderEnum){
		case CIELO_LIO:
			PaymentEntity paymentEntity = paymentRepository.findById(orderId);
			paid = lioService.isPaid(paymentEntity);
			break;
			
		case VISA_CHECKOUT:
			//visaService.createPayment(paymentEntity);
			//paymentRepository.createOrUpdate(paymentEntity);
			break;
			
		default:
			
		}
		
		return paid;
	}

}
