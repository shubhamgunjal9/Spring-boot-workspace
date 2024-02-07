package in.nebulatech.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nebulatech.entity.EmployeeDetails;
import in.nebulatech.entity.EmployeeInfo;
import in.nebulatech.repository.EmployeeDetailsRepo;
import in.nebulatech.repository.EmployeeInfoRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDetailsRepo detailsRepo;
	
	@Autowired
	private EmployeeInfoRepo infoRepo;
	

	
	public EmployeeService(EmployeeDetailsRepo detailsRepo, EmployeeInfoRepo infoRepo) {
		
		this.detailsRepo=detailsRepo;
		this.infoRepo=infoRepo;
		// TODO Auto-generated constructor stub
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void saveData()
	{
		EmployeeInfo employeeInfo= new EmployeeInfo();
		employeeInfo.setEmpId(3);
		employeeInfo.setEmpName("sagar");
		infoRepo.save(employeeInfo);
		int a=10/0;
		
		EmployeeDetails details= new EmployeeDetails();
		details.setEmId(3);
		details.setCity("pune");
		details.setCountry("INDIA");
		details.setState("MH");
		detailsRepo.save(details);
	}

}
