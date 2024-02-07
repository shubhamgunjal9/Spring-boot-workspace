package in.nebulatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nebulatech.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
