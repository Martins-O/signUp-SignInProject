package dtos.requests;

public class ResetPasswordRequest {
	private String email;
	private String newPassword;
	private String confirmNewPassword;

	public String getEmail() {
		return email;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

}
