package dtos.requests;

public class LoginRequest {
	private String email;
	private String password;
	private String passwordConfirmation;

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}
