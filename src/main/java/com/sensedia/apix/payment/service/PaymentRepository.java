package com.sensedia.apix.payment.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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
		if(payment.getOrderID() == null){
			payment.setOrderID(UUID.randomUUID().toString());
		}
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

	public List getPayments(String orderId) {
		List payments = new ArrayList<>();
		
		if(orderId != null){
			payments = new ArrayList<>();
			payments.add(paymentMap.get(orderId));
		}else{
			payments = new ArrayList<>(paymentMap.values());
		}
		
		return payments;
	}
}