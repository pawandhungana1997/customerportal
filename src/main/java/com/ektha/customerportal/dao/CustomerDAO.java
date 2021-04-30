package com.ektha.customerportal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ektha.customerportal.entity.Customer;

@Repository
public class CustomerDAO implements Dao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SAVE_CUSTOMER = "insert into customerportal.customer (firstname, lastname, phone, email) values (?,?,?,?)";
	private static final String GET_CUSTOMER = "select * from customerportal.customer where id=?";
	private static final String GET_ALL_CUSTOMERS = "select * from customerportal.customer";
	private static final String UPDATE_CUSTOMER = "update customerportal.customer set firstname=?, lastname=?, phone=?, email=? where id=?";
	private static final String DELETE_CUSTOMER = "delete from customerportal.customer where id=?";

	@Override
	public Customer save(Customer customer) {

		int status = jdbcTemplate.update(SAVE_CUSTOMER, customer.getFirstname(), customer.getLastname(),
				customer.getPhone(), customer.getEmail());

		if (status == 1) {
			return customer;
		}
		return null;
	}

	@Override
	public Customer update(Customer customer) {
		int status = jdbcTemplate.update(UPDATE_CUSTOMER, customer.getFirstname(), customer.getLastname(),
				customer.getPhone(), customer.getEmail(), customer.getId());

		if (status == 1) {
			return customer;
		}
		return null;
	}

	@Override
	public Customer get(int id) {
		
		return jdbcTemplate.queryForObject(GET_CUSTOMER, new Object[] {id},new CustomerRowMapper());
	}

	@Override
	public List<Customer> getAll() {
		return jdbcTemplate.query(GET_ALL_CUSTOMERS, new CustomerRowMapper());
	}

	@Override
	public boolean delete(int id) {
		int status = jdbcTemplate.update(DELETE_CUSTOMER, id);
		if (status == 1) {
			return true;
		}
		return false;
	}

}
