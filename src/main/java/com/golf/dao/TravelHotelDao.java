package com.golf.dao;

import java.util.List;

import com.golf.entity.TravelHotel;

public class TravelHotelDao {

	private BaseDao m_baseDao;

	public int delete(int id) {
		return (Integer) m_baseDao.delete("travelHotel.delete", id);
	}

	@SuppressWarnings("rawtypes")
   public List findAllTravelHotel() {
		return m_baseDao.queryForList("travelHotel.findAll");
	}

	public TravelHotel findById(int id) {
		return (TravelHotel) m_baseDao.queryForObject("travelHotel.findById", id);
	}

	public int insert(TravelHotel travelHotel) {
		return (Integer) m_baseDao.insert("travelHotel.insert", travelHotel);
	}

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	public int update(TravelHotel travelHotel) {
		return m_baseDao.update("travelHotel.update", travelHotel);
	}
}
