package com.golf.dao;

import java.util.List;

import com.golf.entity.Team;

public class TeamDao {

	private BaseDao m_baseDao;

	public int delete(int id) {
		return (Integer) m_baseDao.delete("team.delete", id);
	}

	@SuppressWarnings("rawtypes")
	public List findAllTeam() {
		return m_baseDao.queryForList("team.findAll");
	}

	public Team findById(int id) {
		return (Team) m_baseDao.queryForObject("team.findById", id);
	}

	public int insert(Team team) {
		return (Integer) m_baseDao.insert("team.insert", team);
	}

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	public int update(Team team) {
		return m_baseDao.update("team.update", team);
	}

	public int updateLogo(int id, int imageId) {
		Team team = new Team();
		team.setId(id);
		team.setImageId(imageId);
		return (Integer) m_baseDao.update("team.updateLogo", team);
	}
}
