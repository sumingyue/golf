package com.golf.main;

import java.util.ArrayList;
import java.util.List;

import com.golf.entity.Category;
import com.golf.entity.News;
import com.golf.entity.SmallCategory;
import com.golf.service.AdwordsService;
import com.golf.service.CategoryService;
import com.golf.service.ImageService;
import com.golf.service.NewsService;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryNewsAction extends ActionSupport {

	private static final long serialVersionUID = 2801256589554291998L;

	private NewsService m_newsService;

	private CategoryService m_categoryService;

	private AdwordsService m_adwordsService;

	private ImageService m_imageService;

	private int m_categoryId;

	private List<News> m_imageNews;

	private List<CategoryNews> m_categoryNews = new ArrayList<CategoryNews>();

	private List<NewsGroup> m_newsGroup = new ArrayList<NewsGroup>();

	@Override
	public String execute() throws Exception {
		List<News> hotNews = m_newsService.queryHotNewsByCategoryId(15, m_categoryId);
		NewsGroup group1 = new NewsGroup();
		NewsGroup group2 = new NewsGroup();
		NewsGroup group3 = new NewsGroup();
		m_newsGroup.add(group1);
		m_newsGroup.add(group2);
		m_newsGroup.add(group3);

		group1.setFirst(hotNews.get(0));
		group2.setFirst(hotNews.get(1));
		group3.setFirst(hotNews.get(2));
		for (int i = 3; i < 15; i++) {
			if (i < 7) {
				group1.addNews(hotNews.get(i));
			} else if (i < 11) {
				group2.addNews(hotNews.get(i));
			} else {
				group3.addNews(hotNews.get(i));
			}
		}
		m_imageNews = m_newsService.queryFixedImageNewsByCategoryId(4, m_categoryId);

		for (News temp : m_imageNews) {
			temp.setImage(m_imageService.findImage(temp.getImageId()));
		}
		List<SmallCategory> all = m_categoryService.queryAllSmallCategoryByTypeCategoryId(Category.NEWS, m_categoryId);

		for (SmallCategory temp : all) {
			CategoryNews categoryNews = new CategoryNews();
			categoryNews.setSmallCategory(temp);
			categoryNews.setNews(m_newsService.queryFixedNewsBySmallCategoryId(8, temp.getId()));

			m_categoryNews.add(categoryNews);
		}
		return SUCCESS;
	}

	public List<News> getImageNews() {
		return m_imageNews;
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

	public AdwordsService getAdwordsService() {
		return m_adwordsService;
	}

	public void setId(int id) {
		m_categoryId = id;
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public List<NewsGroup> getNewsGroup() {
		return m_newsGroup;
	}

	public static class NewsGroup {
		private News m_first;

		private List<News> m_news = new ArrayList<News>();

		public List<News> getNews() {
			return m_news;
		}

		public News getFirst() {
			return m_first;
		}

		public void setFirst(News first) {
			m_first = first;
		}

		public void setNews(List<News> news) {
			m_news = news;
		}

		public void addNews(News temp) {
			m_news.add(temp);
		}
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