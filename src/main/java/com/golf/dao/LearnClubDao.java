package com.golf.dao;

import java.util.List;

import com.golf.entity.LearnClub;

public class LearnClubDao {

	private BaseDao m_baseDao;

	public int delete(int id) {
		return (Integer) m_baseDao.delete("learnClub.delete", id);
	}

	@SuppressWarnings("rawtypes")
   public List findAllLearnClub() {
		return m_baseDao.queryForList("learnClub.findAll");
	}

	public LearnClub findById(int id) {
		return (LearnClub) m_baseDao.queryForObject("learnClub.findById", id);
	}

	public int insert(LearnClub learnClub) {
		return (Integer) m_baseDao.insert("learnClub.insert", learnClub);
	}

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	public int update(LearnClub learnClub) {
		return m_baseDao.update("learnClub.update", learnClub);
	}
}
