package com.cassandra.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;

import com.cassandra.spring.bo.Employee;


public interface EmployeeService {

	List<Employee> getListEmployees();
	//Employee getEmployee(int id);
	Employee addEmployee(Employee emp);
	//Employee updateEmploee(Employee emp);
	void deleteEmployee(String id);
	//Employee getEmployee(Integer id);
	Employee updateEmploee(String id, Employee emp);
	Employee getEmployee(String id);
	List<Employee> getEmpsByCity(String empCity);
}
