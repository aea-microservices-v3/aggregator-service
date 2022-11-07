package com.aea.microservices.aggregatorservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aea.microservices.aggregatorservice.model.OrderData;
import com.aea.microservices.aggregatorservice.service.AggregatorService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/aggregate")
public class AggregatorController
{
	private static Logger LOG = LoggerFactory.getLogger(AggregatorController.class);
	
	@Autowired
	private AggregatorService aggregatorService;
	
	@GetMapping("")
	@CircuitBreaker(name = "aggregator", fallbackMethod = "getOrderDataFallback")
	public OrderData getOrderData(@RequestParam final String username, @RequestParam final String productId, @RequestParam final int quantity)
	{
		LOG.info("Aggregate order and address data : username -> {}, productId -> {}, quantity -> {}", username, productId, quantity);
		return aggregatorService.fetchOrderData(username, productId, quantity);
	}
	
	@SuppressWarnings("unused")
	private OrderData getOrderDataFallback(final String username, final String productId, final int quantity, final Throwable throwable)
	{
		LOG.info("Fallback aggregate order and address data : username -> {}, productId -> {}, quantity -> {}", username, productId, quantity);
		final OrderData orderData = new OrderData();
		orderData.setUsername(username);
		return orderData;
	}
	
}
