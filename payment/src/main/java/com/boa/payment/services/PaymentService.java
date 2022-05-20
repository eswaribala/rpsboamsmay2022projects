package com.boa.payment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.boa.payment.facades.PaymentFacade;
import com.boa.payment.models.PaymentModel;
import com.boa.payment.repositories.PaymentRepo;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepo paymentRepo;
	@Autowired
	private OrderConsumerService orderConsumerService;
	@Autowired
	private PaymentFacade paymentFacade;
	
	public PaymentModel addPayment(PaymentModel paymentModel) {
		
	    paymentModel.setOrdeModel(orderConsumerService.getOrderModel());
	    return this.paymentRepo.save(paymentModel);
		
	}
	
	
	public boolean publishPayment(long transactionId) {
		
		PaymentModel paymentModel=this.paymentRepo.findById(transactionId).orElse(null);
		
		MessageChannel messageChannel=paymentFacade.paymentPublisherChannel();
		
		return messageChannel.send(MessageBuilder
                .withPayload(paymentModel)
                .setHeader(MessageHeaders.CONTENT_TYPE, 
                		MimeTypeUtils.APPLICATION_JSON)
                .build());
	}

}
