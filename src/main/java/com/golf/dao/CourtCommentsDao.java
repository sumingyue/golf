package com.golf.dao;

import java.util.List;

import com.golf.entity.CourtComments;

public class CourtCommentsDao {

	private BaseDao m_baseDao;

	public int delete(int id) {
		return (Integer) m_baseDao.delete("courtComments.delete", id);
	}

	@SuppressWarnings("rawtypes")
   public List findAllCourtComments() {
		return m_baseDao.queryForList("courtComments.findAll");
	}

	public CourtComments findById(int id) {
		return (CourtComments) m_baseDao.queryForObject("courtComments.findById", id);
	}

	public int insert(CourtComments courtComments) {
		return (Integer) m_baseDao.insert("courtComments.insert", courtComments);
	}

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	public int update(CourtComments courtComments) {
		return m_baseDao.update("courtComments.update", courtComments);
	}
}
