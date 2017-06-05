package com.testweb.service;

import java.util.List;

import com.testweb.model.Account;

public interface AccountService {

	List<Account> findAllAccounts();
	
	Account findAccountById(Long id);
	
	Account findAccountByEmail(String email);
	
	Account findAccountByEmailAndPassword(String email, String password);
	
	void createAccount(String email, String password, String name);
	/*List<Account> findAccountsByName(String name);*/
}
