package controllers;

import data.model.User;
import dtos.reponses.LoginResponse;
import dtos.reponses.RegisterResponse;
import dtos.requests.DeleteRequest;
import dtos.requests.LoginRequest;
import dtos.requests.RegisterRequest;
import services.UserServicesImpl;

import java.util.ArrayList;
import java.util.List;

public class UserController {
	private UserServicesImpl userServices = new UserServicesImpl();

	public RegisterResponse register(RegisterRequest request) {
		return userServices.createUser(request);
	}

	public LoginResponse login(LoginRequest request){
		return userServices.login(request);
	}

	public  String delete(DeleteRequest request){
		userServices.deleteUser(request);
		return "successfully";
	}
}
