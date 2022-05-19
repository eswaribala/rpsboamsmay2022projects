package com.boa.order.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.order.models.OrderModel;
import com.boa.order.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
	private OrderService orderService;
    
    @PostMapping({"/v1.0"})
    public ResponseEntity<String> publishOrder(@RequestBody OrderModel orderModel){
    	
    	if(orderService.publishOrder(orderModel)) {
    		return ResponseEntity.status(HttpStatus.OK).body("Message Published....."); 
    	}
    	else
    	{
    		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Message Not Published....."); 
    	}
    }
}
