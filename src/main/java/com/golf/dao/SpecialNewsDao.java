package com.golf.dao;

import java.util.List;

import com.golf.entity.SpecialNews;

public class SpecialNewsDao {

	private BaseDao m_baseDao;

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	@SuppressWarnings("rawtypes")
   public List findAllSpecialNews() {
		return m_baseDao.queryForList("specialNews.findAll");
	}

	public SpecialNews findById(int id) {
		return (SpecialNews) m_baseDao.queryForObject("specialNews.findById", id);
	}

	public int insert(SpecialNews specialNews) {
		return (Integer) m_baseDao.insert("specialNews.insert", specialNews);
	}

	public int update(SpecialNews specialNews) {
		return m_baseDao.update("specialNews.update", specialNews);
	}

	public int delete(int id) {
		return (Integer) m_baseDao.delete("specialNews.delete", id);
	}
}
