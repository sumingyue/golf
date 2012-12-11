package com.golf.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.CategoryDao;
import com.golf.dao.SmallCategoryDao;
import com.golf.entity.Category;
import com.golf.entity.SmallCategory;
import com.golf.service.CategoryService;
import com.golf.tools.PagedTool;

public class CategoryServiceImpl implements InitializingBean, CategoryService {

	private CategoryDao m_categoryDao;

	private SmallCategoryDao m_smallCategoryDao;

	private Map<Integer, Category> m_categories = new LinkedHashMap<Integer, Category>();

	private Map<Integer, SmallCategory> m_smallCategories = new LinkedHashMap<Integer, SmallCategory>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<Category> categories = m_categoryDao.findAllCategory();

		for (Category category : categories) {
			System.out.println(category.getName());
			m_categories.put(category.getId(), category);
		}

		List<SmallCategory> smallCategories = m_smallCategoryDao.findAllSmallCategory();

		for (SmallCategory smallCategory : smallCategories) {
			int categoryId = smallCategory.getCategoryId();
			Category category = m_categories.get(categoryId);

			if (category != null) {
				smallCategory.setCategory(category);
			}
			m_smallCategories.put(smallCategory.getId(), smallCategory);
		}

	}

	@Override
	public List<Category> queryAllCategories(int type) {
		ArrayList<Category> all = new ArrayList<Category>(m_categories.values());
		List<Category> result = new ArrayList<Category>();

		for (Category temp : all) {
			if (temp.getType() == type) {
				result.add(temp);
			}
		}
		return result;
	}

	@Override
	public int insertCategory(Category category) {
		int id = m_categoryDao.insert(category);
		if (id > 0) {
			m_categories.put(category.getId(), category);
		}
		return id;
	}

	@Override
	public int updateCategory(Category category) {
		int id = m_categoryDao.update(category);
		if (id > 0) {
			m_categories.put(category.getId(), category);
		}
		return id;
	}

	@Override
	public int deleteCategory(int categoryId) {
		int id = m_categoryDao.delete(categoryId);
		if (id > 0) {
			m_categories.remove(categoryId);
		}
		return id;
	}

	@Override
	public Category findCategory(int categoryId) {
		Category category = m_categories.get(categoryId);
		if (category == null) {
			Category temp = m_categoryDao.findById(categoryId);
			if (temp != null) {
				m_categories.put(categoryId, temp);
			}
			return temp;
		}
		return category;
	}

	@Override
	public List<SmallCategory> queryAllSmallCategoryByTypeCategoryId(int type, int categoryId) {
		List<SmallCategory> smallCategories = new ArrayList<SmallCategory>();

		for (SmallCategory smallCategory : m_smallCategories.values()) {
			Category category = findCategory(smallCategory.getCategoryId());

			if (category != null && category.getType() == type) {
				if (smallCategory.getCategoryId() == categoryId || categoryId == 0) {
					smallCategories.add(smallCategory);
				}
			}
		}
		return smallCategories;
	}

	@Override
	public int insertSmallCategory(SmallCategory smallCategory) {
		int id = m_smallCategoryDao.insert(smallCategory);
		if (id > 0) {
			Category category = findCategory(smallCategory.getCategoryId());

			smallCategory.setCategory(category);
			m_smallCategories.put(id, smallCategory);
		}
		return id;
	}

	@Override
	public int updateSmallCategory(SmallCategory smallCategory) {
		int id = m_smallCategoryDao.update(smallCategory);
		if (id > 0) {
			Category category = findCategory(smallCategory.getCategoryId());

			smallCategory.setCategory(category);
			m_smallCategories.put(smallCategory.getId(), smallCategory);
		}
		return id;
	}

	@Override
	public int deleteSmallCategory(int smallCategoryId) {
		int id = m_smallCategoryDao.delete(smallCategoryId);
		if (id > 0) {
			m_smallCategories.remove(smallCategoryId);
		}
		return id;
	}

	@Override
	public SmallCategory findSmallCategory(int smallCategoryId) {
		SmallCategory smallCategory = m_smallCategories.get(smallCategoryId);
		if (smallCategory == null) {
			SmallCategory temp = m_smallCategoryDao.findById(smallCategoryId);
			if (temp != null) {
				m_smallCategories.put(smallCategoryId, temp);
			}
			return temp;
		}
		return smallCategory;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		m_categoryDao = categoryDao;
	}

	public void setSmallCategoryDao(SmallCategoryDao smallCategoryDao) {
		m_smallCategoryDao = smallCategoryDao;
	}

	@Override
	public List<Category> queryPagedCategories(PagedTool tool, int type) {
		List<Category> result = queryAllCategories(type);
		return result.subList(tool.getFromIndex(), tool.getToIndex());
	}

	@Override
	public List<SmallCategory> queryPagedSmallCategoryByTypeCategoryId(PagedTool pagedTool, int type, int categoryId) {
		List<SmallCategory> result = queryAllSmallCategoryByTypeCategoryId(type, categoryId);
		return result.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());

	}

}
