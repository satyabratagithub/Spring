package com.cassandra.webflux.resource;

import java.time.Duration;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cassandra.webflux.bo.Employee;
import com.cassandra.webflux.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@RestController
public class EmployeeResource {

	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/emp")
	public Flux<Employee> findAll(){
		return employeeService.allEmployees().delayElements(Duration.ofMillis(1000));
	}
	
	@GetMapping("/emp/{id}")
	public Mono<Employee> findEmpById(@PathVariable ("id") String id){
		return employeeService.findEmpById(id);
	}
	
	@PostMapping("/emp/save")
	public Mono<Employee> saveEmp(@RequestBody Employee emp){
		return employeeService.saveEmp(emp);
	}
	
	@DeleteMapping(value = "/emp/{id}")
	public Mono<Void> deleteEmp(@PathVariable("id")String empId){
		return employeeService.deleteEmp(empId);		
	}
	@PutMapping("/emp/{id}")
	public Mono<Employee> updateEmp(@PathVariable("id")String id,@RequestBody Employee emp){
		return employeeService.updateEmp(id, emp);
	}
	
	@GetMapping("/emp/get/{city}")
	public Flux<Employee> getEmpsByCity(@PathVariable("city")String city){
		return employeeService.getEmpsByCity(city);
		
	}
	
	@GetMapping("/ext")
	public Publisher<String> hello(){
		return Mono.just("Hello Web");
		
	}
	
}
