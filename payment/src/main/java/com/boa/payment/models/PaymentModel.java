package com.boa.payment.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("payments")
public class PaymentModel {
    @Id
	private long transactionId;
	private String transactionDate;
	private boolean state;
	@ApiModelProperty(hidden = true)
	private OrderModel ordeModel;
}
