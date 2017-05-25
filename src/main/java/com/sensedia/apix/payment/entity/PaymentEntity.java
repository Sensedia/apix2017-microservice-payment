package com.sensedia.apix.payment.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sensedia.apix.payment.entity.PaymentProviderEnum;

@JsonInclude(content = Include.NON_NULL)
public class PaymentEntity {

	private PaymentProviderEnum paymentProvider;
	private String amount;
	private String transactionID;
	private String orderID;
	private String remoteID;
	private String status;
	private Date created;
	private Date lastUpdate;
	private String callBackUrl;
	private String item;

	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
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
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getRemoteID() {
		return remoteID;
	}
	public void setRemoteID(String remoteID) {
		this.remoteID = remoteID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}


}