package com.golf.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.Category;
import com.golf.entity.SmallCategory;
import com.golf.service.CategoryService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class SmallCategoryAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(SmallCategoryAction.class);

	private List<Category> m_categories;

	private List<SmallCategory> m_smallCategories;

	private int m_type;

	private int m_categoryId;

	private int m_smallCategoryId;

	private CategoryService m_categoryService;

	private SmallCategory m_smallCategory = new SmallCategory();

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public String queryAllSmallCategoryList() {
		m_smallCategories = m_categoryService.queryAllSmallCategoryByTypeCategoryId(m_type, m_categoryId);
		return SUCCESS;
	}

	public String smallCategoryList() {
		try {
//			m_categories = m_categoryService.queryAllCategories(m_type);
//			m_pagedTool.setTotalNumber(m_categoryService.queryAllSmallCategoryByTypeCategoryId(m_type, m_categoryId)
//			      .size());
//			m_smallCategories = m_categoryService.queryPagedSmallCategoryByTypeCategoryId(m_pagedTool, m_type,
//			      m_categoryId);
			m_smallCategories = m_categoryService.queryAllSmallCategory();
//			m_smallCategories = m_categoryService.queryAllSmallCategoryByTypeCategoryId(0, 0);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String smallCategoryAdd() {
		m_categories = m_categoryService.queryAllCategories(m_type);
		return SUCCESS;
	}

	public String smallCategoryAddSubmit() {
		try {
			m_categoryId = m_smallCategory.getCategoryId();
			int id = m_categoryService.insertSmallCategory(m_smallCategory);
			if (id > 0) {
				int temp = m_smallCategory.getCategoryId();
				Category category = m_categoryService.findCategory(temp);
				m_type = category.getType();
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public String smallCategoryUpdate() {
		try {
			// m_categories = m_categoryService.queryAllCategories(m_type);
			m_smallCategory = m_categoryService.findSmallCategory(m_smallCategoryId);

			int categoryId = m_smallCategory.getCategoryId();
			Category category = m_categoryService.findCategory(categoryId);
			m_categories = m_categoryService.queryAllCategories(category.getType());
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String smallCategoryUpdateSubmit() {
		try {
			m_categoryId = m_smallCategory.getCategoryId();
			int count = m_categoryService.updateSmallCategory(m_smallCategory);
			if (count > 0) {
				int temp = m_smallCategory.getCategoryId();
				Category category = m_categoryService.findCategory(temp);
				m_type = category.getType();
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public String smallCategoryDelete() {
		try {
			m_categoryId = m_categoryService.findSmallCategory(m_smallCategoryId).getCategoryId();
			int count = m_categoryService.deleteSmallCategory(m_smallCategoryId);
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

	public SmallCategory getSmallCategory() {
		return m_smallCategory;
	}

	public void setSmallCategory(SmallCategory smallCategory) {
		m_smallCategory = smallCategory;
	}

	public void setSmallCategoryId(int smallCategoryId) {
		m_smallCategoryId = smallCategoryId;
	}

	public int getCategoryId() {
		return m_categoryId;
	}

	public void setCategoryId(int categoryId) {
		m_categoryId = categoryId;
	}

	public List<SmallCategory> getSmallCategories() {
		return m_smallCategories;
	}

	public void setCategoryService(CategoryService categoryService) {
		m_categoryService = categoryService;
	}

	public List<Category> getCategories() {
		return m_categories;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}

	public void setIndex(int index) {
		m_pagedTool.setPageIndex(index);
	}

	public int getType() {
		return m_type;
	}

	public void setType(int type) {
		m_type = type;
	}

}