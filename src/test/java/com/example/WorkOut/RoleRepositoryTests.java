package com.example.WorkOut;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.WorkOut.model.domain.Role;
import com.example.WorkOut.model.repository.RoleRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoleRepositoryTests {

	@Autowired
	private RoleRepository repository;

	@Test
	public void findByEmailShouldReturnName() {
		Role roles = repository.findByName("ROLE_ADMIN");
		System.out.println(roles.getId());
		assertThat(roles.getId()).isEqualTo(1);
	}

}
