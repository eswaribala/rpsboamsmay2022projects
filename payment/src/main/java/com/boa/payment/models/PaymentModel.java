package com.boa.payment.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentModel {

	private long transactionId;
	private String transactionDate;
	private boolean state;
	private OrderModel ordeModel;
}
