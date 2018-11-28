package com.docker.dao;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.docker.bo.Employee;

import reactor.core.publisher.Flux;
@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String> {

	//@Query(value="SELECT * FROM satya.employee WHERE empcity=?0 ALLOW FILTERING")
	//Flux<Employee> getEmpsByCity(String city);
}
