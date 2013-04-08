package com.golf.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

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

	private Logger m_logger = Logger.getLogger(CategoryNewsAction.class);

	private NewsService m_newsService;

	private CategoryService m_categoryService;

	private AdwordsService m_adwordsService;

	private ImageService m_imageService;

	private Category m_category;

	private int m_categoryId;

	private List<News> m_imageNews;

	private List<News> m_hotNews;

	private List<SmallCategory> m_smallCategories;

	private List<CategoryNews> m_categoryNews = new ArrayList<CategoryNews>();

	private List<NewsGroup> m_newsGroup = new ArrayList<NewsGroup>();

	@Override
	public String execute() throws Exception {
		try {
			m_category = m_categoryService.findCategory(m_categoryId);
			m_hotNews = m_newsService.queryHotNewsByCategoryId(15, m_categoryId);
			
			NewsGroup group1 = new NewsGroup();
			NewsGroup group2 = new NewsGroup();
			NewsGroup group3 = new NewsGroup();
			
			m_newsGroup.add(group1);
			m_newsGroup.add(group2);
			m_newsGroup.add(group3);

			group1.setFirst(m_hotNews.get(0));
			group2.setFirst(m_hotNews.get(1));
			group3.setFirst(m_hotNews.get(2));
			for (int i = 3; i < 15; i++) {
				if (i < 7) {
					group1.addNews(m_hotNews.get(i));
				} else if (i < 11) {
					group2.addNews(m_hotNews.get(i));
				} else {
					group3.addNews(m_hotNews.get(i));
				}
			}
			m_imageNews = m_newsService.queryFixedImageNews(4, m_categoryId);

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

			m_smallCategories = m_categoryService.queryAllSmallCategoryByTypeCategoryId(Category.NEWS, m_categoryId);
			m_hotNews = m_newsService.queryFixedLatestNewsByCategoryId(12, m_categoryId);
		} catch (Exception e) {
			m_logger.error(e);
			return ERROR;
		}
		return SUCCESS;
	}

	public AdwordsService getAdwordsService() {
		return m_adwordsService;
	}

	public Category getCategory() {
		return m_category;
	}

	public List<CategoryNews> getCategoryNews() {
		return m_categoryNews;
	}

	public List<News> getHotNews() {
		return m_hotNews;
	}

	public List<News> getImageNews() {
		return m_imageNews;
	}

	public List<NewsGroup> getNewsGroup() {
		return m_newsGroup;
	}

	public List<SmallCategory> getSmallCategories() {
		return m_smallCategories;
	}

	public void setAdwordsService(AdwordsService adwordsService) {
		m_adwordsService = adwordsService;
	}

	public void setCategory(Category category) {
		m_category = category;
	}

	public void setCategoryId(int categoryId) {
		m_categoryId = categoryId;
	}

	public void setCategoryService(CategoryService categoryService) {
		m_categoryService = categoryService;
	}

	public void setHotNews(List<News> hotNews) {
		m_hotNews = hotNews;
	}

	public void setId(int id) {
		m_categoryId = id;
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public void setNewsService(NewsService newsService) {
		m_newsService = newsService;
	}

	public void setSmallCategories(List<SmallCategory> smallCategories) {
		m_smallCategories = smallCategories;
	}

	public static class CategoryNews {
		private SmallCategory m_smallCategory;

		private List<News> m_news;

		public List<News> getNews() {
			return m_news;
		}

		public SmallCategory getSmallCategory() {
			return m_smallCategory;
		}

		public void setNews(List<News> news) {
			m_news = news;
		}

		public void setSmallCategory(SmallCategory smallCategory) {
			m_smallCategory = smallCategory;
		}
	}

	public static class NewsGroup {
		private News m_first;

		private List<News> m_news = new ArrayList<News>();

		public void addNews(News temp) {
			m_news.add(temp);
		}

		public News getFirst() {
			return m_first;
		}

		public List<News> getNews() {
			return m_news;
		}

		public void setFirst(News first) {
			m_first = first;
		}

		public void setNews(List<News> news) {
			m_news = news;
		}
	}

}