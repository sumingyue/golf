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

	private List<News> m_latestNews;

	private PagedTool m_pagedTool = new PagedTool(Config.NEWS_PAGED_NUMBER);

	private String m_keyword;

	public String queryNews(){
		List<News> news = m_newsService.queryNewsByKeyWord(m_keyword);
		m_pagedTool.setTotalNumber(news.size());
		m_news = news.subList(m_pagedTool.getFromIndex(), m_pagedTool.getToIndex());
		m_latestNews = m_newsService.queryFixedLatestNewsByCategoryId(8, 0);
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		m_smallCategory = m_categoryService.findSmallCategory(m_smallCategoryId);
		int totalSize = m_newsService.queryTotalSize(0, m_smallCategoryId);
		m_pagedTool.setTotalNumber(totalSize);

		m_news = m_newsService.queryPagedNews(m_pagedTool, 0, m_smallCategoryId);
		m_latestNews = m_newsService.queryFixedLatestNewsByCategoryId(8, m_smallCategory.getCategoryId());
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

	public AdwordsService getAdwordsService() {
		return m_adwordsService;
	}

	public void setIndex(int index) {
		m_pagedTool.setPageIndex(index);
	}

	public List<News> getLatestNews() {
		return m_latestNews;
	}

	public String getKeyword() {
		return m_keyword;
	}

	public void setKeyword(String keyword) {
		m_keyword = keyword;
	}
	

}