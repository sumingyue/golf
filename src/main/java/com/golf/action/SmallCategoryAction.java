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

	private int m_categoryId;

	private int m_smallCategoryId;

	private CategoryService m_categoryService;

	private SmallCategory m_smallCategory = new SmallCategory();
	
	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public String smallCategoryList() {
		try {
			m_categories = m_categoryService.queryAllCategories();
			m_pagedTool.setTotalNumber( m_categoryService.queryAllSmallCategoryByCategoryId(m_categoryId).size());
			m_smallCategories = m_categoryService.queryPagedSmallCategoryByCategoryId(m_pagedTool,m_categoryId);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String smallCategoryAdd() {
		m_categories = m_categoryService.queryAllCategories();
		return SUCCESS;
	}

	public String smallCategoryAddSubmit() {
		try {
			m_categoryId = m_smallCategory.getCategoryId();
			int id = m_categoryService.insertSmallCategory(m_smallCategory);
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

	public String smallCategoryUpdate() {
		try {
			m_categories = m_categoryService.queryAllCategories();
			m_smallCategory = m_categoryService.findSmallCategory(m_smallCategoryId);
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

	public void setIndex(int index){
		m_pagedTool.setPageIndex(index);
	}
}