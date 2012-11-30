package com.golf.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.Category;
import com.golf.service.CategoryService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(CategoryAction.class);

	private List<Category> m_categories;

	private int m_categoryId;

	private CategoryService m_categoryService;

	private Category m_category = new Category();
	
	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public String categoryList() {
		try {
			m_pagedTool.setTotalNumber(m_categoryService.queryAllCategories().size());
			m_categories = m_categoryService.queryPagedCategories(m_pagedTool);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String categoryAddSubmit() {
		try {
			int id = m_categoryService.insertCategory(m_category);
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

	public String categoryUpdate() {
		try {
			m_category = m_categoryService.findCategory(m_categoryId);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String categoryUpdateSubmit() {
		try {
			int count = m_categoryService.updateCategory(m_category);
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

	public String categoryDelete() {
		try {
			int count = m_categoryService.deleteCategory(m_categoryId);
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

	public Category getCategory() {
		return m_category;
	}

	public void setCategory(Category category) {
		m_category = category;
	}

	public void setCategoryService(CategoryService categoryService) {
		m_categoryService = categoryService;
	}

	public List<Category> getCategories() {
		return m_categories;
	}

	public void setCategoryId(int categoryId) {
		m_categoryId = categoryId;
	}
	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}

	public void setIndex(int index){
		m_pagedTool.setPageIndex(index);
	}
}