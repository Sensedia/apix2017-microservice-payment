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
		BeanUtils.copyProperties(paymentBody, paymentEntity);

		if(PaymentProviderEnum.CIELO_LIO.equals(paymentBody.getPaymentProvider())){
			try {
				paymentEntity.setOrderID(lioService.createPayment(paymentEntity));
			} catch (Exception e) {
				throw new Exception("Create payment error: "+ e.getMessage());
			}
		}

		paymentRepository.createOrUpdate(paymentEntity);
		paymentScheduler.createJob(paymentEntity.getOrderID());
		return paymentEntity.getOrderID();
	}

	public PaymentEntity checkPaymentStatus(String orderId) {
		PaymentEntity paymentEntity = paymentRepository.findById(orderId);
		return paymentEntity;
	}

	public Boolean isPaid(String orderId, PaymentProviderEnum paymentProviderEnum) {
		Boolean paid = false;
		PaymentEntity paymentEntity = paymentRepository.findById(orderId);

		switch(paymentProviderEnum){
		case CIELO_LIO:
			paid = lioService.isPaid(paymentEntity);
			break;

		case VISA_CHECKOUT:
			paid = visaService.isPaid(paymentEntity);
			break;

		default:

		}

		return paid;
	}

	public String updatePayment(PaymentBody paymentBodyRequest) {
		PaymentEntity paymentEntity = paymentRepository.findById(paymentBodyRequest.getOrderID());
		if(paymentEntity != null){
			paymentRepository.createOrUpdate(paymentEntity);

			if(PaymentProviderEnum.VISA_CHECKOUT.equals(paymentBodyRequest.getPaymentProvider())){
				paymentScheduler.createJob(paymentEntity.getOrderID());
				paymentEntity.setStatus("PAID");
			}
			return paymentEntity.getOrderID();
		}

		return null;
	}

}