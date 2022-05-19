package com.boa.payment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.payment.models.PaymentModel;
import com.boa.payment.repositories.PaymentRepo;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepo paymentRepo;
	@Autowired
	private OrderConsumerService orderConsumerService;
	
	public PaymentModel addPayment(PaymentModel paymentModel) {
		
	    paymentModel.setOrdeModel(orderConsumerService.getOrderModel());
	    return this.paymentRepo.save(paymentModel);
		
	}

}
