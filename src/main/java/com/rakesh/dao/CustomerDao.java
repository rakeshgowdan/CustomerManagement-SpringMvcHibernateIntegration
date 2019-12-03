package com.rakesh.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rakesh.model.Customer;

@Repository
public interface CustomerDao  extends CrudRepository<Customer, Long>{

}
