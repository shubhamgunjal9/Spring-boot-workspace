package in.nebulatech.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "empl_info")
public class EmployeeInfo {
	
	@Id
	private Integer empId;
	
	private String empName;
	


}
