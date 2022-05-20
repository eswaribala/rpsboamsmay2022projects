package com.boa.payment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boa.payment.models.PaymentModel;
import com.boa.payment.services.PaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping({"/v1.0"})
	public ResponseEntity<String> makePayment(@RequestBody PaymentModel paymentModel){
		
		Gson gson=new Gson();
		PaymentModel paymentObj=this.paymentService.addPayment(paymentModel);
		
		if(paymentObj!=null) 
			
			return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(paymentObj));
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Added");
		
	}
	
	@GetMapping({"/v1.0/{transactionId}"})
	public ResponseEntity<String> publishPayment(@PathVariable("transactionId") long transactionId){
		
			
		if(this.paymentService.publishPayment(transactionId)) 
			
			return ResponseEntity.status(HttpStatus.OK).body("Payment Published...");
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Payment not Published...");
		
	}
	

}
