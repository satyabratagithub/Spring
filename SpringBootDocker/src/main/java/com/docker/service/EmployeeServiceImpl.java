package com.docker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.docker.bo.Employee;
import com.docker.dao.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Component
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Mono<Employee> findEmpById(String empId) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(empId);
	}

	@Override
	public Flux<Employee> allEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Mono<Employee> saveEmp(Employee emp) {
		// TODO Auto-generated method stub
		return employeeRepository.save(emp);
	}

	@Override
	public Mono<Void> deleteEmp(String empId) {
	
			return employeeRepository.deleteById(empId);
		
	}

	@Override
	public Mono<Employee> updateEmp(String empId, Employee emp) {
		return employeeRepository.findById(empId).flatMap(e->{
			e.setEmpName(null!=emp.getEmpName()?emp.getEmpName():e.getEmpName());
			e.setEmpExp(null!=emp.getEmpExp()?emp.getEmpExp():e.getEmpExp());
			e.setEmpCity(null!=emp.getEmpCity()?emp.getEmpCity():e.getEmpCity());
			e.setEmpSal(0!=emp.getEmpSal()?emp.getEmpSal():e.getEmpSal());
			return employeeRepository.save(e);
		});
	}

	/*@Override
	public Flux<Employee> getEmpsByCity(String city) {
		return employeeRepository.getEmpsByCity(city);
	}*/

}
