package com.golf.main;

import java.util.List;

import com.golf.Config;
import com.golf.entity.Category;
import com.golf.entity.News;
import com.golf.entity.NewsComments;
import com.golf.entity.SmallCategory;
import com.golf.service.AdwordsService;
import com.golf.service.CategoryService;
import com.golf.service.NewsCommentsService;
import com.golf.service.NewsService;
import com.opensymphony.xwork2.ActionSupport;

public class NewsDetailAction extends ActionSupport {

	private static final long serialVersionUID = 2801256589554291998L;

	private int m_newsId;

	private NewsService m_newsService;

	private AdwordsService m_adwordsService;

	private CategoryService m_categoryService;

	private NewsCommentsService m_newsCommentsService;

	private SmallCategory m_smallCategory;

	private News m_news;

	private List<News> m_newsHot;

	private NewsComments m_comments = new NewsComments();

	private List<NewsComments> m_newsComments;

	@Override
	public String execute() {
		m_news = m_newsService.findNews(m_newsId);
		m_smallCategory = m_categoryService.findSmallCategory(m_news.getSmallCategoryId());
		m_newsComments = m_newsCommentsService.queryNewsCommentsByNewsId(m_newsId);
		m_newsHot = m_newsService.queryHotNewsByCategoryId(8, m_smallCategory.getCategoryId());
		return SUCCESS;
	}

	public String addComments() {
		String userName = m_comments.getUserName();
		if (userName == null || userName.trim().length() == 0) {
			m_comments.setUserName(Config.Anonymous);
		}
		if (m_comments.getContent() == null) {
			m_comments.setContent("");
		}
		if (m_comments.getNewsId() > 0) {
			m_newsCommentsService.insertNewsComments(m_comments);
		}
		m_newsId = m_comments.getNewsId();
		return SUCCESS;
	}

	public void setId(int id) {
		m_newsId = id;
	}

	public void setNewsId(int newsId) {
		m_newsId = newsId;
	}

	public void setNewsService(NewsService newsService) {
		m_newsService = newsService;
	}

	public void setAdwordsService(AdwordsService adwordsService) {
		m_adwordsService = adwordsService;
	}

	public void setCategoryService(CategoryService categoryService) {
		m_categoryService = categoryService;
	}

	public SmallCategory getSmallCategory() {
		return m_smallCategory;
	}

	public News getNews() {
		return m_news;
	}

	public List<NewsComments> getNewsComments() {
		return m_newsComments;
	}

	public void setNewsCommentsService(NewsCommentsService newsCommentsService) {
		m_newsCommentsService = newsCommentsService;
	}

	public List<News> getNewsHot() {
		return m_newsHot;
	}

	public int getNewsId() {
		return m_newsId;
	}

	public NewsComments getComments() {
		return m_comments;
	}

}