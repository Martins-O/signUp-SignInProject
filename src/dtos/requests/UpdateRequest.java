package dtos.requests;

import lombok.Data;
import lombok.Getter;

@Getter
public class UpdateRequest {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;


}
