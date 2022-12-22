package services;

import data.model.User;
import dtos.reponses.LoginResponse;
import dtos.reponses.RegisterResponse;
import dtos.requests.DeleteRequest;
import dtos.requests.LoginRequest;
import dtos.requests.RegisterRequest;

public interface UserServices {

	RegisterResponse createUser(RegisterRequest request);

	LoginResponse login(LoginRequest request);

	void deleteUser(DeleteRequest request);


}
