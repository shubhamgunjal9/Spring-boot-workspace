package in.nebulatech.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import in.nebulatech.entity.EmployeeDetails;

public interface EmployeeDetailsRepo extends JpaRepository<EmployeeDetails,	Integer > {

}
