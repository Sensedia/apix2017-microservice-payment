package com.sensedia.apix.payment.service;

import java.util.ArrayList;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.sensedia.apix.payment.entity.PaymentEntity;
import com.sensedia.apix.payment.entity.PaymentProviderEnum;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.Configuration;
import io.swagger.client.api.OrderManagementApi;
import io.swagger.client.auth.ApiKeyAuth;
import io.swagger.client.model.Order;
import io.swagger.client.model.Order.StatusEnum;
import io.swagger.client.model.OrderItem;
import io.swagger.client.model.OrderItem.UnitOfMeasureEnum;
import io.swagger.client.model.Response;

@Service
public class LioService {
	
	private static final String BASE_PATH = "https://api.cielo.com.br/order-management/";

	public String createPayment(PaymentEntity paymentEntity) {
		ApiClient defaultClient = Configuration.getDefaultApiClient();
		defaultClient.setBasePath(BASE_PATH);

		// Configure API key authorization: merchant-id
		ApiKeyAuth merchantId = (ApiKeyAuth) defaultClient.getAuthentication("merchant-id");
		merchantId.setApiKey("7e5153a6-3f47-4808-8bcf-1ce8a1aa6407");

		// Configure API key authorization: access-token
		ApiKeyAuth accessToken = (ApiKeyAuth) defaultClient.getAuthentication("access-token");
		accessToken.setApiKey("5CQy0xqlwdTB");

		// Configure API key authorization: client-id
		ApiKeyAuth clientId = (ApiKeyAuth) defaultClient.getAuthentication("client-id");
		clientId.setApiKey("L9psvZjdj65y");

		OrderManagementApi apiInstance = new OrderManagementApi();

		OrderItem orderItem = new OrderItem(); // OrderItem |
		orderItem.setSku(UUID.randomUUID().toString());
		orderItem.setUnitPrice(1);
		orderItem.setUnitOfMeasure(UnitOfMeasureEnum.EACH);
		orderItem.setUpdatedAt(new DateTime());

		Order order = new Order(); // Order |
		order.setStatus(StatusEnum.DRAFT);
		order.setCreatedAt(new DateTime());
		order.setItems(new ArrayList<>());
		order.getItems().add(orderItem);

		order.setTransactions(new ArrayList<>());

		order.setPrice(1);
		order.setRemaining(0);
		try {	
			Response orderResult = apiInstance.orderCreate(clientId.getApiKey(), accessToken.getApiKey(), merchantId.getApiKey(), order);
			System.out.println(orderResult);
			order.setId(orderResult.getId()); // String | Identificador do pedido.
		} catch (ApiException e) {
			System.err.println("Exception when calling OrderManagementApi#orderCreate");
			e.printStackTrace();
		}
		try {
			Response orderItemResult = apiInstance.orderAddItem(clientId.getApiKey(), accessToken.getApiKey(), merchantId.getApiKey(), order.getId(), orderItem);
			System.out.println(orderItemResult);
		} catch (ApiException e) {
			System.err.println("Exception when calling OrderManagementApi#orderAddItem");
			e.printStackTrace();
		}
		return null;
	}

	public Object checkPaymentStatus(String orderId) {
		ApiClient defaultClient = Configuration.getDefaultApiClient();

		// Configure API key authorization: merchant-id
		ApiKeyAuth merchantId = (ApiKeyAuth) defaultClient.getAuthentication("merchant-id");
		merchantId.setApiKey("7e5153a6-3f47-4808-8bcf-1ce8a1aa6407");

		// Configure API key authorization: access-token
		ApiKeyAuth accessToken = (ApiKeyAuth) defaultClient.getAuthentication("access-token");
		accessToken.setApiKey("3le910m7zLqB");

		// Configure API key authorization: client-id
		ApiKeyAuth clientId = (ApiKeyAuth) defaultClient.getAuthentication("client-id");
		clientId.setApiKey("UtTTZaICoe5P");

		OrderManagementApi apiInstance = new OrderManagementApi();

		try {
			Order orderItemResult = apiInstance.orderGet(clientId.getApiKey(), accessToken.getApiKey(), merchantId.getApiKey(), orderId);
			System.out.println(orderItemResult);
		} catch (ApiException e) {
			System.err.println("Exception when calling OrderManagementApi#orderAddItem");
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		LioService lioService = new LioService();
		PaymentEntity paymentEntity = new PaymentEntity();
		paymentEntity.setPaymentProvider(PaymentProviderEnum.CIELO_LIO);

		lioService.createPayment(paymentEntity);
	}
}
