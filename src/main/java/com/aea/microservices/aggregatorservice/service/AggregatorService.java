package com.aea.microservices.aggregatorservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aea.microservices.aggregatorservice.model.OrderData;
import com.aea.microservices.aggregatorservice.proxy.AddressProxy;
import com.aea.microservices.aggregatorservice.proxy.OrderProxy;

@Service
public class AggregatorService
{
	@Autowired
	private AddressProxy addressProxy;
	
	@Autowired
	private OrderProxy orderProxy;
	
	public OrderData fetchOrderData(final String username, final String productId, final int quantity)
	{
		final OrderData orderData = new OrderData();
		orderData.setUsername(username);
		orderData.setAddress(addressProxy.getAddress(username));
		orderData.setOrder(orderProxy.getOrder(username, productId, quantity));
		return orderData;
	}
}
