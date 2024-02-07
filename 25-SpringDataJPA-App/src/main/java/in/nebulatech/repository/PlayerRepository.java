package in.nebulatech.repository;

import java.util.Scanner;

import org.springframework.data.repository.CrudRepository;

import in.nebulatech.entity.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer>  {
	

}
