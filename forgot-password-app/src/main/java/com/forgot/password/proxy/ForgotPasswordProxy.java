package com.forgot.password.proxy;

import javax.validation.Valid;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.forgot.password.request.ForgotPasswordRequest;
import com.forgot.password.response.ForgotPasswordResponse;

@FeignClient(name = "zuul-gate-way-app")
@RibbonClient(name = "login-service")
public interface ForgotPasswordProxy {

	@PostMapping("/login-service/login/service/v1/saveUser")
	ForgotPasswordResponse updatePassword(@Valid @RequestBody ForgotPasswordRequest forgotPasswordRequest);

}
