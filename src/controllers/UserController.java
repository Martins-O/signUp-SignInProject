package controllers;

import dtos.reponses.LoginResponse;
import dtos.reponses.RegisterResponse;
import dtos.requests.ChangePasswordRequest;
import dtos.requests.LoginRequest;
import dtos.requests.RegisterRequest;
import exception.signUpSignInException;
import services.UserServicesImpl;

public class UserController {
	private UserServicesImpl userServices = new UserServicesImpl();

	public RegisterResponse register(RegisterRequest request) {
		return userServices.createUser(request);
	}

	public LoginResponse login(LoginRequest request) throws signUpSignInException {
		return userServices.login(request);
	}

	public String resetPassword(ChangePasswordRequest request) throws signUpSignInException {
		userServices.resetPassword(request);
		return "Successfully";
	}

	public  String delete(String email, String password){
		userServices.deleteUser(email, password);
		return "successfully";
	}
}
