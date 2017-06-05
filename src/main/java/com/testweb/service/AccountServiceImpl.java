package com.testweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testweb.model.Account;
import com.testweb.repository.AccountRepositoryJpa;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepositoryJpa accountRepositoryJpa;
	
	
	public List<Account> findAllAccounts() {
		return accountRepositoryJpa.findAll();
	}

	public Account findAccountById(Long id) {
		return accountRepositoryJpa.getOne(id);
	}
	
	public Account findAccountByEmail(String email) {
		return accountRepositoryJpa.findAccountByEmail(email);
	}	

	public Account findAccountByEmailAndPassword(String email, String password) {
		return accountRepositoryJpa.findAccountByEmailAndPassword(email, password);
	}

	public void createAccount(String email, String password, String name) {
		Account newAccount = new Account(email, password, name);
		accountRepositoryJpa.saveAndFlush(newAccount);
	}
}
