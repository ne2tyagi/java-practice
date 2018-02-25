package com.webtracker.practice.dao;

import java.util.List;

import com.webtracker.practice.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer tempCustomer);
	
	public Customer getCustomer(int custId);

	public void deleteCustomer(int custId);
}
