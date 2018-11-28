package com.docker.service;


import com.docker.bo.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
	
	Mono<Employee> findEmpById(String empId);
	Flux<Employee> allEmployees();
	Mono<Employee> saveEmp(Employee emp);
	Mono<Void> deleteEmp(String empId);
	Mono<Employee> updateEmp(String empId,Employee emp);
	//Flux<Employee> getEmpsByCity(String city);

}
