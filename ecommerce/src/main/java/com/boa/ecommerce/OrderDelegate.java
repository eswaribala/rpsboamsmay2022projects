package com.boa.ecommerce;

import java.time.LocalDate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.boa.ecommerce.models.OrderModel;

import lombok.extern.slf4j.Slf4j;

@Component("orderDelegate")
@Slf4j
public class OrderDelegate implements JavaDelegate {
	@Autowired
	private RestTemplate restTemplate;
	@Value("${orderUrl}")
	private String orderUrl;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		OrderModel orderModel =new OrderModel();
		orderModel.setOrderId(Long.parseLong(execution.getVariable("orderId").toString()));
		orderModel.setAmount(Long.parseLong(execution.getVariable("orderAmount").toString()));
		orderModel.setOrderDate(LocalDate.parse(execution.getVariable("orderDate")
				.toString()));
		log.info("order"+orderModel);
		
	    HttpHeaders headers = new HttpHeaders();
	       headers.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity request = new HttpEntity<>(orderModel,headers);
	    ResponseEntity<?> response=restTemplate.
	 		      postForEntity(orderUrl,request, String.class);
	    execution.setVariable("response", response.getBody());

		
		
	}

}
