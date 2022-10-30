package com.aea.microservices.aggregatorservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderData
{
	private String username;
	private Address address;
	private Order order;
}
