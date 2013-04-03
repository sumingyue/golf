package com.golf.dao;

import java.util.List;

import com.golf.entity.TeamMemberImage;

public class TeamMemberImageDao {

	private BaseDao m_baseDao;

	public int delete(int id) {
		return (Integer) m_baseDao.delete("teamMemberImage.delete", id);
	}

	@SuppressWarnings("rawtypes")
   public List findAllTeamMemberImage() {
		return m_baseDao.queryForList("teamMemberImage.findAll");
	}

	public TeamMemberImage findById(int id) {
		return (TeamMemberImage) m_baseDao.queryForObject("teamMemberImage.findById", id);
	}

	public int insert(TeamMemberImage teamMemberImage) {
		return (Integer) m_baseDao.insert("teamMemberImage.insert", teamMemberImage);
	}

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	public int update(TeamMemberImage teamMemberImage) {
		return m_baseDao.update("teamMemberImage.update", teamMemberImage);
	}
}
