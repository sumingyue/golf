package com.golf.dao;

import java.util.List;

import com.golf.entity.CourtRaider;

public class CourtRaiderDao {

	private BaseDao m_baseDao;

	public int delete(int id) {
		return (Integer) m_baseDao.delete("courtRaider.delete", id);
	}

	@SuppressWarnings("rawtypes")
   public List findAllCourtRaider() {
		return m_baseDao.queryForList("courtRaider.findAll");
	}

	public CourtRaider findById(int id) {
		return (CourtRaider) m_baseDao.queryForObject("courtRaider.findById", id);
	}

	public int insert(CourtRaider courtRaider) {
		return (Integer) m_baseDao.insert("courtRaider.insert", courtRaider);
	}

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	public int update(CourtRaider courtRaider) {
		return m_baseDao.update("courtRaider.update", courtRaider);
	}
}
