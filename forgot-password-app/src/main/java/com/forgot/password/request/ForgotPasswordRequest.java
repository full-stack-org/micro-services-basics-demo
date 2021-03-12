package com.forgot.password.request;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForgotPasswordRequest {

	@NotEmpty(message = "User Id is Mandatory")
	private String userId;

	@NotEmpty(message = "Password is Mandatory")
	private String password;
}
