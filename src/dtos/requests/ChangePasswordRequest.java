package dtos.requests;

import lombok.Data;
import lombok.Getter;

@Getter
public class ChangePasswordRequest {
	private String oldPassword;
	private  String newPassword;
	private String email;

}
