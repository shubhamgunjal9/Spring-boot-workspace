package in.nebulatech.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "EMPLOYEE_DETAILS")
public class EmployeeDetails {
	
	@Id
	private Integer emId;
	 
	private String state;
	
	private String city;
	
	private String country;
	

}
