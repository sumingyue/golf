package com.golf.dao;

import java.util.List;

import com.golf.entity.NewsCategory;

public class NewsCategoryDao {

	private BaseDao m_baseDao;

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	@SuppressWarnings("rawtypes")
	public List findAllNewsCategory() {
		return m_baseDao.queryForList("newsCategory.findAll");
	}

	@SuppressWarnings("rawtypes")
	public List findAllByCategoryId(int categoryId) {
		return m_baseDao.queryForList("newsCategory.findByCategoryIdId", categoryId);
	}

	@SuppressWarnings("rawtypes")
	public List findAllBySmallCategoryId(int smallCategoryId) {
		return m_baseDao.queryForList("newsCategory.findBySmallCategoryIdId", smallCategoryId);
	}

	public int insert(NewsCategory newsCategory) {
		return (Integer) m_baseDao.insert("newsCategory.insert", newsCategory);
	}

	public int update(NewsCategory newsCategory) {
		return m_baseDao.update("newsCategory.update", newsCategory);
	}

	public int delete(NewsCategory newsCategory) {
		return (Integer) m_baseDao.delete("newsCategory.delete", newsCategory);
	}
}
