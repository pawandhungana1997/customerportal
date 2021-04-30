/**
 * 
 */
package com.ektha.customerportal.dao;

import java.util.List;

import com.ektha.customerportal.entity.Customer;

public interface Dao {
	
	Customer save(Customer customer);
	Customer get(int id);
	List<Customer> getAll();
	Customer update(Customer customer);
	boolean delete(int id);
}
