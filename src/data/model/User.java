package data.model;

public class User {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phoneNumber;
	private String passwordConfirmation;

	public User(String firstName, String lastName, String email,
	            String password, String phoneNumber, String passwordConfirmation) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.passwordConfirmation = passwordConfirmation;
	}
	public User(){}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		if(passwordConfirmation != getPassword()) throw new
			IllegalStateException("Invalid password");
		this.passwordConfirmation = passwordConfirmation;
	}

	@Override
	public String toString() {
		return "User{" +
			"firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", email='" + email + '\'' +
			", password='" + password + '\'' +
			", phoneNumber='" + phoneNumber + '\'' +
			", passwordConfirmation='" + passwordConfirmation + '\'' +
			'}';
	}
}
