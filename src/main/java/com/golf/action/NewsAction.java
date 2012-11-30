package com.golf.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.golf.Config;
import com.golf.entity.Category;
import com.golf.entity.Image;
import com.golf.entity.News;
import com.golf.entity.SmallCategory;
import com.golf.entity.UploadFile;
import com.golf.service.CategoryService;
import com.golf.service.ImageService;
import com.golf.service.NewsService;
import com.golf.tools.ImageTools;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class NewsAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(NewsAction.class);

	private List<News> m_newsList;

	private int m_newsId;

	private NewsService m_newsService;

	private CategoryService m_categoryService;

	private ImageService m_imageService;

	private News m_news = new News();

	private List<Category> m_categoryList;

	private List<SmallCategory> m_smallCategoryList;

	private int m_categoryId;
	
	private int m_smallCategoryId;

	private PagedTool m_pagedTool = new PagedTool(Config.NEWS_PAGED_NUMBER);

	private UploadFile m_uploadFile = new UploadFile();

	public String baseFile = Config.IMAGE_PATH;

	private File m_upload;

	private int insertImage() {
		try {
			String relativePath = Config.IMAGE_PATH + ImageTools.getImageStorePath(m_uploadFile.getFilename(), Image.NEWS);
			String storePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + relativePath;
			
			m_uploadFile.setPath(relativePath);
			m_uploadFile.setStorePath(storePath);
			int id = m_imageService.insert(m_upload, m_uploadFile, Image.NEWS);
			return id;
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return -1;
		}
	}

	public String querySmallCategory() {
		if (m_categoryId > 0) {
			m_smallCategoryList = m_categoryService.queryAllSmallCategoryByCategoryId(m_categoryId);
		}
		return SUCCESS;
	}

	public String newsList() {
		try {
			m_categoryList = m_categoryService.queryAllCategories();
			m_smallCategoryList = m_categoryService.queryAllSmallCategoryByCategoryId(m_categoryId);
			int totalSize = m_newsService.queryTotalSize(m_categoryId,m_smallCategoryId);

			m_pagedTool.setTotalNumber(totalSize);
			
			m_newsList = m_newsService.queryPagedNews(m_pagedTool,m_categoryId,m_smallCategoryId);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String newsAdd() {
		try {
			m_categoryList = m_categoryService.queryAllCategories();
			return SUCCESS;
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public String newsAddSubmit() {
		try {
			if (m_upload != null) {
				int imageId = insertImage();
				m_news.setImageId(imageId);
			} else {
				m_news.setImageId(-1);
			}
			m_news.setCreationDate(new Date());
			int id = m_newsService.insertNews(m_news);
			if (id > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public String newsUpdate() {
		try {
			m_news = m_newsService.findNews(m_newsId);
			m_categoryList = m_categoryService.queryAllCategories();
			m_smallCategoryList = m_categoryService.queryAllSmallCategoryByCategoryId(m_news.getCategoryId());
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String newsUpdateSubmit() {
		try {
			News last = m_newsService.findNews(m_news.getId());
			m_news.setCreationDate(last.getCreationDate());

			if (m_upload != null) {
				int imageId = insertImage();
				m_news.setImageId(imageId);
			} else {
				m_news.setImageId(last.getImageId());
			}
			
			int count = m_newsService.updateNews(m_news);
			if (count > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public String newsDelete() {
		try {
			int count = m_newsService.deleteNews(m_newsId);
			if (count > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public News getNews() {
		return m_news;
	}

	public void setNews(News news) {
		m_news = news;
	}

	public void setNewsService(NewsService newsService) {
		m_newsService = newsService;
	}

	public List<News> getCategories() {
		return m_newsList;
	}

	public void setNewsId(int newsId) {
		m_newsId = newsId;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}

	public List<News> getNewsList() {
		return m_newsList;
	}

	public int getNewsId() {
		return m_newsId;
	}

	public int getCategoryId() {
		return m_categoryId;
	}

	public void setCategoryId(int categoryId) {
		m_categoryId = categoryId;
	}

	public List<Category> getCategoryList() {
		return m_categoryList;
	}

	public void setCategoryService(CategoryService categoryService) {
		m_categoryService = categoryService;
	}

	public List<SmallCategory> getSmallCategoryList() {
		return m_smallCategoryList;
	}

	public void setSmallCategoryList(List<SmallCategory> smallCategoryList) {
		m_smallCategoryList = smallCategoryList;
	}

	public void setUpload(File file) {
		m_upload = file;
	}

	public void setUploadFileName(String filename) {
		m_uploadFile.setFilename(filename);
	}

	public void setUploadContentType(String contentType) {
		m_uploadFile.setContentType(contentType);
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public void setSmallCategoryId(int smallCategoryId) {
		m_smallCategoryId = smallCategoryId;
	}

	public int getSmallCategoryId() {
		return m_smallCategoryId;
	}
	
}