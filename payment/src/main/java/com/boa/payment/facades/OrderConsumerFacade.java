package com.boa.payment.facades;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderConsumerFacade {
	
	String inChannel="order-in";
	
	@Input(inChannel)
	MessageChannel orderConsumerChannel();

}
