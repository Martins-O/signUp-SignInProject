package data.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class User {

	@NonNull
	private String firstName;

	@NonNull
	private String lastName;

	@NonNull
	private String email;

	@NonNull
	private String password;

	private String phoneNumber;

	private String passwordConfirmation;

}
