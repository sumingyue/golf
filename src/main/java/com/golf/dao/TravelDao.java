package com.golf.dao;

import java.util.List;

import com.golf.entity.Travel;

public class TravelDao {

	private BaseDao m_baseDao;

	public int delete(int id) {
		return (Integer) m_baseDao.delete("travel.delete", id);
	}
	
	@SuppressWarnings("rawtypes")
   public List findAllTravel() {
		return m_baseDao.queryForList("travel.findAll");
	}

	public Travel findById(int id) {
		return (Travel) m_baseDao.queryForObject("travel.findById", id);
	}

	public int insert(Travel travel) {
		return (Integer) m_baseDao.insert("travel.insert", travel);
	}

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	public int update(Travel travel) {
		return m_baseDao.update("travel.update", travel);
	}
}
