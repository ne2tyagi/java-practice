package com.springpractice.mvcdemo;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;
	@Value("#{languages}")
	private LinkedHashMap<String, String> languages;
	@Value("#{os}")
	private LinkedHashMap<String, String> operatingSystems;
	@RequestMapping("/showForm")
	public String showForm(Model theModel){
		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);
		theModel.addAttribute("countryOptions", countryOptions);
		theModel.addAttribute("languages", languages);
		theModel.addAttribute("operatingSystems", operatingSystems);
		return "student-form";
	}
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent){
		System.out.println(theStudent.getFirstName());
		return "student-confirmation";
	}
}
