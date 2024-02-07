package in.nebulatech.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER_DATA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Integer userId;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "USER_PASS")
	private String password;
	
	@Column(name = "USER_GENDER")
	private String gender;
	
	@Column(name = "USER_AGE")
	private Long userAge;
	
	@Column(name = "USER_DOB")
	private LocalDateTime userDOB;
	
	@Column(name = "LOGIN_TIME")
	private LocalDateTime login;
	
	@Column(name = "LOCATION")
	private String location;

	public User(String userName, String password, String gender, Long userAge, LocalDateTime userDOB,
			LocalDateTime login, String location) {
		super();
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.userAge = userAge;
		this.userDOB = userDOB;
		this.login = login;
		this.location = location;
	}
	
	
	
	

}
