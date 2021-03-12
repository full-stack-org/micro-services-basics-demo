package com.login.service.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.service.Service.LoginService;
import com.login.service.request.LoginRequest;
import com.login.service.response.LoginResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/login/service/v1")
@Slf4j
public class LoginController {

	@Autowired
	private LoginService loginService;

	/**
	 * 
	 * @param loginRequest
	 * @return
	 */
	@PostMapping("/authenticate")
	public LoginResponse authenticate(@Valid @RequestBody LoginRequest loginRequest) {
		log.info("Enetered in authenticate in LoginController");
		LoginResponse loginResponse = loginService.authenticate(loginRequest);
		log.info("Enetered in authenticate in LoginController");

		return loginResponse;
	}

	/**
	 * 
	 * @param loginRequest
	 * @return
	 */
	@PostMapping("/saveUser")
	public LoginResponse createNewUser(@Valid @RequestBody LoginRequest loginRequest) {
		log.info("Enetered in createNewUser in LoginController");
		LoginResponse loginResponse = loginService.createNewUser(loginRequest);
		log.info("Enetered in createNewUser in LoginController");

		return loginResponse;
	}

}
