package com.usuario.service.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usuario.service.modelos.Auto;

@FeignClient(name = "auto-service", url ="http://localhost:8002", path="/auto")
//@RequestMapping("/auto")
public interface AutoFeignClient {
	
	@PostMapping()
	public Auto save(@RequestBody Auto auto);

}
