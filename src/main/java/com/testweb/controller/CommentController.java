package com.testweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.testweb.model.Account;
import com.testweb.model.Comment;
import com.testweb.service.CommentService;

@Controller
@SessionAttributes("Account, Comment")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="/Comment/Delete/{id}", method=RequestMethod.GET)
	public String commentDelete(@PathVariable("id") Long id){
		Long artId = (commentService.findCommentById(id)).getArticle().getId();
		commentService.deleteCommentById(id);
		return "redirect:/Article/Detail/"+ artId;
	}
	
	@RequestMapping(value="/Comment/Update/{id}", method=RequestMethod.GET)
	public ModelAndView commentUpdateGet(@PathVariable("id") Long id, Comment comment,
			HttpSession session, HttpServletRequest request) {
	
		ModelAndView mav = new ModelAndView("/Article/detail_com_update");
		
		Comment thisComment = commentService.findCommentById(id);
		
		if( ((Account)session.getAttribute("currentAccountInfo")).getId() == thisComment.getWriter().getId() ){
			mav.addObject("thisComment", thisComment);
		}else{
			mav.addObject("msg", "You can only edit your comments");
			mav.setViewName("redirect:/Article/Detail/"+thisComment.getArticle().getId());
		}
		return mav;
	}
	
	@RequestMapping(value="/Comment/Update/{id}/updateComment", method=RequestMethod.POST)
	public ModelAndView commentUpdatePost(@PathVariable("id") Long id, Comment comment,
			HttpSession session, HttpServletRequest request) {
		
		Comment thisComment = commentService.findCommentById(id);
		thisComment.updateComment(comment);
		ModelAndView mav = new ModelAndView("redirect:/Article/Detail/"+thisComment.getArticle().getId());
		
		commentService.updateComment(thisComment);
		
		return mav;
	}
}
