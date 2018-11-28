package com.cassandra.spring.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.cassandra.spring.bo.Employee;
import com.cassandra.spring.service.EmployeeService;

@Path("/emp")
public class EmployeeResource {
	@Autowired
	private EmployeeService employeeService;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String helloEmp() {
		return "hello Emp!!!!";
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListEmployees() {
		List<Employee> listEmp = employeeService.getListEmployees();
		return Response.ok(listEmp).build();
		
	}
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmployee(Employee emp) {
		Employee emp1= employeeService.addEmployee(emp);
		return Response.ok(emp1).build();
		
	}

	@PUT
	@Path("/{id}/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEmployee(@PathParam("id") String id,Employee emp) {
		Employee emp1=employeeService.updateEmploee(id, emp);
		return Response.ok(emp1).build();
		
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmpById(@PathParam("id") String id) {
		Employee emp = employeeService.getEmployee(id);
		return Response.ok(emp).build();		
	}
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteEmp(@PathParam("id") String id,Employee emp) {
		if(null!=emp.getEmpId()) {
			employeeService.deleteEmployee(id);
		}	
		return Response.noContent().build();
		
	}
	
	@GET
	@Path("/{city}/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findEmpsByName(@PathParam("city") String city) {
		List<Employee> emps = employeeService.getEmpsByCity(city);
		return Response.ok(emps).build();		
	}
}
