package in.nebulatech.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EMPLOYEE_DATA")
@Data
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "EMPLOYEE_ID")
	private Integer emplId;

	//@Column(name = "EMPLOYEE_NAME")
	private String emplName;

	//@Column(name = "EMPLOYEE_LOCATION")
	private String emplLocation;

	//@Column(name = "EMPLOYEE_CONTACT")
	private Long emplContact;

	//@Column(name = "EMPLOYEE_SALARY")
	private Double emplSalary;

}
