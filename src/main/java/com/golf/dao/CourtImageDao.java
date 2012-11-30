package com.golf.dao;

import java.util.List;

import com.golf.entity.CourtImage;

public class CourtImageDao {

	private BaseDao m_baseDao;

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	@SuppressWarnings("rawtypes")
   public List findAllCourtImage() {
		return m_baseDao.queryForList("courtImage.findAll");
	}

	public CourtImage findById(int id) {
		return (CourtImage) m_baseDao.queryForObject("courtImage.findById", id);
	}

	public int insert(CourtImage courtImage) {
		return (Integer) m_baseDao.insert("courtImage.insert", courtImage);
	}

	public int update(CourtImage courtImage) {
		return m_baseDao.update("courtImage.update", courtImage);
	}

	public int delete(int id) {
		return (Integer) m_baseDao.delete("courtImage.delete", id);
	}
}
