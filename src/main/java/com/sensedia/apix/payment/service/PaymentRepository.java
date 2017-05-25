package com.sensedia.apix.payment.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.sensedia.apix.payment.entity.PaymentEntity;

@Service
public class PaymentRepository {

	private Map<String, PaymentEntity> paymentMap = new ConcurrentHashMap<>();
	
	public Collection<PaymentEntity> findAll(){
		return paymentMap.values();
	}
	
	public void createOrUpdate(PaymentEntity payment){
		paymentMap.put(payment.getOrderID(), payment);
	}

	public void removeAll(List<String> removeKeys) {
		removeKeys.forEach((key) -> {
			paymentMap.remove(key);
		});
	}
	
	public void remove(String key) {
		paymentMap.remove(key);
	}

	public PaymentEntity findById(String orderId) {
		return paymentMap.get(orderId);
	}
}