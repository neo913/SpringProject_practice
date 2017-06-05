package com.testweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.testweb.service.CommentService;

@Controller
@SessionAttributes("Comment")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/Comment/Create")
	public String commentCreate(){
		return "";
	}
	
	@RequestMapping("/Comment/Read")
	public String commentRead(){
		return "";
	}
	
	@RequestMapping("/Comment/update")
	public String commentUpdate(){
		return "";
	}
	
	@RequestMapping("/Comment/Delete")
	public String commentDelete(){
		return "";
	}
}
