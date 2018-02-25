package com.webtracker.practice.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webtracker.practice.entity.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		List<Customer> customers = query.getResultList();
		for(Customer temp: customers){
			System.out.println("Custome: "+temp);
		}
		return customers;
	}

	@Override
	public void saveCustomer(Customer tempCustomer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(tempCustomer);
	}

	@Override
	public Customer getCustomer(int custId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, custId);
	}

	@Override
	public void deleteCustomer(int custId) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.get(Customer.class, custId));
	}

}
