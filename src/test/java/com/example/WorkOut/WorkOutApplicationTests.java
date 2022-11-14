package com.example.WorkOut;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.WorkOut.controller.AuthController;
import com.example.WorkOut.controller.TrainingController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class WorkOutApplicationTests {
	@Autowired
	private TrainingController trainingControllerTest;

	@Autowired
	private AuthController authenticationControllerTest;

	@Test
	void contextLoads() throws Exception {
		assertThat(trainingControllerTest).isNotNull();
		assertThat(authenticationControllerTest).isNotNull();
	}

}
