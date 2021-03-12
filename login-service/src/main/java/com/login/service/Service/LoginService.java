package com.login.service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.login.service.entity.LoginEntity;
import com.login.service.repository.LoginRepository;
import com.login.service.request.LoginRequest;
import com.login.service.response.LoginResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	/**
	 * 
	 * @param loginRequest
	 * @return
	 */
	public LoginResponse authenticate(LoginRequest loginRequest) {
		log.info("Enetered in authenticate");
		LoginResponse loginResponse = new LoginResponse();
		try {
			LoginEntity serviceResponse = loginRepository.findByUserIdAndPassword(loginRequest.getUserId(),
					loginRequest.getPassword());

			if (serviceResponse != null && StringUtils.hasText(serviceResponse.getUserId())) {
				loginResponse.setAuthenticated(true);
				loginResponse.setStatusCode(200);
			} else {
				loginResponse.setStatusCode(400);
			}

		} catch (Exception e) {
			log.error("Exception while authentication ", e.getMessage());
		}

		log.info("Enetered in authenticate");
		return loginResponse;
	}

	/**
	 * 
	 * @param loginRequest
	 * @return
	 */
	public LoginResponse createNewUser(LoginRequest loginRequest) {
		log.info("Enetered in createNewUser");
		LoginResponse loginResponse = new LoginResponse();
		try {

			LoginEntity serviceInput = new LoginEntity();
			serviceInput.setUserId(loginRequest.getUserId());
			serviceInput.setPassword(loginRequest.getPassword());

			LoginEntity serviceResponse = loginRepository.save(serviceInput);

			if (serviceResponse.getId() > 1) {
				loginResponse.setStatusCode(200);
			}

		} catch (Exception e) {
			log.error("Exception while createNewUser ", e.getMessage());
		}

		log.info("Enetered in createNewUser");
		return loginResponse;
	}

}
