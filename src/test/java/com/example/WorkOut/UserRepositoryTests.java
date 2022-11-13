package com.example.WorkOut;

import static org.assertj.core.api.Assertions.assertThat;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.example.WorkOut.model.domain.User;
import com.example.WorkOut.model.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTests {

	@Autowired
	private UserRepository repository;


	@Test
	public void findByEmailShouldReturnName() {
		User users = repository.findByEmail("aki@hietamaki.org");
		assertThat(users.getName()).isEqualTo("Aki Hietamäki");
	}

}