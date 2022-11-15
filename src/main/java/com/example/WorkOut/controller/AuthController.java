package com.example.WorkOut.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.WorkOut.model.domain.User;
import com.example.WorkOut.model.domain.UserDto;

//Handles authentication related requests
@Controller
public class AuthController {

	private UserService userService;

	public AuthController(UserService userService) {
		this.userService = userService;
	}

	// handler method for home page request
	@GetMapping("/index")
	public String home() {
		return "index";
	}

	// handler method for user login request
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	// handler method for reqister form request
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "register";
	}

	// handler method for register user request
	@RequestMapping(value = "/register/save", method = RequestMethod.POST)
	public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {
		User existingUser = userService.findUserByEmail(userDto.getEmail());
		if (result.hasErrors()) {
			model.addAttribute("user", userDto);
			return "register";
		}
		if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
			result.rejectValue("email", null, "There is another account registered with the same email");
		}

		userService.saveUser(userDto);
		return "redirect:/register?success";
	}

	// handler method to userlist request
	@GetMapping("/users")
	public String users(Model model) {
		List<UserDto> users = userService.findAllUsers();
		model.addAttribute("users", users);
		return "users";
	}
}
