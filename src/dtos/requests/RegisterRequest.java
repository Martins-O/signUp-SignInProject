package dtos.requests;

import lombok.Data;
import lombok.Getter;

@Getter
public class RegisterRequest {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phoneNumber;


}
