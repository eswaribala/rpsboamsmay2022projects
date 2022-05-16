package com.boa.customer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.customer.models.Customer;
import com.boa.customer.services.CustomerService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;	
	private Gson gson;	
	
	//adding customer
	@PostMapping({"/v1.0/"})
	public ResponseEntity<String> addv10Customer(@RequestBody Customer customer){
		gson=new Gson();
		
		if(this.customerService.addCustomer(customer)!=null)
			return ResponseEntity.status(HttpStatus.OK)
					.body(gson.toJson(customer));
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Customer Not Added");
	}
	
	@PostMapping({"/v1.1/"})
	public ResponseEntity<String> addV11Customer(@RequestBody Customer customer){
		gson=new Gson();
		
		if(this.customerService.addCustomer(customer)!=null)
			return ResponseEntity.status(HttpStatus.OK)
					.body(gson.toJson(customer));
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Customer Not Added");
	}
}
