package com.boa.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.boa.order.facades.OrderFacade;
import com.boa.order.models.OrderModel;

@Service
public class OrderService {

	@Autowired
	private OrderFacade orderFacade;
	
	
	public boolean publishOrder(OrderModel orderModel) {
		
		MessageChannel messageChannel=orderFacade.orderPublishChannel();
		if(orderModel.getAmount()>500) {
		return messageChannel.send(MessageBuilder
                .withPayload(orderModel)
                .setHeader(MessageHeaders.CONTENT_TYPE, 
                		MimeTypeUtils.APPLICATION_JSON)
                .build());
		}
		else
		{
			return false;
		}

		
	}
}
