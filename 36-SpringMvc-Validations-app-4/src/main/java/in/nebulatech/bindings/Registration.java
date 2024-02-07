package in.nebulatech.bindings;

import javax.validation.constraints.NotNull;

public class Registration {
	
	@NotNull(message = "user name must be needed")
	@
	private String userName;
	
	private String userPassword;
	
	private Long contact;
	
	private String email;
	
	private Integer salary;

}
