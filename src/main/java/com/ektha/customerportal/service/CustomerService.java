package com.ektha.customerportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ektha.customerportal.dao.CustomerDAO;
import com.ektha.customerportal.entity.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerDAO customerDAO;

	public Customer saveCustomer(Customer customer) {
		return customerDAO.save(customer);
	}
	
	public Customer getCustomer(int id) {
		return customerDAO.get(id);
	}
	
	public List<Customer> getAllCustomers() {
		return customerDAO.getAll();
	}
	
	public Customer updateCustomer(Customer customer) {
		return customerDAO.update(customer);
	}
	
	public boolean deleteCustomer(int id) {
		return customerDAO.delete(id);
	}

}
