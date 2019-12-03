package com.rakesh.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rakesh.model.Customer;
import com.rakesh.service.CustomerService;
import com.sun.javafx.collections.MappingChange.Map;

@Controller
public class CustomerController {

	
	@Autowired(required = true)
	CustomerService cs;
	
	
	@RequestMapping("/")
	public ModelAndView home() {
	    List<Customer> listCustomer = cs.listAll();
	    ModelAndView mav = new ModelAndView("index");
	    mav.addObject("listCustomer", listCustomer);
	    return mav;
	}
	@RequestMapping("/new")
	public String newCustomerForm(HashMap<String, Object> model) { //modelap
	    Customer customer = new Customer();
	    model.put("customer", customer);
	    return "new_customer";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
	    cs.save(customer);
	    return "redirect:/";
	}
	@RequestMapping("/edit")
	public ModelAndView editCustomerForm(@RequestParam long id) {
	    ModelAndView mav = new ModelAndView("edit_customer");
	    Customer customer = cs.get(id);
	    mav.addObject("customer", customer);
	 
	    return mav;
	}
	@RequestMapping("/delete")
	public String deleteCustomerForm(@RequestParam long id) {
	    cs.delete(id);
	    return "redirect:/";       
	}
}
