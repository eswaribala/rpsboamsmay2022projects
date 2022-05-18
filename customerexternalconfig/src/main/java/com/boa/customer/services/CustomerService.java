package com.boa.customer.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.customer.models.Customer;
import com.boa.customer.models.FullName;
import com.boa.customer.repositories.CustomerRepo;

@Service
public class CustomerService {
    @Autowired
	private CustomerRepo customerRepo;
    
    //insert
    public Customer addCustomer(Customer customer) {
    	return this.customerRepo.save(customer);
    }
    
    public Customer addV1Customer(Customer customer) {
    	if(customer.getDob().isBefore(LocalDate.now()))
    	  return this.customerRepo.save(customer);
    	else
    		return null;
    }
    
    //select all
    
    public List<Customer> getAllCustomers(){
    	return this.customerRepo.findAll();
    }
    
    //select by id
    
    public Customer getCustomerById(long customerId) {
    	return this.customerRepo.findById(customerId).orElse(null);
    }
    
    //delete by id
    
    public boolean deleteCustomerById(long customerId) {
    	boolean status=false;
    	this.customerRepo.deleteById(customerId);
    	if(this.getCustomerById(customerId)==null)
    		status=true;
    	return status;
    	
    }
    
    
    //update by id
    public Customer updateCustomerById(long customerId,FullName name) {
    	Customer customer=this.getCustomerById(customerId);
    	if(customer!=null)
    	{
    		customer.setName(name);
    	    return this.customerRepo.save(customer);
    	}
    	else
    		return null;
    }
	
}
