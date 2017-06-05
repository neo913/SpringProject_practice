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
		
		ModelAndView mav = new ModelAndView();
		
		/*String viewName = "redirect:/Article/Detail/" + article.getId();*/
		mav.setViewName("redirect:/Article");
		
		Account writer = (Account) session.getAttribute("currentAccountInfo");
		article.setWriter(writer);
		
		if(article.getTitle().length() > 0 && article.getContent().length() > 0 && 
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

	@RequestMapping(value="/Article/Update/{id}", method=RequestMethod.GET)
	public ModelAndView articleUpdateGet(@PathVariable("id") Long id, Article article, HttpSession session, HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView("article/update");
		
		Article thisArticle = articleService.findArticleById(id);
		
		mav.addObject("thisArticle", thisArticle);
		
		return mav;
	}
	
	@RequestMapping(value="/Article/Update/{id}", method=RequestMethod.POST)
	public ModelAndView articleUpdatePost(@PathVariable("id") Long id, Article article, HttpSession session, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/Article/Detail/"+id);;
		
		Article updatedArticle = new Article();
		
		updatedArticle.setId(article.getId());
		updatedArticle.setTitle(article.getTitle());
		updatedArticle.setContent(article.getContent());
		updatedArticle.setWriter(article.getWriter());
		updatedArticle.setWriteTime(new Date());
		updatedArticle.setComments(article.getComments());
		
		return mav;
	}
	
	@RequestMapping(value="/Article/Delete/{id}", method=RequestMethod.GET)
	public String articleDelete(@PathVariable("id") Long id){
		articleService.deleteArticleById(id);
		return "redirect:/Article/";
	}
	
}
