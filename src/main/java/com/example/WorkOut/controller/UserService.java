package com.example.WorkOut.controller;

import java.util.List;

import com.example.WorkOut.model.domain.User;
import com.example.WorkOut.model.domain.UserDto;

public interface UserService {
	void saveUser(UserDto userDto);

	User findUserByEmail(String email);

	List<UserDto> findAllUsers();
}
