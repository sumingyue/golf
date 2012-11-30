package com.golf.main;

import java.util.List;

import com.golf.Config;
import com.golf.entity.News;
import com.golf.entity.SmallCategory;
import com.golf.service.AdwordsService;
import com.golf.service.CategoryService;
import com.golf.service.NewsService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class SmallCategoryNewsAction extends ActionSupport {

	private static final long serialVersionUID = 2801256589554291998L;

	private NewsService m_newsService;

	private AdwordsService m_adwordsService;

	private int m_smallCategoryId;
	
	private List<News> m_news;
	
	private SmallCategory m_smallCategory;
	
	private CategoryService m_categoryService;

	private PagedTool m_pagedTool = new PagedTool(Config.NEWS_PAGED_NUMBER);
	
	@Override
	public String execute() throws Exception {
		m_smallCategory = m_categoryService.findSmallCategory(m_smallCategoryId);
		int totalSize = m_newsService.queryTotalSize(0,m_smallCategoryId);
		m_pagedTool.setTotalNumber(totalSize);
		
		m_news = m_newsService.queryPagedNews(m_pagedTool, 0, m_smallCategoryId);
		
		//TOOD
		if(m_news.size()<20){
			int total = 20-m_news.size();
			for(int i=0;i<total;i++){
				m_news.add(m_newsService.findNews(27));
			}
		}
		return SUCCESS;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}

	public List<News> getNews() {
		return m_news;
	}

	public void setNewsService(NewsService newsService) {
		m_newsService = newsService;
	}

	public void setAdwordsService(AdwordsService adwordsService) {
		m_adwordsService = adwordsService;
	}

	public void setSmallCategoryId(int smallCategoryId) {
		m_smallCategoryId = smallCategoryId;
	}

	public void setId(int smallCategoryId) {
		m_smallCategoryId = smallCategoryId;
	}

	public int getSmallCategoryId() {
		return m_smallCategoryId;
	}

	public SmallCategory getSmallCategory() {
		return m_smallCategory;
	}

	public void setCategoryService(CategoryService categoryService) {
		m_categoryService = categoryService;
	}
	

}