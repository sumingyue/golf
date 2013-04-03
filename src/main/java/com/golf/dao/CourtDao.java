package com.golf.dao;

import java.util.List;

import com.golf.entity.Court;

public class CourtDao {

	private BaseDao m_baseDao;

	public int delete(int id) {
		return (Integer) m_baseDao.delete("court.delete", id);
	}

	@SuppressWarnings("rawtypes")
   public List findAllCourt() {
		return m_baseDao.queryForList("court.findAll");
	}

	public Court findById(int id) {
		return (Court) m_baseDao.queryForObject("court.findById", id);
	}

	public int insert(Court court) {
		return (Integer) m_baseDao.insert("court.insert", court);
	}

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	public int update(Court court) {
		return m_baseDao.update("court.update", court);
	}
}
