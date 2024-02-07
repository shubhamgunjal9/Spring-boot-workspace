package in.nebulatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nebulatech.entity.Account;
import in.nebulatech.entity.AccountPK;

public interface AccountRepository extends JpaRepository<Account, AccountPK>{

}
