package services;

import data.model.User;
import data.repositories.UserRepositoriesImpl;
import dtos.reponses.LoginResponse;
import dtos.reponses.RegisterResponse;
import dtos.reponses.UpdateResponse;
import dtos.requests.ChangePasswordRequest;
import dtos.requests.LoginRequest;
import dtos.requests.RegisterRequest;
import dtos.requests.UpdateRequest;
import exception.signUpSignInException;

public class UserServicesImpl implements UserServices {

	private final UserRepositoriesImpl userRepositories = new UserRepositoriesImpl();
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
	public LoginResponse login(LoginRequest request) throws signUpSignInException {
		if(!request.getPassword().equals(request.getPasswordConfirmation())){
			throw new signUpSignInException("Password Mismatch");
		}
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
	public void deleteUser(String email, String password) {
		User user = validateUser(email, password);
		if (user != null) {
			userRepositories.delete(email);
		}
	}

	@Override
	public void resetPassword(ChangePasswordRequest request) throws signUpSignInException {
		User user = validateUser(request.getEmail(), request.getOldPassword());
		if (user == null) throw new signUpSignInException("Incorrect old password");
		user.setPassword(request.getOldPassword());
			userRepositories.register(user);
	}
	@Override
//	public ChangePasswordResponse resetPassword(ChangePasswordRequest request) {
//		User user = new User();
//		user.setEmail(request.getEmail());
//		user.setPassword(request.getNewPassword());
//		user.setPasswordConfirmation(request.getConfirmNewPassword());
//
//		ChangePasswordResponse response = new ChangePasswordResponse();
//		response.setEmail(user.getEmail());
//		response.setMessage("Password changed");
//		return response;
//	}
	public UpdateResponse updateDetails(UpdateRequest request){
		User toBeUpdated = userRepositories.findByEmail(request.getEmail());
		if(request.getFirstName() != null){
			toBeUpdated.setFirstName(request.getFirstName());
		}
		if(request.getLastName() != null){
			toBeUpdated.setLastName(request.getLastName());
		}
		if(request.getPhoneNumber() != null){
			toBeUpdated.setPhoneNumber(request.getPhoneNumber());
		}

		return new UpdateResponse("updated successfully");
	}

	private  User validateUser(String email, String password){
		User user = userRepositories.findByEmail(email);
		if(user != null && user.getPassword().equals(password)){
			return user;
		}
		return null;
	}
}
