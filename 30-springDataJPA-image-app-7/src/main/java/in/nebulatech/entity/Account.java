package in.nebulatech.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "ACCOUNT_DETAILS")
public class Account {

	private String branchName;
	
	private Double minBal;
	
	@EmbeddedId
	private AccountPK accountPK;
	
	
}
