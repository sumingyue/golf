package com.golf.dao;

import java.util.List;

import com.golf.entity.DrivingRange;

public class DrivingRangeDao {

	private BaseDao m_baseDao;

	public int delete(int id) {
		return (Integer) m_baseDao.delete("drivingRange.delete", id);
	}

	@SuppressWarnings("rawtypes")
   public List findAllDrivingRange() {
		return m_baseDao.queryForList("drivingRange.findAll");
	}

	public DrivingRange findById(int id) {
		return (DrivingRange) m_baseDao.queryForObject("drivingRange.findById", id);
	}

	public int insert(DrivingRange drivingRange) {
		return (Integer) m_baseDao.insert("drivingRange.insert", drivingRange);
	}

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	public int update(DrivingRange drivingRange) {
		return m_baseDao.update("drivingRange.update", drivingRange);
	}
}
