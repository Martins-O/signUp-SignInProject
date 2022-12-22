package data.repositories;

import data.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoriesImpl implements UserRepositories{

	List<User> usersDb = new ArrayList<>();

	@Override
	public User findByEmail(String email) {
		for(User user : usersDb){
			if(user.getEmail().equals(email)){
				return user;
			}
		}
		return null;
	}

	@Override
	public User register(User user) {
		if(findByEmail(user.getEmail()) == null){
			usersDb.add(user);
		}
		return user;
	}

	@Override
	public void delete(String email) {
		for(User user : usersDb){
			if(user.getEmail().equals(email)){
				usersDb.remove(user);
				break;
			}
		}
	}

	@Override
	public void updateUser(User user) {
		User savedUser = findByEmail(user.getEmail());
		savedUser.setFirstName(user.getFirstName());
		savedUser.setLastName(user.getLastName());
		savedUser.setPhoneNumber(user.getPhoneNumber());
	}


}
