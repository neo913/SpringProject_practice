package com.testweb.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.testweb.service.ArticleService;

public class PageMaker {

	@Autowired ArticleService articleService;
	
	private Long beginPage;
	private Long lastPage;
	private Long currentPage;
	private Long countArticles;

	public PageMaker(){
		this.setBeginPage(1L);
		this.setLastPage(countArticles);
		this.setCurrentPage(1L);
		this.setCountArticles(articleService.countArticles());
	}

	public Long getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(Long beginPage) {
		this.beginPage = 1L;	//Always 1
	}

	public Long getLastPage() {
		return lastPage;
	}

	public void setLastPage(Long lastPage) {
		
		calPages(this.countArticles);//Will always return the last page
		
		this.lastPage = lastPage;
	}

	public Long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage;
	}

	public Long getCountArticles() {
		return countArticles;
	}

	public void setCountArticles(Long countArticles) {
		this.countArticles = countArticles;
	}

	public Long calPages(Long countArticles){
		
		Long result = (countArticles / 10) + 1;
		
		return result;
	}
}