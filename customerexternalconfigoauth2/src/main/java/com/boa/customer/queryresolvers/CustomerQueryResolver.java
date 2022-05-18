package com.boa.customer.queryresolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.customer.models.Customer;
import com.boa.customer.services.CustomerService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
@Component
public class CustomerQueryResolver implements GraphQLQueryResolver{
	@Autowired
	private CustomerService customerService;
	
    public List<Customer> findAllCustomers(){
    	return this.customerService.getAllCustomers();
    }
	
	public Customer findCustomer(long customerId) {
		return this.customerService.getCustomerById(customerId);
	}
    
}
