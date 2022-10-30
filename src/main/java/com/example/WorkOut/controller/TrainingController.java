package com.example.WorkOut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.WorkOut.model.repository.TrainingRepository;

@Controller
public class TrainingController {
	@Autowired
	private TrainingRepository repository;

	@RequestMapping(value = { "/training" })
	public String Training(Model model) {
		model.addAttribute("trainings", repository.findAll());
		System.out.println(model);
		return "training";
	}
}
