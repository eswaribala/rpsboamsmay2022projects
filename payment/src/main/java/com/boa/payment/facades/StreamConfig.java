package com.boa.payment.facades;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(OrderConsumerFacade.class)
public class StreamConfig {

}
