package dtos.requests;

import lombok.Data;
import lombok.Getter;

@Getter
public class LoginRequest {
	private String email;
	private String password;
	private String passwordConfirmation;


}
