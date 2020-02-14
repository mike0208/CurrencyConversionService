package com.mikeworks.currencyconversionservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mikeworks.currencyconversionservice.bean.CurrencyConversionBean;

//@FeignClient(name = "currency-exchange-service",url = "localhost:8000")




//@FeignClient(name = "currency-exchange-service")



@FeignClient(name = "zuul-api-gateway-server")
@RibbonClient  // for load balancing without it, call will direct to single instance only 
public interface CurrencyExchangeProxy {

	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	
	
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from , @PathVariable("to") String to);
}
