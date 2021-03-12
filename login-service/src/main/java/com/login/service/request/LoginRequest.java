package com.login.service.request;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

	@NotEmpty(message = "User Id is Mandatory")
	private String userId;

	@NotEmpty(message = "Password is Mandatory")
	private String password;
}
