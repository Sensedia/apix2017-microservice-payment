package com.sensedia.apix.payment.service;

import java.util.ArrayList;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensedia.apix.payment.entity.ApiClientKeys;
import com.sensedia.apix.payment.entity.PaymentEntity;

import io.swagger.client.ApiException;
import io.swagger.client.api.OrderManagementApi;
import io.swagger.client.model.Order;
import io.swagger.client.model.Order.StatusEnum;
import io.swagger.client.model.OrderItem;
import io.swagger.client.model.OrderItem.UnitOfMeasureEnum;
import io.swagger.client.model.Response;

@Service
public class LioService {
	
	@Autowired
	private ApiClientKeys apiClientKeys;
	
	@Autowired
	private OrderManagementApi apiInstance;

	public String createPayment(PaymentEntity paymentEntity) {
		OrderItem orderItem = new OrderItem(); // OrderItem |
		orderItem.setSku(UUID.randomUUID().toString());
		orderItem.setName(paymentEntity.getItem());
		orderItem.setUnitPrice(Integer.valueOf(paymentEntity.getAmount()));
		orderItem.setUnitOfMeasure(UnitOfMeasureEnum.EACH);
		orderItem.setCreatedAt(new DateTime());
		orderItem.setUpdatedAt(orderItem.getCreatedAt());

		Order order = new Order(); // Order |
		order.setReference("Order Chatbot");
		order.setId(UUID.randomUUID().toString());
		order.setStatus(StatusEnum.DRAFT);
		order.setCreatedAt(new DateTime());
		order.setPrice(Integer.valueOf(paymentEntity.getAmount()));
		order.setTransactions(new ArrayList<>());
		order.setRemaining(null);
		try {	
			Response orderResult = apiInstance.orderCreate(apiClientKeys.getClientId(), apiClientKeys.getAccessToken(), apiClientKeys.getMerchantId(), order);
			System.out.println(orderResult);
			order.setId(orderResult.getId()); // String | Identificador do pedido.
		} catch (ApiException e) {
			System.err.println("Exception when calling OrderManagementApi#orderCreate");
			e.printStackTrace();
		}
		try {
			Response orderItemResult = apiInstance.orderAddItem(apiClientKeys.getClientId(), apiClientKeys.getAccessToken(), apiClientKeys.getMerchantId(), order.getId(), orderItem);
			System.out.println(orderItemResult);
		} catch (ApiException e) {
			System.err.println("Exception when calling OrderManagementApi#orderAddItem");
			e.printStackTrace();
		}
		
		try {	
			apiInstance.orderUpdate(apiClientKeys.getClientId(), apiClientKeys.getAccessToken(), apiClientKeys.getMerchantId(), order.getId(), "PLACE");
		} catch (ApiException e) {
			System.err.println("Exception when calling OrderManagementApi#orderCreate");
			e.printStackTrace();
		}
		
		return order.getId();
	}

	public Object checkPaymentStatus(String orderId) {


		OrderManagementApi apiInstance = new OrderManagementApi();

		try {
			Order orderItemResult = apiInstance.orderGet(apiClientKeys.getClientId(), apiClientKeys.getAccessToken(), apiClientKeys.getMerchantId(), orderId);
			System.out.println(orderItemResult);
		} catch (ApiException e) {
			System.err.println("Exception when calling OrderManagementApi#orderAddItem");
			e.printStackTrace();
		}

		return null;
	}

	public Boolean isPaid(PaymentEntity paymentEntity) {
		try {
			Order orderItemResult = apiInstance.orderGet(apiClientKeys.getClientId(), apiClientKeys.getAccessToken(), apiClientKeys.getMerchantId(), paymentEntity.getOrderID());
			return orderItemResult.getStatus().equals(StatusEnum.APPROVED);
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
