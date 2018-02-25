package com.webtracker.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webtracker.practice.entity.Customer;
import com.webtracker.practice.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	//@RequestMapping(path="/list", method=RequestMethod.GET)
	@GetMapping("/list")
	public String listCustomers(Model theModel){
		List<Customer> customers = customerService.getCustomers();
		theModel.addAttribute("customers",customers);
		return "customer-list";
	}
	
	@RequestMapping(path="/showCustomerForm", method=RequestMethod.GET)
	public String addCustomerForm(Model theModel){
		Customer tempCustomer = new Customer();
		theModel.addAttribute(tempCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer tempCustomer){
		customerService.saveCustomer(tempCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(int customerId, Model theModel){
		Customer customer = customerService.getCustomer(customerId);
		theModel.addAttribute("customer", customer);
		return "customer-form";
	}
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int custId){
		customerService.deleteCustomer(custId);
		return "redirect:/customer/list";
	}
}
