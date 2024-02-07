package in.nebulatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nebulatech.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
