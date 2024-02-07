package in.nebulatech.repository;

8
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import in.nebulatech.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public List<User> findByUserLocation(String string);


}
