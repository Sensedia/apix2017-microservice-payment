package com.sensedia.apix.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensedia.apix.payment.PaymentScheduler;
import com.sensedia.apix.payment.entity.PaymentEntity;
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

	public String createPayment(PaymentBody paymentBody) {
		PaymentEntity paymentEntity = new PaymentEntity();
		String paymentResult = null;

		switch(paymentBody.getPaymentProvider()){
		case CIELO_LIO:
			lioService.createPayment(paymentEntity);
			paymentRepository.createOrUpdate(paymentEntity);
			paymentScheduler.createJob(paymentEntity.getOrderID());
			
		case VISA_CHECKOUT:
			visaService.createPayment(paymentEntity);
			paymentRepository.createOrUpdate(paymentEntity);
			
		default:
			
		}
		
		return paymentResult;
	}

	public PaymentEntity checkPaymentStatus(String id) {
		PaymentEntity paymentEntity = new PaymentEntity();
		paymentEntity.setStatus("PAID");
		return paymentEntity;
	}

}
