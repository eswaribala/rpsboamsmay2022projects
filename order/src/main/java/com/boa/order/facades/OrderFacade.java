package com.boa.order.facades;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderFacade {
	
	String outChannel="order-out";
	
	@Output(outChannel)
	MessageChannel orderPublishChannel();

}
