package com.aea.microservices.aggregatorservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aea.microservices.aggregatorservice.model.Address;

@FeignClient(name = "address-service")
public interface AddressProxy
{
	@GetMapping("/address/{username}")
	public Address getAddress(@PathVariable final String username);
}
