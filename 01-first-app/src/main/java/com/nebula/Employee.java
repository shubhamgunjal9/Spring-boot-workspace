package com.nebula;

public class Employee {
	
	private String empName;
	
	private String empContact;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpContact() {
		return empContact;
	}

	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}

	public Employee(String empName, String empContact) {
		super();
		this.empName = empName;
		this.empContact = empContact;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empContact=" + empContact + "]";
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
