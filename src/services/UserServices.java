package services;

import dtos.reponses.LoginResponse;
import dtos.reponses.RegisterResponse;
import dtos.reponses.ChangePasswordResponse;
import dtos.reponses.UpdateResponse;
import dtos.requests.*;
import exception.signUpSignInException;

public interface UserServices {

	RegisterResponse createUser(RegisterRequest request);

	LoginResponse login(LoginRequest request) throws signUpSignInException;

	void deleteUser(String email, String password);

	void resetPassword(ChangePasswordRequest request) throws signUpSignInException;
	UpdateResponse updateDetails(UpdateRequest request);


}
