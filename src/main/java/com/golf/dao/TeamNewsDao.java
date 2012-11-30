package com.golf.dao;

import java.util.List;

import com.golf.entity.TeamNews;

public class TeamNewsDao {

	private BaseDao m_baseDao;

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	@SuppressWarnings("rawtypes")
   public List findAllTeamNews() {
		return m_baseDao.queryForList("teamNews.findAll");
	}

	public TeamNews findById(int id) {
		return (TeamNews) m_baseDao.queryForObject("teamNews.findById", id);
	}

	public int insert(TeamNews teamNews) {
		return (Integer) m_baseDao.insert("teamNews.insert", teamNews);
	}

	public int update(TeamNews teamNews) {
		return m_baseDao.update("teamNews.update", teamNews);
	}

	public int delete(int id) {
		return (Integer) m_baseDao.delete("teamNews.delete", id);
	}
}
