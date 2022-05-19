package com.boa.payment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.boa.payment.facades.PaymentFacade;
import com.boa.payment.models.OrderModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderConsumerService {
	private ObjectMapper objectMapper;
	private OrderModel orderModel;
	@StreamListener(target = PaymentFacade.inChannel)
	public void consumeOrder(String message) {
		
	 log.info("Order Received"+message);

	 objectMapper=new ObjectMapper();
	 try {
		orderModel=objectMapper.readValue(message,OrderModel.class);
		log.info("Java Object"+orderModel);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
		
	}
}
