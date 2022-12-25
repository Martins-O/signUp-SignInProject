package dtos.reponses;

import lombok.Data;
import lombok.Setter;

@Setter
public class RegisterResponse {
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;



}
