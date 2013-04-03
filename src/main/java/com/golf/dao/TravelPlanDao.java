package com.golf.dao;

import java.util.List;

import com.golf.entity.TravelPlan;

public class TravelPlanDao {

	private BaseDao m_baseDao;

	public int delete(int id) {
		return (Integer) m_baseDao.delete("travelPlan.delete", id);
	}

	@SuppressWarnings("rawtypes")
   public List findAllTravelPlan() {
		return m_baseDao.queryForList("travelPlan.findAll");
	}

	public TravelPlan findById(int id) {
		return (TravelPlan) m_baseDao.queryForObject("travelPlan.findById", id);
	}

	public int insert(TravelPlan travelPlan) {
		return (Integer) m_baseDao.insert("travelPlan.insert", travelPlan);
	}

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	public int update(TravelPlan travelPlan) {
		return m_baseDao.update("travelPlan.update", travelPlan);
	}
}
