package com.golf.main;

import java.util.List;

import com.golf.Config;
import com.golf.entity.Category;
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

	private List<SmallCategory> m_smallCategories;

	private PagedTool m_pagedTool = new PagedTool(Config.NEWS_PAGED_NUMBER);

	private String m_keyword;

	@Override
	public String execute() throws Exception {
		m_smallCategory = m_categoryService.findSmallCategory(m_smallCategoryId);
		int totalSize = m_newsService.queryTotalSize(0, m_smallCategoryId);
		m_pagedTool.setTotalNumber(totalSize);

		m_news = m_newsService.queryPagedNews(m_pagedTool, 0, m_smallCategoryId);
		m_latestNews = m_newsService.queryFixedLatestNewsByCategoryId(8, m_smallCategory.getCategoryId());

		m_smallCategories = m_categoryService.queryAllSmallCategoryByTypeCategoryId(Category.NEWS,
		      m_smallCategory.getCategoryId());
		return SUCCESS;
	}

	public AdwordsService getAdwordsService() {
		return m_adwordsService;
	}

	public String getKeyword() {
		return m_keyword;
	}

	public List<News> getLatestNews() {
		return m_latestNews;
	}

	public List<News> getNews() {
		return m_news;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public SmallCategory getSmallCategory() {
		return m_smallCategory;
	}

	public int getSmallCategoryId() {
		return m_smallCategoryId;
	}

	public String queryNews() {
		List<News> news = m_newsService.queryNewsByKeyWord(m_keyword);
		m_pagedTool.setTotalNumber(news.size());
		m_news = news.subList(m_pagedTool.getFromIndex(), m_pagedTool.getToIndex());
		m_latestNews = m_newsService.queryFixedLatestNewsByCategoryId(8, 0);
		return SUCCESS;
	}

	public void setAdwordsService(AdwordsService adwordsService) {
		m_adwordsService = adwordsService;
	}

	public void setCategoryService(CategoryService categoryService) {
		m_categoryService = categoryService;
	}

	public void setId(int smallCategoryId) {
		m_smallCategoryId = smallCategoryId;
	}

	public void setIndex(int index) {
		m_pagedTool.setPageIndex(index);
	}

	public void setKeyword(String keyword) {
		m_keyword = keyword;
	}

	public void setNewsService(NewsService newsService) {
		m_newsService = newsService;
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}

	public void setSmallCategoryId(int smallCategoryId) {
		m_smallCategoryId = smallCategoryId;
	}

	public List<SmallCategory> getSmallCategories() {
		return m_smallCategories;
	}

}