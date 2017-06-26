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
import com.testweb.model.Comment;
import com.testweb.service.AccountService;
import com.testweb.service.ArticleService;
import com.testweb.service.CommentService;

@Controller
@SessionAttributes("Account, Article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private CommentService commentService;

	@RequestMapping("/Article")
	public String articleList(Model model) {
		List<Article> articles = articleService.findAllArticles();
		model.addAttribute("articles", articles);

		return "article/list";
	}

	@RequestMapping("/Article/Create")
	public String articleCreate() {
		return "article/create";
	}

	@RequestMapping(value = "/Article/createArticle", method = RequestMethod.POST)
	public ModelAndView createArticle(Article article, HttpSession session, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		Account writer = (Account) session.getAttribute("currentAccountInfo");
		article.setWriter(writer);

		
		
		if (article.getTitle().length() > 0 && article.getContent().length() > 0
				&& article.getWriter().getName() != null) {
			Article newArticle = article;
			/*articleService.createArticle(article.getTitle(), article.getContent(), article.getWriter());*/
			articleService.createArticle(newArticle);
			mav.setViewName("redirect:/Article/Detail/"+newArticle.getId());
		} else {
			System.out.println("failed to create an article");
			mav.setViewName("/Article/");
		}
		return mav;
	}

	@RequestMapping(value = "/Article/Detail/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView articleDetailGet(@PathVariable("id") Long id, Model model) {

		ModelAndView mav = new ModelAndView("article/detail");

		List<Article> thisArticle = new ArrayList<Article>();

		thisArticle.add(articleService.findArticleById(id));

		List<Comment> commentsOfThisArticle = commentService.findAllCommentsByArticleId(id);

		mav.addObject("thisArticle", thisArticle);

		mav.addObject("comments", commentsOfThisArticle);

		return mav;
	}

	@RequestMapping(value = "/Article/Update/{id}", method = RequestMethod.GET)
	public ModelAndView articleUpdateGet(@PathVariable("id") Long id, Article article, HttpSession session,
			HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("article/update");
		
		Article thisArticle = articleService.findArticleById(id);
		
		if ( ((Account)session.getAttribute("currentAccountInfo")).getId() == thisArticle.getWriter().getId() ) {
			mav.addObject("thisArticle", thisArticle);
		} else {
			mav.setViewName("redirect:/Article/Detail/"+id);
		}

		return mav;
	}

	@RequestMapping(value = "/Article/Update/{id}/editArticle", method = RequestMethod.POST)
	public ModelAndView articleUpdatePost(@PathVariable("id") Long id, Article article, HttpSession session,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/Article/Detail/" + id);

		Article updatedArticle = new Article();
		updatedArticle.setId(article.getId());
		updatedArticle.setTitle(article.getTitle());
		updatedArticle.setContent(article.getContent());
		updatedArticle.setWriter((Account) session.getAttribute("currentAccountInfo"));
		updatedArticle.setWriteTime(article.getWriteTime());
		updatedArticle.setComments(article.getComments());

		articleService.updateArticle(updatedArticle);

		return mav;
	}

	@RequestMapping(value = "/Article/Delete/{id}", method = RequestMethod.GET)
	public String articleDelete(@PathVariable("id") Long id) {
		articleService.deleteArticleById(id);
		return "redirect:/Article/";
	}

	@RequestMapping(value = "/Article/Detail/{id}/addComment", method = RequestMethod.POST)
	public ModelAndView addComment(Article article, Comment comment, HttpSession session, HttpServletRequest request,
			@PathVariable("id") Long id) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/Article/Detail/" + id);

		Article thisArticle = articleService.findArticleById(id);
		Account thisWriter = (Account) session.getAttribute("currentAccountInfo");

		if (thisArticle != null && thisWriter != null && comment.getContent().length() > 0) {
			comment.setArticle(thisArticle);
			comment.setWriter(thisWriter);
			commentService.addComment(thisArticle, thisWriter, comment.getContent());
		} else {
			System.out.println("failed to add comment");
		}

		return mav;
	}

}
