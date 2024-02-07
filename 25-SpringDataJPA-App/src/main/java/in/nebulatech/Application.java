package in.nebulatech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.nebulatech.entity.Player;
import in.nebulatech.repository.PlayerRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(Application.class, args);
		
		PlayerRepository playerRepository=context.getBean(PlayerRepository.class);
		
		Player player = new Player();
		player.setPlayerId(101);
		player.setPlayerName("dhoni");
		player.setPlayerAge(36);
		player.setLocation("ranchi");
		
		playerRepository.save(player);
		System.out.println("record inserted"); 
	}

}
