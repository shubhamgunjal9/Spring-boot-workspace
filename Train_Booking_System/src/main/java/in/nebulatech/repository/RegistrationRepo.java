package in.nebulatech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.nebulatech.bindings.Registration;

public interface RegistrationRepo extends JpaRepository<Registration, String> {
	
	
	public List<Registration> findByEmailAndPassword(String email , String password);
	
	@Query(nativeQuery = true,value = "from")
	public Registration findByEmail(String email); 
    
   // public Registration findByResetPasswordToken(String token);

}
