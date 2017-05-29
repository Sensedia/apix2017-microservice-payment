package com.sensedia.apix.payment.entity.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sensedia.apix.payment.entity.PaymentProviderEnum;

@JsonInclude(content = Include.NON_NULL)
public class PaymentBody {

	private PaymentProviderEnum paymentProvider;
	private String amount;
	private String paymentID;
	private String orderID;
	private String remoteID;
	private String callBackUrl;
	private String item;
	private String status;
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProduct() {
		return item;
	}
	public void setProduct(String product) {
		this.item = product;
	}
	public String getCallBackUrl() {
		return callBackUrl;
	}
	public void setCallBackUrl(String callBackUrl) {
		this.callBackUrl = callBackUrl;
	}
	public PaymentProviderEnum getPaymentProvider() {
		return paymentProvider;
	}
	public void setPaymentProvider(PaymentProviderEnum paymentProvider) {
		this.paymentProvider = paymentProvider;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPaymentId() {
		return paymentID;
	}
	public void setPaymentId(String paymentId) {
		this.paymentID = paymentId;
	}
	public String getRemoteID() {
		return remoteID;
	}
	public void setRemoteID(String remoteID) {
		this.remoteID = remoteID;
	}
}