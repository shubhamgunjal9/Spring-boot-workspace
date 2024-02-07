package in.nebulatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nebulatech.entity.EmployeeInfo;

public interface EmployeeInfoRepo extends JpaRepository<EmployeeInfo, Integer>{

}
