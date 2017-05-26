package com.sensedia.apix.payment.entity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.swagger.client.ApiClient;
import io.swagger.client.Configuration;
import io.swagger.client.auth.ApiKeyAuth;

@Component
public class ApiClientKeys {
	
	private ApiClient defaultClient; 
	
	private ApiKeyAuth merchantId;
	private ApiKeyAuth accessToken;
	private ApiKeyAuth clientId;
	
	@Value("${base-path}")
	private String basePath;
	
	@Value("${merchant-id}")
	private String merchantIdKey;
	
	@Value("${access-token}")
	private String accessTokenKey;
	
	@Value("${client-id}")
	private String clientIdKey;
	
	public ApiClientKeys(){
		defaultClient = Configuration.getDefaultApiClient();

		// Configure API key authorization: merchant-id
		merchantId = (ApiKeyAuth) defaultClient.getAuthentication("merchant-id");

		// Configure API key authorization: access-token
		accessToken = (ApiKeyAuth) defaultClient.getAuthentication("access-token");

		// Configure API key authorization: client-id
		clientId = (ApiKeyAuth) defaultClient.getAuthentication("client-id");
	}
	
	@PostConstruct
	public void setKeys(){
		defaultClient.setBasePath(basePath);
		merchantId.setApiKey(merchantIdKey);
		accessToken.setApiKey(accessTokenKey);
		clientId.setApiKey(clientIdKey);
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
