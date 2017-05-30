package com.sensedia.apix.payment.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sensedia.apix.payment.entity.ApiClientKeys;
import com.sensedia.apix.payment.entity.PaymentEntity;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

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

	@Value("${alternative-path}")
	private String alternativebasePath;
	
	private OkHttpClient client = new OkHttpClient();

	public String createPayment(PaymentEntity paymentEntity) throws Exception {
		
		OrderItem orderItem = new OrderItem(); // OrderItem |
		orderItem.setSku(UUID.randomUUID().toString());
		orderItem.setName(paymentEntity.getItem());
		orderItem.setUnitPrice(Integer.valueOf(paymentEntity.getAmount()));
		orderItem.setUnitOfMeasure(UnitOfMeasureEnum.EACH);
		orderItem.setCreatedAt(new DateTime());
		orderItem.setUpdatedAt(orderItem.getCreatedAt());

		Order order = new Order(); // Order |
		order.setReference(paymentEntity.getRemoteID() + " - APIX Chatbot");
		order.setId(UUID.randomUUID().toString());
		order.setStatus(StatusEnum.DRAFT);
		order.setCreatedAt(new DateTime());
		order.setPrice(Integer.valueOf(paymentEntity.getAmount()));
		order.setTransactions(new ArrayList<>());
		order.setRemaining(null);
		order.setItems(new ArrayList<>());
		order.getItems().add(orderItem);
		
		try {	
			Response orderResult = apiInstance.orderCreate(apiClientKeys.getClientId(), apiClientKeys.getAccessToken(), apiClientKeys.getMerchantId(), order);
			order.setId(orderResult.getId()); // String | Identificador do pedido.
		} catch (ApiException e) {
			throw new Exception("Error to create Order: "+ e.getMessage());
		}
		
		try {	
			com.squareup.okhttp.Response response = put(alternativebasePath + "/orders/"+order.getId()+"?operation=PLACE",apiClientKeys.getClientId(), apiClientKeys.getAccessToken(), apiClientKeys.getMerchantId());
		} catch (IOException e) {
			System.err.println("Exception when calling OrderManagementApi#orderUpdate");
			apiInstance.orderDelete(apiClientKeys.getClientId(), apiClientKeys.getAccessToken(), apiClientKeys.getMerchantId(), order.getId());
			throw new Exception("Error to set Order Item: "+ e.getMessage());
		}
		
		return order.getId();
	}
	
	public com.squareup.okhttp.Response put(String url, String cliendId, String accessToken, String merchantId) throws IOException {
		Request request = new Request.Builder()
				.url(url)
				.header("Merchant-ID", merchantId)
				.header("Access-Token", accessToken)
				.header("Client-Id", cliendId)
				.put(RequestBody.create(MediaType.parse("application/json"), ""))
				.build();
		com.squareup.okhttp.Response response = client.newCall(request).execute();
		return response;
	}
	
	public com.squareup.okhttp.Response get(String url, String cliendId, String accessToken, String merchantId) throws IOException {
		Request request = new Request.Builder()
				.url(url)
				.header("Merchant-ID", merchantId)
				.header("Access-Token", accessToken)
				.header("Client-Id", cliendId)
				.get()
				.build();
		com.squareup.okhttp.Response response = client.newCall(request).execute();
		return response;
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
			com.squareup.okhttp.Response response = get(alternativebasePath + "/orders/"+paymentEntity.getOrderID(),apiClientKeys.getClientId(), apiClientKeys.getAccessToken(), apiClientKeys.getMerchantId());
			//Order orderItemResult = apiInstance.orderGet(apiClientKeys.getClientId(), apiClientKeys.getAccessToken(), apiClientKeys.getMerchantId(), paymentEntity.getOrderID());
			return response.body().string().contains(StatusEnum.PAID.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
