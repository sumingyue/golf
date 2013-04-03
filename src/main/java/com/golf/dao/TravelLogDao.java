package com.golf.dao;

import java.util.List;

import com.golf.entity.TravelLog;

public class TravelLogDao {

	private BaseDao m_baseDao;

	public int delete(int id) {
		return (Integer) m_baseDao.delete("travelLog.delete", id);
	}

	@SuppressWarnings("rawtypes")
   public List findAllTravelLog() {
		return m_baseDao.queryForList("travelLog.findAll");
	}

	public TravelLog findById(int id) {
		return (TravelLog) m_baseDao.queryForObject("travelLog.findById", id);
	}

	public int insert(TravelLog travelLog) {
		return (Integer) m_baseDao.insert("travelLog.insert", travelLog);
	}

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	public int update(TravelLog travelLog) {
		return m_baseDao.update("travelLog.update", travelLog);
	}
}
