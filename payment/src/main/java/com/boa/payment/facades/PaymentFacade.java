package com.boa.payment.facades;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PaymentFacade {
	
	String inChannel="order-in";
	String outChannel="payment-out";
	
	@Input(inChannel)
	MessageChannel orderConsumerChannel();
	
	@Output(outChannel)
	MessageChannel paymentPublisherChannel();
}
