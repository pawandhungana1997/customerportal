package com.ektha.customerportal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ektha.customerportal.entity.Customer;
import com.ektha.customerportal.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	@RequestMapping("/list")
	public String viewCustomerList(Model model) {

		List<Customer> customerList = customerService.getAllCustomers();
		//adding attributes to send to the view
		model.addAttribute("customerList", customerList);
		//return the view name
		return "customerlist";
	}
	
	@RequestMapping("/new")
	public String newCustomerForm(Model model) {
		return "customerform";
	}
	
	@RequestMapping("/add")
	public String addCustomer(HttpServletRequest request, Model model) {
		
		Customer customer = new Customer();
		customer.setFirstname(request.getParameter("firstname"));
		customer.setLastname(request.getParameter("lastname"));
		customer.setPhone(request.getParameter("phone"));
		customer.setEmail(request.getParameter("email"));
		
		customerService.saveCustomer(customer);
		return viewCustomerList(model);
	} 
	
	
	@RequestMapping("/edit")
	public String editCustomerForm(HttpServletRequest request, Model model) {
		int customerId = Integer.parseInt(request.getParameter("id"));
		
		Customer customer = customerService.getCustomer(customerId);
		model.addAttribute("customer",customer);
		
		return "customerform";
	}
	
	@RequestMapping("/update")
	public String updateCustomer(HttpServletRequest request, Model model) {
		
		Customer customer = new Customer();
		customer.setId(Integer.parseInt(request.getParameter("id")));
		customer.setFirstname(request.getParameter("firstname"));
		customer.setLastname(request.getParameter("lastname"));
		customer.setEmail(request.getParameter("email"));
		customer.setPhone(request.getParameter("phone"));
		
		customerService.updateCustomer(customer);
		return viewCustomerList(model);
	}
	
	@RequestMapping("/delete")
	public String deleteCustomer(HttpServletRequest request, Model model) {
		int customerId = Integer.parseInt(request.getParameter("id"));
		
		customerService.deleteCustomer(customerId);
		
		return viewCustomerList(model);
	}
}







