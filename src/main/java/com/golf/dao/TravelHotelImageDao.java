package com.golf.dao;

import java.util.List;

import com.golf.entity.TravelHotelImage;

public class TravelHotelImageDao {

	private BaseDao m_baseDao;

	public int delete(int id) {
		return (Integer) m_baseDao.delete("travelHotelImage.delete", id);
	}

	@SuppressWarnings("rawtypes")
   public List findAllTravelHotelImage() {
		return m_baseDao.queryForList("travelHotelImage.findAll");
	}

	public TravelHotelImage findById(int id) {
		return (TravelHotelImage) m_baseDao.queryForObject("travelHotelImage.findById", id);
	}

	public int insert(TravelHotelImage travelHotelImage) {
		return (Integer) m_baseDao.insert("travelHotelImage.insert", travelHotelImage);
	}

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	public int update(TravelHotelImage travelHotelImage) {
		return m_baseDao.update("travelHotelImage.update", travelHotelImage);
	}
}
