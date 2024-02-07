package in.nebulatech.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nebulatech.entity.Account;
import in.nebulatech.entity.AccountPK;
import in.nebulatech.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	private AccountService()
	{
		
	}

	 private AccountService(AccountRepository accountRepository)
	 {
		 this.accountRepository= accountRepository;
		 
	 }
	 
	 public void getDataUsingPk()
	 {
		 AccountPK accountPK = new AccountPK();
		 accountPK.setAccId(101);
		 accountPK.setAccType("savings");
		 accountPK.setHolderName("shubham");
		 Optional<Account> findById=accountRepository.findById(accountPK);
		 if(findById.isPresent()) {
			 System.out.println(findById.get());
		 }
	 }
	 
	 public void setAccountData()
	 {
		 AccountPK accountPK=new AccountPK();
		 accountPK.setAccId(102);
		 accountPK.setAccType("current");
		 accountPK.setHolderName("shubham");
		 
		 
		 Account account= new Account();
		 account.setBranchName("vambori");
		 account.setMinBal(12000.00);
		 account.setAccountPK(accountPK);
		 
		 accountRepository.save(account);
	 }
}
