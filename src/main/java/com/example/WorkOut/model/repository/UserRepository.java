package com.example.WorkOut.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WorkOut.model.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}