package in.nebulatech.service;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nebulatech.entity.Employee;
import in.nebulatech.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public List<Employee> getEmployees()
	{ 
		return employeeRepo.findAll();
	}
	
	public Employee addEmployee(Employee employee)
	{
		return employeeRepo.save(employee);
	}
	
	public List<Employee> addAllEmployee(List<Employee> list)
	{
		return employeeRepo.saveAll(list);
	}
	
	public Employee findByEmplId(Integer id)
	{
		return employeeRepo.findById(id)
				.orElseThrow(()->new RuntimeException("Student not found"));
	}

	
}
