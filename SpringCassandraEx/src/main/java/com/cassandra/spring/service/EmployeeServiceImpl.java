package com.cassandra.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cassandra.spring.bo.Employee;
import com.cassandra.spring.dao.EmployeeRepository;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getListEmployees() {	
		List<Employee> listEmp= new ArrayList<>();
		for (Employee emp :  employeeRepository.findAll()) {
			listEmp.add(emp);
		}
		return listEmp;
	}


	@Override
	public Employee addEmployee(Employee emp) {
		return employeeRepository.save(emp);

	}

	@Override
	public Employee getEmployee(String id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		emp.get();
		return emp.get();
	}

	@Override
	public Employee updateEmploee(String id , Employee emp) {
		Employee empOld=null;
		if(null != employeeRepository.findById(id).get()) {
			empOld = employeeRepository.findById(id).get();
			empOld.setEmpName(emp.getEmpName());
			empOld.setEmpSal(emp.getEmpSal());
			empOld.setEmpExp(emp.getEmpExp());
		}
		return employeeRepository.save(empOld);

	}

	@Override
	public void deleteEmployee(String id) {
		//Employee empOld=null;
		if(null != employeeRepository.findById(id).get()) {
			employeeRepository.deleteById(id);
		}
		

	}


	@Override
	public List<Employee> getEmpsByCity(String empCity) {
		List<Employee> listEmps=  employeeRepository.findByEmpCity(empCity);
		return listEmps;
	}

}
