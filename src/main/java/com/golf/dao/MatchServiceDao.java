package com.golf.dao;

import java.util.List;

import com.golf.entity.MatchService;

public class MatchServiceDao {

	private BaseDao m_baseDao;

	public int delete(int id) {
		return (Integer) m_baseDao.delete("matchService.delete", id);
	}

	@SuppressWarnings("rawtypes")
   public List findAllMatchService() {
		return m_baseDao.queryForList("matchService.findAll");
	}

	public MatchService findById(int id) {
		return (MatchService) m_baseDao.queryForObject("matchService.findById", id);
	}

	public int insert(MatchService matchService) {
		return (Integer) m_baseDao.insert("matchService.insert", matchService);
	}

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	public int update(MatchService matchService) {
		return m_baseDao.update("matchService.update", matchService);
	}
}
