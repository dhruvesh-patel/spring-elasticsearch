package com.dpinc.springelasticsearchservice.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.dpinc.springelasticsearchservice.model.Customer;

public interface CustomerRepository extends ElasticsearchRepository<Customer, String>{

	List<Customer> findByFirstname(String firstName);

}
