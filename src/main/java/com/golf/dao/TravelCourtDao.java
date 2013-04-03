package com.golf.dao;

import java.util.List;

import com.golf.entity.TravelCourt;

public class TravelCourtDao {

	private BaseDao m_baseDao;

	public int delete(int id) {
		return (Integer) m_baseDao.delete("travelCourt.delete", id);
	}

	public int deleteByTravelId(int travelId) {
		return (Integer) m_baseDao.delete("travelCourt.deleteByTravelId", travelId);
	}

	@SuppressWarnings("rawtypes")
	public List findAllTravelCourt() {
		return m_baseDao.queryForList("travelCourt.findAll");
	}

	public TravelCourt findById(int id) {
		return (TravelCourt) m_baseDao.queryForObject("travelCourt.findById", id);
	}

	public int insert(TravelCourt travelCourt) {
		return (Integer) m_baseDao.insert("travelCourt.insert", travelCourt);
	}

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	public int update(TravelCourt travelCourt) {
		return m_baseDao.update("travelCourt.update", travelCourt);
	}

	@SuppressWarnings("rawtypes")
	public List queryAllByTravelId(int travelId) {
		return m_baseDao.queryForList("travelCourt.queryAllByTravelId", travelId);
	}
}
