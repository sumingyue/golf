package com.golf.action;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.golf.Config;
import com.golf.entity.Category;
import com.golf.entity.Image;
import com.golf.entity.ImageSpecial;
import com.golf.entity.SmallCategory;
import com.golf.entity.UploadFile;
import com.golf.service.CategoryService;
import com.golf.service.ImageService;
import com.golf.service.ImageSpecialService;
import com.golf.tools.ImageTools;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class ImageSpecialAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(ImageSpecialAction.class);

	private List<ImageSpecial> m_imageSpecials;

	private int m_imageSpecialId;

	private int m_categoryId;

	private int m_smallCategoryId;

	private CategoryService m_categoryService;

	private List<Category> m_categoryList;

	private List<SmallCategory> m_smallCategoryList;

	private ImageSpecialService m_imageSpecialService;

	private ImageSpecial m_imageSpecial = new ImageSpecial();

	private ImageService m_imageService;

	private UploadFile m_uploadFile = new UploadFile();

	private File m_upload;

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public int getCategoryId() {
		return m_categoryId;
	}

	public List<Category> getCategoryList() {
		return m_categoryList;
	}

	public ImageSpecial getImageSpecial() {
		return m_imageSpecial;
	}

	public List<ImageSpecial> getImageSpecials() {
		return m_imageSpecials;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public int getSmallCategoryId() {
		return m_smallCategoryId;
	}

	public List<SmallCategory> getSmallCategoryList() {
		return m_smallCategoryList;
	}

	public String imageSpecialAdd() {
		try {
			m_categoryList = m_categoryService.queryAllCategories(Category.IMAGE);

			if (m_categoryId == 0) {
				if (m_categoryList != null && m_categoryList.size() > 0) {
					Category temp = m_categoryList.get(0);
					m_categoryId = temp.getId();
				}
			}
			m_smallCategoryList = m_categoryService.queryAllSmallCategoryByTypeCategoryId(Category.IMAGE, m_categoryId);

			return SUCCESS;
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public String imageSpecialAddSubmit() {
		try {
			if (m_upload != null) {
				int imageId = insertImage();
				m_imageSpecial.setImageId(imageId);
			}
			int id = m_imageSpecialService.insertImageSpecial(m_imageSpecial);

			m_categoryId = m_imageSpecial.getCategoryId();
			m_smallCategoryId = m_imageSpecial.getSmallCategoryId();
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

	public String imageSpecialDelete() {
		try {
			m_imageSpecial = m_imageSpecialService.findImageSpecial(m_imageSpecialId);
			m_smallCategoryId = m_imageSpecial.getSmallCategoryId();
			m_categoryId = m_imageSpecial.getCategoryId();
			int count = m_imageSpecialService.deleteImageSpecial(m_imageSpecialId);
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

	public String imageSpecialList() {
		try {
			//m_categoryList = m_categoryService.queryAllCategories(Category.IMAGE);
			//m_smallCategoryList = m_categoryService.queryAllSmallCategoryByTypeCategoryId(Category.IMAGE, m_categoryId);

			//m_pagedTool
			//      .setTotalNumber(m_imageSpecialService.queryAllImageSpecials(m_categoryId, m_smallCategoryId).size());
			//m_imageSpecials = m_imageSpecialService.queryPagedImageSpecials(m_pagedTool, m_categoryId, m_smallCategoryId);
			m_imageSpecials = m_imageSpecialService.queryAllImageSpecials();

			for (ImageSpecial temp : m_imageSpecials) {
				temp.setCategory(m_categoryService.findCategory(temp.getCategoryId()));
				temp.setSmallCategory(m_categoryService.findSmallCategory(temp.getSmallCategoryId()));
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String imageSpecialUpdate() {
		try {
			m_imageSpecial = m_imageSpecialService.findImageSpecial(m_imageSpecialId);
			m_imageSpecial.setImage(m_imageService.findImage(m_imageSpecial.getImageId()));
			m_categoryList = m_categoryService.queryAllCategories(Category.IMAGE);
			m_smallCategoryList = m_categoryService.queryAllSmallCategoryByTypeCategoryId(Category.IMAGE,
			      m_imageSpecial.getCategoryId());

		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String imageSpecialUpdateSubmit() {
		try {
			if (m_upload != null) {
				int imageId = insertImage();
				m_imageSpecial.setImageId(imageId);
			} else {
				m_imageSpecial.setImageId(m_imageSpecialService.findImageSpecial(m_imageSpecial.getId()).getImageId());
			}
			int count = m_imageSpecialService.updateImageSpecial(m_imageSpecial);

			m_categoryId = m_imageSpecial.getCategoryId();
			m_smallCategoryId = m_imageSpecial.getSmallCategoryId();
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

	private int insertImage() {
		String fileName = m_uploadFile.getFilename();
		String relativePath = Config.IMAGE_PATH + ImageTools.getImageStorePath(fileName, "_normal", Image.PIC);
		String storePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + relativePath;

		String compressRelativePath = Config.IMAGE_PATH + ImageTools.getImageStorePath(fileName, "_small", Image.PIC);
		String compressStorePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + compressRelativePath;

		String originalPath = ImageTools.getOriginalPath(fileName, Image.PIC);
		m_uploadFile.setOriginalPath(originalPath);

		m_uploadFile.setPath(relativePath);
		m_uploadFile.setStorePath(storePath);

		m_uploadFile.setCompressedPath(compressRelativePath);
		m_uploadFile.setCompressedStorePath(compressStorePath);

		return m_imageService.insert(m_upload, m_uploadFile, Image.PIC, Image.PIC_MAIN_WIDTH, Image.PIC_MAIN_HEIGHT,
		      true, Image.PIC_MAIN_SMALL_WIDTH, Image.PIC_MAIN_SMALL_HEIGHT);

	}

	public void setCategoryId(int categoryId) {
		m_categoryId = categoryId;
	}

	public void setCategoryService(CategoryService categoryService) {
		m_categoryService = categoryService;
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public void setImageSpecial(ImageSpecial imageSpecial) {
		m_imageSpecial = imageSpecial;
	}

	public void setImageSpecialId(int imageSpecialId) {
		m_imageSpecialId = imageSpecialId;
	}

	public void setImageSpecialService(ImageSpecialService imageSpecialService) {
		m_imageSpecialService = imageSpecialService;
	}

	public void setIndex(int index) {
		m_pagedTool.setPageIndex(index);
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}

	public void setSmallCategoryId(int smallCategoryId) {
		m_smallCategoryId = smallCategoryId;
	}

	public void setUpload(File file) {
		m_upload = file;
	}

	public void setUploadContentType(String contentType) {
		m_uploadFile.setContentType(contentType);
	}

	public void setUploadFileName(String filename) {
		m_uploadFile.setFilename(filename);
	}

}