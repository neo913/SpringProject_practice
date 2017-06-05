package com.testweb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.testweb.model.Account;
import com.testweb.model.Article;
import com.testweb.service.ArticleService;

@Controller
@SessionAttributes("Article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/Article")
	public String articleList(Model model){
		List<Article> articles = articleService.findAllArticles();
		model.addAttribute("articles", articles);
		return "article/list";
	}
	
	@RequestMapping("/Article/Create")
	public String articleCreate(){
		return "article/create";
	}

	@RequestMapping(value="/Article/createArticle", method=RequestMethod.POST)
	public ModelAndView createArticle(Article article, HttpSession session, HttpServletRequest request){
		System.out.println("createArticle is called");
		
		ModelAndView mav = new ModelAndView();
		
		/*String viewName = "redirect:/Article/Detail/" + article.getId();*/
		mav.setViewName("redirect:/Article");
		
		//article.setWriter(account);
		
		Account writer = (Account) session.getAttribute("currentAccountInfo");
		System.out.println("if I get the \"currentAccountInfo\"...");
		article.setWriter(writer);
		System.out.println(writer.getName() + "is the writer");
		
		
		if(article.getWriteTime() == null){
			article.setWriteTime(new Date());
			System.out.println("data is set" + article.getWriteTime());
		}
		
		System.out.println("ID: "+article.getId());
		System.out.println("Title: "+article.getTitle());
		System.out.println("content: "+article.getContent());
		System.out.println("Writer: "+article.getWriter().getName());
		System.out.println("WriteTime: "+article.getWriteTime());
		
		if(article.getTitle() != null && article.getComments() != null &&
				article.getWriter().getName() != null){
			articleService.createArticle(article.getTitle(), article.getContent(), article.getWriter());
		}else{
			System.out.println("failed to create an article");
		}
		return mav;
	}
	
	@RequestMapping(value="/Article/Detail/{id}", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView articleDetailGet(@PathVariable("id") Long id){
		
		List<Article> thisArticle = new ArrayList<Article>();
		
		thisArticle.add(articleService.findArticleById(id));
		
		ModelAndView mav = new ModelAndView("article/detail");
		
		mav.addObject("thisArticle", thisArticle);
		
		return mav;
	}

	/*@RequestMapping(value="/Article/Detail/{id}", method=RequestMethod.GET)
	public String articleDetailGet(@PathVariable("id") Long id, Model model){
		
		Article thisArticle = articleService.findArticleById(id);
		
		model.addAttribute("thisArticle", thisArticle);
		return "article/detail";
	}*/
	
	@RequestMapping("/Article/update")
	public String articleUpdate(){
		return "";
	}
	
	@RequestMapping("/Article/Delete")
	public String articleDelete(){
		return "";
	}
	
}
