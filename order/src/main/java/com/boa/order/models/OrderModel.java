package com.boa.order.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {

	private long orderId;
	private LocalDate orderDate;
	private long amount;
}
