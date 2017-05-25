package com.sensedia.apix.payment.entity;

import org.springframework.stereotype.Component;

import io.swagger.client.ApiClient;
import io.swagger.client.Configuration;
import io.swagger.client.auth.ApiKeyAuth;

@Component
public class ApiClientKeys {
	
	private ApiKeyAuth merchantId;
	private ApiKeyAuth accessToken;
	private ApiKeyAuth clientId;
	
	public ApiClientKeys(){
		ApiClient defaultClient = Configuration.getDefaultApiClient();

		// Configure API key authorization: merchant-id
		merchantId = (ApiKeyAuth) defaultClient.getAuthentication("merchant-id");
		merchantId.setApiKey("");

		// Configure API key authorization: access-token
		accessToken = (ApiKeyAuth) defaultClient.getAuthentication("access-token");
		accessToken.setApiKey("");

		// Configure API key authorization: client-id
		clientId = (ApiKeyAuth) defaultClient.getAuthentication("client-id");
		clientId.setApiKey("");
	}

	public String getAccessToken() {
		return accessToken.getApiKey();
	}

	public String getClientId() {
		return clientId.getApiKey();
	}

	public String getMerchantId() {
		return merchantId.getApiKey();
	}

}
