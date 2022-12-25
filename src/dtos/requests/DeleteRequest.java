package dtos.requests;

import lombok.Data;
import lombok.Getter;

@Getter
public class DeleteRequest {
	private String email;
	private String password;


}
