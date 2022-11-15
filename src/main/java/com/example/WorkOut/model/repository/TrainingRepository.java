package com.example.WorkOut.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.WorkOut.model.domain.Training;

public interface TrainingRepository extends CrudRepository<Training, Long> {
	List<Training> findByName(String name);

	List<Training> findByEmail(String email);

	Training findById(long id);

}
