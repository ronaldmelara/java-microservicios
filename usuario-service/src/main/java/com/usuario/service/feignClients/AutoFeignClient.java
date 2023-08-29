package com.usuario.service.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usuario.service.modelos.Auto;

@FeignClient(name = "auto-service", url ="http://localhost:8002")
@RequestMapping("/auto")
public interface AutoFeignClient {
	
	public Auto save(@RequestBody Auto auto);

}
