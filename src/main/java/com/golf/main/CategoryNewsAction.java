package com.golf.main;

import java.util.ArrayList;
import java.util.List;

import com.golf.entity.News;
import com.golf.entity.SmallCategory;
import com.golf.service.AdwordsService;
import com.golf.service.CategoryService;
import com.golf.service.NewsService;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryNewsAction extends ActionSupport {

	private static final long serialVersionUID = 2801256589554291998L;

	private NewsService m_newsService;

	private CategoryService m_categoryService;

	private AdwordsService m_adwordsService;

	private int m_categoryId;

	private List<News> m_imageNews;

	private List<News> m_hotNews;

	private List<CategoryNews> m_categoryNews = new ArrayList<CategoryNews>();

	@Override
	public String execute() throws Exception {
		m_hotNews = m_newsService.queryHotNewsByCategoryId(6, m_categoryId);
		m_imageNews = m_newsService.queryImageNewsByCategoryId(5, m_categoryId);

		List<SmallCategory> all = m_categoryService.queryAllSmallCategoryByCategoryId(m_categoryId);

		for (SmallCategory temp : all) {
			CategoryNews categoryNews = new CategoryNews();
			categoryNews.setSmallCategory(temp);
			categoryNews.setNews(m_newsService.queryNewsBySmallCategoryId(8, temp.getId()));

			m_categoryNews.add(categoryNews);
		}
		return SUCCESS;
	}

	public List<News> getImageNews() {
		return m_imageNews;
	}

	public List<News> getHotNews() {
		return m_hotNews;
	}

	public List<CategoryNews> getCategoryNews() {
		return m_categoryNews;
	}

	public void setNewsService(NewsService newsService) {
		m_newsService = newsService;
	}

	public void setCategoryService(CategoryService categoryService) {
		m_categoryService = categoryService;
	}

	public void setCategoryId(int categoryId) {
		m_categoryId = categoryId;
	}

	public void setAdwordsService(AdwordsService adwordsService) {
		m_adwordsService = adwordsService;
	}

	public void setId(int id) {
		m_categoryId = id;
	}

	public static class CategoryNews {
		private SmallCategory m_smallCategory;

		private List<News> m_news;

		public SmallCategory getSmallCategory() {
			return m_smallCategory;
		}

		public void setSmallCategory(SmallCategory smallCategory) {
			m_smallCategory = smallCategory;
		}

		public List<News> getNews() {
			return m_news;
		}

		public void setNews(List<News> news) {
			m_news = news;
		}
	}

}