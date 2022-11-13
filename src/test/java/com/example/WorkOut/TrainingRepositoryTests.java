package com.example.WorkOut;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.WorkOut.model.domain.Training;
import com.example.WorkOut.model.repository.TrainingRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TrainingRepositoryTests {
	/*@Autowired
	private TrainingRepository trepository;

	@Test
	public void findByName() {
		List<Training> trainings = trepository.findByName("Laski Jaakko");
		assertThat(trainings).hasSize(1);
		assertThat(trainings.get(0).getTime()).isEqualTo("9:30");
	}

	@Test
	public void createNewTraining() {
		Date date = new GregorianCalendar(2022, Calendar.NOVEMBER, 11).getTime();
		Training training = new Training(0, "Laski Jaakko", "Laskijumppa", "34 min", date, "9:30");
		trepository.save(training);
		assertThat(training.getId()).isNotNull();
	}

	@Test
	public void deleteNewTraining() {
		List<Training> trainings = trepository.findByName("Laski Jaakko");
		Training training = trainings.get(0);
		trepository.delete(training);
		List<Training> newTrainings = trepository.findByName("Laski Jaakko");
		assertThat(newTrainings).hasSize(0);
	}*/

}
