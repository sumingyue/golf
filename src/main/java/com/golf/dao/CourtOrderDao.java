package com.golf.dao;

import java.util.List;

import com.golf.entity.CourtOrder;

public class CourtOrderDao {

	private BaseDao m_baseDao;

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	@SuppressWarnings("rawtypes")
   public List findAllCourtOrder() {
		return m_baseDao.queryForList("courtOrder.findAll");
	}

	public CourtOrder findById(int id) {
		return (CourtOrder) m_baseDao.queryForObject("courtOrder.findById", id);
	}

	public int insert(CourtOrder courtOrder) {
		return (Integer) m_baseDao.insert("courtOrder.insert", courtOrder);
	}

	public int update(CourtOrder courtOrder) {
		return m_baseDao.update("courtOrder.update", courtOrder);
	}

	public int delete(int id) {
		return (Integer) m_baseDao.delete("courtOrder.delete", id);
	}
}
