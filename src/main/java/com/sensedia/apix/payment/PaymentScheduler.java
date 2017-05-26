package com.sensedia.apix.payment;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sensedia.apix.payment.entity.PaymentEntity;
import com.sensedia.apix.payment.entity.json.PaymentBody;
import com.sensedia.apix.payment.service.PaymentRepository;
import com.sensedia.apix.payment.service.PaymentService;
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
	private PaymentService paymentService;

	@Autowired
	private TaskScheduler taskScheduler;

	private OkHttpClient client = new OkHttpClient();

	static Map<String, ScheduledFuture<?>> scheduledFutureMap = new HashMap<String, ScheduledFuture<?>>();

	public void createJob(String orderId) {

		scheduledFutureMap.put(orderId, taskScheduler.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				PaymentEntity paymentEntity = paymentRepository.findById(orderId);
				try {
					boolean isPaid = paymentService.isPaid(orderId, paymentEntity.getPaymentProvider());

					if(isPaid){
						PaymentBody paymentBody = new PaymentBody();
						paymentBody.setRemoteID(paymentEntity.getRemoteID());
						ObjectMapper mapper = new ObjectMapper();
						String value = mapper.writeValueAsString(paymentBody);
						Response response = post(paymentEntity.getCallBackUrl(), value);
						if(response.isSuccessful()){
							paymentRepository.remove(paymentEntity.getOrderID());
							removeJob(orderId);
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}, 30000));
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

	public void removeJob(String orderId) {
		ScheduledFuture<?> scheduledFuture = scheduledFutureMap.get(orderId);
		if (scheduledFuture != null) {
			scheduledFuture.cancel(false);
		}
	}
}
