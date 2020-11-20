package com.dpinc.springelasticsearchservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpinc.springelasticsearchservice.model.Customer;
import com.dpinc.springelasticsearchservice.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public Iterable<Customer> saveAll(List<Customer> customers) {
		return customerRepository.saveAll(customers);
	}

	public Iterable<Customer> findAll() {
		return customerRepository.findAll();
	}

	public List<Customer> findByFirstname(String firstName) {
		return customerRepository.findByFirstname(firstName);
	}
	
	

}
