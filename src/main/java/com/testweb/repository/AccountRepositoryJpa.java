package com.testweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testweb.model.Account;

@Repository("accountRepository")
public interface AccountRepositoryJpa extends JpaRepository<Account, Long>{
	
	@Query("select a from Account a where a.email = ?1 and a.password =?2")
	Account findAccountByEmailAndPassword(String email, String password);

	@Query("select a from Account a where a.email = ?1")
	Account findAccountByEmail(String email);
	
}

