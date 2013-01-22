package com.golf.action;

import java.io.File;
import java.text.SimpleDateFormat;
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

	private int m_status;

	private int m_recommand;

	private PagedTool m_pagedTool = new PagedTool(Config.NEWS_PAGED_NUMBER);

	private UploadFile m_uploadFile = new UploadFile();

	public String baseFile = Config.IMAGE_PATH;

	private File m_upload;

	private int insertImage() {
		String fileName = m_uploadFile.getFilename();
		String relativePath = Config.IMAGE_PATH + ImageTools.getImageStorePath(fileName, "_normal", Image.NEWS);
		String storePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + relativePath;

		String compressRelativePath = Config.IMAGE_PATH + ImageTools.getImageStorePath(fileName, "_small", Image.NEWS);
		String compressStorePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + compressRelativePath;

		String originalPath = ImageTools.getOriginalPath(fileName, Image.NEWS);
		m_uploadFile.setOriginalPath(originalPath);

		m_uploadFile.setPath(relativePath);
		m_uploadFile.setStorePath(storePath);

		m_uploadFile.setCompressedPath(compressRelativePath);
		m_uploadFile.setCompressedStorePath(compressStorePath);

		return m_imageService.insert(m_upload, m_uploadFile, Image.NEWS, Image.NEWS_WIDTH, Image.NEWS_HEIGHT, true,
		      Image.NEWS_SMALL_WIDTH, Image.NEWS_SMALL_HEIGHT);

	}

	public String newsList() {
		try {
			// m_categoryList = m_categoryService.queryAllCategories(Category.NEWS);
			// m_smallCategoryList = m_categoryService.queryAllSmallCategoryByTypeCategoryId(Category.NEWS, m_categoryId);
			// int totalSize = m_newsService.queryTotalSize(m_categoryId, m_smallCategoryId);
			// int totalSize = m_newsService.queryTotalSize(m_categoryId, m_smallCategoryId,m_status,m_recommand);
			// m_pagedTool.setTotalNumber(totalSize);

			// m_newsList = m_newsService.queryPagedNews(m_pagedTool, m_categoryId, m_smallCategoryId);
			// m_newsList = m_newsService.queryPagedNews(m_pagedTool, m_categoryId,
			// m_smallCategoryId,m_status,m_recommand);
			m_newsList = m_newsService.queryAllNews();
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String newsAdd() {
		try {
			m_categoryList = m_categoryService.queryAllCategories(Category.NEWS);

			if (m_categoryId == 0) {
				if (m_categoryList != null && m_categoryList.size() > 0) {
					Category temp = m_categoryList.get(0);
					m_categoryId = temp.getId();
				}
			}
			m_smallCategoryList = m_categoryService.queryAllSmallCategoryByTypeCategoryId(Category.NEWS, m_categoryId);
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

			if (m_news.getRecommend() == 0) {
				m_news.setRecommend(1);
			}
			if (m_news.getStatus() == 0) {
				m_news.setStatus(1);
			}
			if (m_news.getValidateDate() == null) {
				m_news.setValidateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
			}
			int id = m_newsService.insertNews(m_news);

			m_categoryId = m_news.getCategoryId();
			m_smallCategoryId = m_news.getSmallCategoryId();
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

			if (m_news != null) {
				if (m_news.getImageId() > 0) {
					m_news.setImage(m_imageService.findImage(m_news.getImageId()));
				}
				m_categoryList = m_categoryService.queryAllCategories(Category.NEWS);
				m_smallCategoryList = m_categoryService.queryAllSmallCategoryByTypeCategoryId(Category.NEWS,
				      m_news.getCategoryId());
			}
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

			m_categoryId = m_news.getCategoryId();
			m_smallCategoryId = m_news.getSmallCategoryId();
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
			m_news = m_newsService.findNews(m_newsId);
			m_smallCategoryId = m_news.getSmallCategoryId();
			m_categoryId = m_news.getCategoryId();
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

	public int getStatus() {
		return m_status;
	}

	public void setStatus(int status) {
		m_status = status;
	}

	public int getRecommand() {
		return m_recommand;
	}

	public void setRecommand(int recommand) {
		m_recommand = recommand;
	}

}