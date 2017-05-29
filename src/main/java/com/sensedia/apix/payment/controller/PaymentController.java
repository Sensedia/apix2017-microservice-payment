package com.sensedia.apix.payment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sensedia.apix.payment.entity.PaymentEntity;
import com.sensedia.apix.payment.entity.json.PaymentBody;
import com.sensedia.apix.payment.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE},
			produces =  MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public ResponseEntity<PaymentBody> createPayment(@RequestBody(required = true) PaymentBody paymentBodyRequest){
		String paymentId;
		PaymentBody paymentBodyResponse;
		try {
			paymentId = paymentService.createPayment(paymentBodyRequest);
			paymentBodyResponse = new PaymentBody();
			paymentBodyResponse.setPaymentId(paymentId);
			
			return new ResponseEntity<>(paymentBodyResponse, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.GATEWAY_TIMEOUT);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE},
			produces =  MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public ResponseEntity<PaymentBody> updatePayment(@RequestBody(required = true) PaymentBody paymentBodyRequest){
		String paymentId;
		PaymentBody paymentBodyResponse;
		try {
			paymentBodyRequest.setOrderID(paymentBodyRequest.getPaymentID());
			
			paymentId = paymentService.updatePayment(paymentBodyRequest);
			paymentBodyResponse = new PaymentBody();
			paymentBodyResponse.setPaymentId(paymentId);
			
			return new ResponseEntity<>(paymentBodyResponse, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.GATEWAY_TIMEOUT);
		}
	}
	
	@RequestMapping(path="/orders/{orderId}" , method = RequestMethod.GET, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE},
			produces =  MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public ResponseEntity<List> getPayments(@PathVariable String orderId){
		return new ResponseEntity<>(getOrders(orderId), HttpStatus.OK);
	}
	
	@RequestMapping(path="/orders/" , method = RequestMethod.GET, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE},
			produces =  MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public ResponseEntity<List> getPayment(){
		return new ResponseEntity<>(getOrders(null), HttpStatus.OK);	
	}
	
	
	private List getOrders(String orderId){
		List payments = paymentService.getPayments(orderId);
		if(payments == null){
			payments = new ArrayList<>();
		}
		return payments;
	}

	@RequestMapping(path = "/{id}/status/", method = RequestMethod.GET, produces =  MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public ResponseEntity<PaymentBody> checkPaymentStatus(@PathVariable String paymentId){
		
		PaymentEntity paymentEntity = paymentService.checkPaymentStatus(paymentId);
		
		PaymentBody paymentBodyResponse = new PaymentBody();
		paymentBodyResponse.setStatus(paymentEntity.getStatus());
		
		return new ResponseEntity<>(paymentBodyResponse, HttpStatus.OK);
	}
}
