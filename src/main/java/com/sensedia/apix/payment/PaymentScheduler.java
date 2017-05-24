package com.sensedia.apix.payment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import com.sensedia.apix.payment.entity.PaymentEntity;
import com.sensedia.apix.payment.service.PaymentRepository;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

@Component
public class PaymentScheduler {

	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private TaskScheduler taskScheduler;

	private OkHttpClient client = new OkHttpClient();

	static Map<String, ScheduledFuture<?>> scheduledFutureMap = new HashMap<String, ScheduledFuture<?>>();

	public void createJob(String orderId) {

		scheduledFutureMap.put(orderId, taskScheduler.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				List<String> removeKeys = new ArrayList<>();
				PaymentEntity paymentEntity = paymentRepository.findById(orderId);
				try {
					Response response = post(paymentEntity.getCallBackUrl(), "{}");
					if(response.isSuccessful()){
						removeKeys.add(paymentEntity.getOrderID());
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

				paymentRepository.removeAll(removeKeys);
			}
		}, TimeUnit.SECONDS.toSeconds(20)));
	}

	public Response post(String url, String json) throws IOException {
		RequestBody body = RequestBody.create(JSON, json);
		Request request = new Request.Builder()
				.url(url)
				.post(body)
				.build();
		Response response = client.newCall(request).execute();
		return response;
	}
}
