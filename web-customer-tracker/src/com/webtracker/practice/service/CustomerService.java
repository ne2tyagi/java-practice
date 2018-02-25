package com.webtracker.practice.service;

import java.util.List;

import com.webtracker.practice.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer tempCustomer);

	public Customer getCustomer(int customerId);

	public void deleteCustomer(int tempCustomer);
}
