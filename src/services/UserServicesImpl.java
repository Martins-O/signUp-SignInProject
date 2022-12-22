package services;

import data.model.User;
import data.repositories.UserRepositoriesImpl;
import dtos.reponses.LoginResponse;
import dtos.reponses.RegisterResponse;
import dtos.reponses.ResetPasswordResponse;
import dtos.requests.DeleteRequest;
import dtos.requests.LoginRequest;
import dtos.requests.RegisterRequest;
import dtos.requests.ResetPasswordRequest;

public class UserServicesImpl implements UserServices {

	private UserRepositoriesImpl userRepositories = new UserRepositoriesImpl();
	@Override
	public RegisterResponse createUser(RegisterRequest request) {
		User user = new User();
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setPassword(request.getPassword());
		user.setPhoneNumber(request.getPhoneNumber());
		if(userRepositories.findByEmail(request.getEmail()) == null)throw new IllegalStateException("Email already exists");

		RegisterResponse response = new RegisterResponse();
		response.setFirstName(user.getFirstName());
		response.setLastName(user.getLastName());
		response.setEmail(user.getEmail());
		response.setPhoneNumber(user.getPhoneNumber());
		return response;
	}

	@Override
	public LoginResponse login(LoginRequest request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setPasswordConfirmation(request.getPasswordConfirmation());

		LoginResponse response = new LoginResponse();
		response.setEmail(user.getEmail());
		response.setMessage("Login successful");

		return response;
	}

	@Override
	public void deleteUser(DeleteRequest request) {
		userRepositories.delete(request.getEmail());
	}

	@Override
	public ResetPasswordResponse resetPassword(ResetPasswordRequest request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setPassword(request.getNewPassword());
		user.setPasswordConfirmation(request.getConfirmNewPassword());

		ResetPasswordResponse response = new ResetPasswordResponse();
		response.setEmail(user.getEmail());
		response.setMessage("Password changed");
		return response;
	}
}
