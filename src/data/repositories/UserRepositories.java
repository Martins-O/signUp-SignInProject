package data.repositories;

import data.model.User;

import java.util.ArrayList;
import java.util.List;

public interface UserRepositories {
	User findByEmail(String email);
	User register(User user);
	void delete(String email);
}
