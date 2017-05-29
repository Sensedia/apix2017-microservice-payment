package com.sensedia.apix.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensedia.apix.payment.entity.PaymentEntity;

@Service
public class VisaService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	public Boolean isPaid(PaymentEntity paymentEntity) {
		PaymentEntity paymentEntityResult = paymentRepository.findById(paymentEntity.getOrderID());
		return "PAID".equals(paymentEntityResult.getStatus());
	}

}
