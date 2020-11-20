package com.dpinc.springelasticsearchservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dpinc.springelasticsearchservice.model.Customer;
import com.dpinc.springelasticsearchservice.service.CustomerService;


@RestController
public class CustomerController {

	@Autowired
	private CustomerService customService;

	/**
	 * To get health of the app
	 * @return ResponseEntity<String>  - Response entity with HTTP status code
	 */
	@GetMapping("/health")
	public ResponseEntity<String> getHealth() {
		return new ResponseEntity<String>("Successful health check - Customer Service", HttpStatus.OK);
	}

	@PostMapping("/saveCustomers")
	public void saveCustomers(@RequestBody List<Customer> customers) {
		Iterable<Customer>  customersSaved = customService.saveAll(customers);
		System.out.println("Customers Saved = " + customersSaved);
	}

	@GetMapping("/findAll")
	public Iterable<Customer> findAllCustomers() {
		return customService.findAll();
	}

	@GetMapping("/findByFirstName/{firstName}")
	public List<Customer> findByFirstName(@PathVariable String firstName) {
		return customService.findByFirstname(firstName);
	}
	
}
