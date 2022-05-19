package com.boa.payment.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boa.payment.models.PaymentModel;

public interface PaymentRepo extends MongoRepository<PaymentModel, Long> {

}
