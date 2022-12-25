package dtos.reponses;

import lombok.Data;
import lombok.Setter;

@Setter
public class ChangePasswordResponse {
	private String email;
	private String message;


}
