package in.nebulatech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import in.nebulatech.entity.User;

@Configuration
public class RedisConfig {
	
	@Bean
	public JedisConnectionFactory connectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		//factory.setClientName(null);
		//factory.setPassword(null);
		//factory.setDatabase(0);
		return factory;
	}
	
	@Bean
	@Primary
	public RedisTemplate<String, User> getRedisTemplate(JedisConnectionFactory factory) {
		RedisTemplate<String, User> template = new RedisTemplate<>();
		template.setConnectionFactory(factory);
		return template;
	}
 
}
