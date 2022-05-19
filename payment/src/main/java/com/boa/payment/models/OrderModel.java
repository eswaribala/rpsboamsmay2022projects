package com.boa.payment.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {

	private long orderId;
	private String orderDate;
	private long amount;
}
