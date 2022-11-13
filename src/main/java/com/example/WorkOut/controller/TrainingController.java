package com.example.WorkOut.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.WorkOut.model.domain.Training;
import com.example.WorkOut.model.domain.User;
import com.example.WorkOut.model.repository.TrainingRepository;

@Controller
public class TrainingController {
	
	@Autowired
	private TrainingRepository repository;
	

	@RequestMapping(value = { "/training" })
	public String Training(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("trainings", repository.findByEmail(auth.getName()));
		return "training";
	}
	
	@RequestMapping(value = { "/adminTraining" })
	public String adminTraining(Model model) {
		model.addAttribute("trainings", repository.findAll());
		return "adminTraining";
	}
	
	@RequestMapping(value = "/adminadd")
	public String addTraining(Model model) {
		model.addAttribute("trainings", repository.findAll());
		model.addAttribute("training", new Training());
		return "adminadd";
	}
	
	@RequestMapping(value = "/adminsave", method = RequestMethod.POST)
	public String adminsave(@Valid Training training, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "adminadd";
		}
		repository.save(training);
		return "redirect:adminTraining";
	}

	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		
		model.addAttribute("training", new Training());
		return "addtraining";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Training training, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "addtraining";
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		training.setEmail(auth.getName());
		repository.save(training);
		return "redirect:training";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteTraining(@PathVariable("id") Long trainingId, Model model) {
		repository.deleteById(trainingId);
		return "redirect:../training";
	}
	
	@RequestMapping(value = "/admindelete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteTrainingAdmin(@PathVariable("id") Long trainingId, Model model) {
		repository.deleteById(trainingId);
		return "redirect:../adminTraining";
	}

	@RequestMapping(value = "/edit/{id}")
	public String editTraining(@PathVariable("id") Long trainingId, Model model) {
		model.addAttribute("training", repository.findById(trainingId));
		return "editTraining";
	}

}
