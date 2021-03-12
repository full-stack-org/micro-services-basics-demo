package com.forgot.password.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forgot.password.proxy.ForgotPasswordProxy;
import com.forgot.password.request.ForgotPasswordRequest;
import com.forgot.password.response.ForgotPasswordResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/forgot/v1")
@Slf4j
public class ForgotPasswordController {
	
	@Autowired
	private ForgotPasswordProxy forgotPasswordProxy;
	
	@PostMapping("/updatePassword")
	@HystrixCommand(commandKey = "Forgot Password", fallbackMethod = "forgotPasswordFallback")
	public ForgotPasswordResponse updatePassword(@Valid @RequestBody ForgotPasswordRequest forgotPasswordRequest) {
		log.info("Entered in updatePassword of ForgotPasswordController ");
		ForgotPasswordResponse forgotPasswordResponse = forgotPasswordProxy.updatePassword(forgotPasswordRequest);
		log.info("Exit in updatePassword of ForgotPasswordController ");
		return forgotPasswordResponse;
	}
	
	public ForgotPasswordResponse forgotPasswordFallback(ForgotPasswordRequest forgotPasswordRequest) {
		ForgotPasswordResponse forgotPasswordResponse = new ForgotPasswordResponse();
		forgotPasswordResponse.setStatusCode(422);
		return forgotPasswordResponse;
	}

}
