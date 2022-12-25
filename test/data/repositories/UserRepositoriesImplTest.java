package data.repositories;

import data.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoriesImplTest {

	private UserRepositories repository;

	@BeforeEach
	public void setUp(){
		repository = new UserRepositoriesImpl();
	}

	@Test
	public void registerUserTest(){
		User user = new User();
		user.setFirstName("Martins");
		user.setLastName("Jojolola");
		user.setEmail("Jojolola@gmail.com");
		user.setPassword("LOVE");
		user.setPasswordConfirmation("LOVE");
		user.setPhoneNumber("08146587069");
		repository.register(user);

		assertEquals(1L, repository.count());
	}

	@Test
	public void UserCanUpdateDetailsTest(){
		User user = new User();
		user.setFirstName("Martins");
		user.setLastName("Jojolola");
		user.setEmail("Jojolola@gmail.com");
		user.setPassword("LOVE");
		user.setPasswordConfirmation("LOVE");
		user.setPhoneNumber("08146587069");
		repository.register(user);

		User updateUser = new User();
		updateUser.setEmail("Jojolola@gmail.com");
		updateUser.setPhoneNumber("2348146587069");
		updateUser.setFirstName("Martin");
		updateUser.setLastName("Joolola");
		repository.updateUser(updateUser);

		assertEquals(1L, repository.count());
		assertEquals("Martin",
			user.getFirstName());
	}

	@Test
	public void findByEmailTest(){
		User user = new User();
		User user1 = new User();
		user1.setEmail("john@example.com");
		User user2 = new User();
		User user3 = new User();
		repository.register(user);
		repository.register(user1);
		repository.register(user2);
		repository.register(user3);

		assertEquals(user1, repository.findByEmail("jojolola@gmail.com"));
	}
}