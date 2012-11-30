package com.golf.dao;

import java.util.List;

import com.golf.entity.NewsComments;

public class NewsCommentsDao {

	private BaseDao m_baseDao;

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	@SuppressWarnings("rawtypes")
   public List findAllNewsComments() {
		return m_baseDao.queryForList("newsComments.findAll");
	}

	public NewsComments findById(int id) {
		return (NewsComments) m_baseDao.queryForObject("newsComments.findById", id);
	}

	public int insert(NewsComments newsComments) {
		return (Integer) m_baseDao.insert("newsComments.insert", newsComments);
	}

	public int update(NewsComments newsComments) {
		return m_baseDao.update("newsComments.update", newsComments);
	}

	public int delete(int id) {
		return (Integer) m_baseDao.delete("newsComments.delete", id);
	}
}
