package com.testweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.testweb.model.Account;
import com.testweb.service.AccountService;

@Controller
@SessionAttributes("Account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping("/Account/SignIn")
	public String signIn(){
		return "account/signIn";
	}
	
	@RequestMapping(value="/Account/signInProcess", method = RequestMethod.POST)
	public ModelAndView signInProcess(Account account, HttpSession session, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		Account currentAccount = accountService.findAccountByEmailAndPassword(account.getEmail(), account.getPassword());
		
		if(currentAccount != null){
			session.setAttribute("currentAccountInfo", currentAccount);
		}
		return mav;
	}
	
	@RequestMapping("/Account/SignOut")
	public String sighOut(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/Account/SignUp")
	public String signUp(){
		return "account/signUp";
	}
	
	@RequestMapping(value="/Account/signUpProcess", method=RequestMethod.POST)
	public ModelAndView signUpProcess(@Valid Account account, HttpSession session, HttpServletRequest request){

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		
		if(accountService.findAccountByEmail(account.getEmail()) == null){
			accountService.createAccount(account.getEmail(), account.getPassword(), account.getName());
			signInProcess(account, session, request);
		}else{
			mav.setViewName("redirect:/Account/SignUp");
			String error = "error";
			mav.addObject(error);
			System.out.println("The account is already exist");
		}
		
		return mav;
	}
	
	@RequestMapping("/Account/FindPW")
	public String findPWGET(){
		return "account/findPW";
	}
	
	@RequestMapping("/Account/ShowList")
	public String test(Model model){
		List<Account> accounts = accountService.findAllAccounts();
		
		model.addAttribute("accounts", accounts);
		return "/account/getAllUsers";
	}
	
	@RequestMapping("/Account/Search")
	public String search(Model model){
		return "account/search";
	}
	
	
}
