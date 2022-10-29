package com.example.WorkOut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrainingController {
	@RequestMapping("/training")
	public String indexMsg() {
		return "training";
	}
}
