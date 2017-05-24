package com.sensedia.apix.payment.controller;

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
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE},
			produces =  MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public ResponseEntity<PaymentBody> createPayment(@RequestBody(required = true) PaymentBody paymentBodyRequest){
		String paymentId = paymentService.createPayment(paymentBodyRequest);

		PaymentBody paymentBodyResponse = new PaymentBody();
		paymentBodyResponse.setPaymentId(paymentId);
		return new ResponseEntity<>(paymentBodyResponse, HttpStatus.CREATED);
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