package com.rakesh.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakesh.dao.CustomerDao;
import com.rakesh.model.Customer;

@Service
@Transactional
public class CustomerService {
	
	@Autowired(required = true)
	CustomerDao cd;

	public void save(Customer customer) {
		cd.save(customer);
    }
     
    public List<Customer> listAll() {
        return (List<Customer>) cd.findAll();
    }
     
    public Customer get(Long id) {
        return cd.findById(id).get();
    }
     
    public void delete(Long id) {
    	cd.deleteById(id);
    }
}
