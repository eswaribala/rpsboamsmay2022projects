package com.boa.ecommerce;

import java.time.LocalDate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import com.boa.ecommerce.models.OrderModel;

import lombok.extern.slf4j.Slf4j;

@Component("orderDelegate")
@Slf4j
public class OrderDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		OrderModel orderModel =new OrderModel();
		orderModel.setOrderId(Long.parseLong(execution.getVariable("orderId").toString()));
		orderModel.setAmount(Long.parseLong(execution.getVariable("orderAmount").toString()));
		orderModel.setOrderDate(LocalDate.parse(execution.getVariable("orderDate")
				.toString()));
		log.info("order"+orderModel);
		
	}

}
