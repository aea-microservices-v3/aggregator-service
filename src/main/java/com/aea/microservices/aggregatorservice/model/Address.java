package com.aea.microservices.aggregatorservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address
{
	private String username;
	private String address;
	private String city;
	private String state;
	private String pinCode;
}
