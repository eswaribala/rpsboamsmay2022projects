package com.boa.payment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.boa.payment.facades.OrderConsumerFacade;
import com.boa.payment.models.OrderModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderConsumerService {
	
	@StreamListener(target = OrderConsumerFacade.inChannel)
	public void consumeOrder(String message) {
		
	 log.info("Order Received"+message);

		
	}
}
