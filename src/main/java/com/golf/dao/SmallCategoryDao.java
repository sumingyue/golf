package com.golf.dao;

import java.util.List;

import com.golf.entity.SmallCategory;

public class SmallCategoryDao {

	private BaseDao m_baseDao;

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	@SuppressWarnings("rawtypes")
	public List findAllSmallCategory() {
		return m_baseDao.queryForList("smallCategory.findAll");
	}

	@SuppressWarnings("rawtypes")
	public List findAllByCategoryId(int categoryId) {
		return m_baseDao.queryForList("smallCategory.findByCategoryId", categoryId);
	}

	public SmallCategory findById(int id) {
		return (SmallCategory) m_baseDao.queryForObject("smallCategory.findById", id);
	}

	public int insert(SmallCategory smallCategory) {
		return (Integer) m_baseDao.insert("smallCategory.insert", smallCategory);
	}

	public int update(SmallCategory smallCategory) {
		return m_baseDao.update("smallCategory.update", smallCategory);
	}

	public int delete(int id) {
		return (Integer) m_baseDao.delete("smallCategory.delete", id);
	}
}
