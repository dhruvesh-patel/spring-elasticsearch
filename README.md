This repo demonstrates usage of Elastic Search with Spring Data an Spring boot for simple search. We will create Customer document, save data in it & then search based on first name of customer. Elastic search is full text search engine based on Lucene library, it searches based on index (called inverted index). 

Pre-requisite:
1) JDK 11
2) Eclipse / IntelliJ IDE 
3) Maven (if not part of IDE already)

Steps to Setup :

1. Install ElasticSearch on laptop.
```
- Download Elastic Search latest version - https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-7.8.0-windows-x86_64.zip
- Extract the zip file
- Goto C:\Softwares\elasticsearch-7.8.0-windows-x86_64\elasticsearch-7.8.0\config and edit "elasticsearch.yml" file for below values.
cluster.name: dpinc-elastic-search-cluster
path.data: C:\Java-Hands-on\spring-elastic-search\es-path-data
- Run "C:\Softwares\elasticsearch-7.8.0-windows-x86_64\elasticsearch-7.8.0\bin\elasticsearch.bat" file and make sure it starts well (look for log with - started).
```

2. Clone the application
```
https://github.com/dhruvesh-patel/spring-elasticsearch.git
```
3. Build and run the app using IDE / maven
```
mvn clean install 
mvn spring-boot:run
The app will start running - check app health using http://localhost:8751/health.
```
4. Explore Rest APIs. This app defines following CRUD APIs.
```
POST http://localhost:8751/saveCustomers

[
  {
	  "id":"1",
	  "firstname" : "Peter",
	  "lastname" : "Roberts",
	  "age" : 45
  },
  {
	  "id":"2",
	  "firstname" : "Tina",
	  "lastname" : "Smith",
	  "age" : 48
  },
  {
	  "id":"3",
	  "firstname" : "Carrie",
	  "lastname" : "Johnson",
	  "age" : 51
  },
  {
	  "id":"4",
	  "firstname" : "PETER",
	  "lastname" : "Roberts",
	  "age" : 45
  }
]

GET http://localhost:8751/findAll - This will return all records from database

GET http://localhost:8751/findByFirstName/peter - This will return case-insensitive search on first name (petet / Peter/ PETER - all records with word PETER will be returned). 
```

Elastic search is page-centric data (page -> words) to keyword-centric data (word->pages), so it provides fast and powerful full-text search engine. 