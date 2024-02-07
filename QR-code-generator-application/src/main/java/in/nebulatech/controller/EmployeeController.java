package in.nebulatech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;

import java.io.IOException;
import java.util.*;

import in.nebulatech.entity.Employee;
import in.nebulatech.generator.QRCodeGenerator;
import in.nebulatech.service.EmployeeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employees")
@Controller
@RequiredArgsConstructor
public class EmployeeController {
	
	@Autowired
	private final EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees() throws WriterException, IOException
	{
		List<Employee> employees=employeeService.getEmployees();
		if(employees.size()!=0)
		{
			for(Employee employee : employees)
			{
				QRCodeGenerator.generateQRcode(employee);
			}
		}
		return ResponseEntity.ok(employeeService.getEmployees());
	}
	
	@PostMapping
	public Employee addEmployees(@RequestBody Employee employee)
	{
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable("id") Integer id)
	{
		return employeeService.findByEmplId(id);
	}

}