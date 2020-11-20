package com.dpinc.springelasticsearchservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName="dpinc",type="customer",shards=2)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	private String id;
	private String firstname;
	private String lastname;
	private int age;
	
}
