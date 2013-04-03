package com.golf.dao;

import java.util.List;

import com.golf.entity.Media;

public class MediaDao {

	private BaseDao m_baseDao;

	public int delete(int id) {
		return (Integer) m_baseDao.delete("media.delete", id);
	}

	@SuppressWarnings("rawtypes")
   public List findAllMedia() {
		return m_baseDao.queryForList("media.findAll");
	}

	public Media findById(int id) {
		return (Media) m_baseDao.queryForObject("media.findById", id);
	}

	public int insert(Media media) {
		return (Integer) m_baseDao.insert("media.insert", media);
	}

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	public int update(Media media) {
		return m_baseDao.update("media.update", media);
	}
}
