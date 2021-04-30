package com.ektha.customerportal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ektha.customerportal.entity.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setId(rs.getInt(1));
		customer.setFirstname(rs.getString(2));
		customer.setLastname(rs.getString(3));
		customer.setPhone(rs.getString(4));
		customer.setEmail(rs.getString(5));
		return customer;
	}

}
