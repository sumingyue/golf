package com.golf.dao;

import java.util.List;

import com.golf.entity.Category;

public class CategoryDao {

	private BaseDao m_baseDao;

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	@SuppressWarnings("rawtypes")
   public List findAllCategory() {
		return m_baseDao.queryForList("category.findAll");
	}

	public Category findById(int id) {
		return (Category) m_baseDao.queryForObject("category.findById", id);
	}

	public int insert(Category category) {
		return (Integer) m_baseDao.insert("category.insert", category);
	}

	public int update(Category category) {
		return m_baseDao.update("category.update", category);
	}

	public int delete(int id) {
		return (Integer) m_baseDao.delete("category.delete", id);
	}
}
