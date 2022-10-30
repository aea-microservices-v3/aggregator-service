package com.aea.microservices.aggregatorservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aea.microservices.aggregatorservice.model.Order;

@FeignClient(name = "order-service")
public interface OrderProxy
{
	@PostMapping("/order")
	public Order getOrder(@RequestParam final String username, @RequestParam final String productId, @RequestParam final int quantity);
}
