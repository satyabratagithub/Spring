package com.cassandra.spring.dao;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cassandra.spring.bo.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

	@Query(value="SELECT empid,empname,empcity,empexp FROM satya.employee WHERE empcity=?0 ALLOW FILTERING")
	public List<Employee> findByEmpCity(String empName);
}
