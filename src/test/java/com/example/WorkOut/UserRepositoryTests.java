package com.example.WorkOut;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTests {
	/*
	 * @Autowired private UserRepository repository;
	 * 
	 * @Test public void createNewUser() { User user = new User(5, "g@gmail.com",
	 * "jugurtti", "Omena"); repository.save(user);
	 * assertThat(user.getName()).isNotNull();
	 * 
	 * }
	 * 
	 * @Test public void findByAuthorShouldReturnTitle() { User users =
	 * repository.findByUsername("Aki");
	 * assertThat(users.getEmail()).isEqualTo("User1@email.com"); }
	 * 
	 * @Test public void deleteNewBook() { List<User> users =
	 * repository.findByEmail("User1@email.com"); User user = users.get(0);
	 * repository.delete(user); List<User> newUsers =
	 * repository.findByEmail("User1@email.com"); assertThat(newUsers).hasSize(0);
	 */
}
