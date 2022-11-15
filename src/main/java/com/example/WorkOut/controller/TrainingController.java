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
import com.example.WorkOut.model.repository.TrainingRepository;
import com.example.WorkOut.model.repository.UserRepository;

//Handles request for the main pages 
@Controller
public class TrainingController {

	@Autowired
	private TrainingRepository repository;

	@Autowired
	private UserRepository urepository;

	// handler method for training request
	@RequestMapping(value = { "/training" })
	public String Training(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("trainings", repository.findByEmail(auth.getName()));
		return "training";
	}

	// handler method to admintraining request
	@RequestMapping(value = { "/adminTraining" })
	public String adminTraining(Model model) {
		model.addAttribute("trainings", repository.findAll());
		return "adminTraining";
	}

	// handler method to adminadd form request
	@RequestMapping(value = "/adminadd")
	public String addTraining(Model model) {
		model.addAttribute("users", urepository.findAll());
		model.addAttribute("training", new Training());
		return "adminadd";
	}

	// handler method to adminsave request
	@RequestMapping(value = "/adminsave", method = RequestMethod.POST)
	public String adminsave(@Valid Training training, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("users", urepository.findAll());
			return "adminadd";
		}
		repository.save(training);
		return "redirect:adminTraining";
	}

	// handler method to add request
	@RequestMapping(value = "/add")
	public String addBook(Model model) {

		model.addAttribute("training", new Training());
		return "addtraining";
	}

	// handler method to save request
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Training training, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "addtraining";
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		training.setEmail(auth.getName());
		repository.save(training);
		return "redirect:/training";
	}

	// handler method to delete request
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteTraining(@PathVariable("id") Long trainingId, Model model) {
		repository.deleteById(trainingId);
		return "redirect:../training";
	}

	// handler method to admindelete request
	@RequestMapping(value = "/admindelete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteTrainingAdmin(@PathVariable("id") Long trainingId, Model model) {
		repository.deleteById(trainingId);
		return "redirect:../adminTraining";
	}

	// handler method to edit request
	@RequestMapping(value = "/edit/{id}")
	public String editTraining(@PathVariable("id") Long trainingId, Model model) {
		model.addAttribute("training", repository.findById(trainingId));
		return "editTraining";
	}

	// handler method to adminedit request
	@RequestMapping(value = "/adminedit/{id}")
	public String editAdminTraining(@PathVariable("id") Long trainingId, Model model) {
		model.addAttribute("users", urepository.findAll());
		model.addAttribute("training", new Training());
		model.addAttribute("training", repository.findById(trainingId));
		return "adminedit";
	}

}
