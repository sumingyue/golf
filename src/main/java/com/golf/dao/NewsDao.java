package com.golf.dao;

import java.util.List;

import com.golf.entity.News;

public class NewsDao {

	private BaseDao m_baseDao;

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	@SuppressWarnings("rawtypes")
	public List findAllNews() {
		return m_baseDao.queryForList("news.findAll");
	}

	public News findById(int id) {
		return (News) m_baseDao.queryForObject("news.findById", id);
	}

	public int insert(News news) {
		return (Integer) m_baseDao.insert("news.insert", news);
	}

	public int update(News news) {
		return m_baseDao.update("news.update", news);
	}

	public int delete(int id) {
		return (Integer) m_baseDao.delete("news.delete", id);
	}
}
