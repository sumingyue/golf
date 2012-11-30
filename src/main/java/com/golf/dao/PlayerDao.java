package com.golf.dao;

import java.util.List;

import com.golf.entity.Player;

public class PlayerDao {

	private BaseDao m_baseDao;

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	@SuppressWarnings("rawtypes")
   public List findAllPlayer() {
		return m_baseDao.queryForList("player.findAll");
	}

	public Player findById(int id) {
		return (Player) m_baseDao.queryForObject("player.findById", id);
	}

	public int insert(Player player) {
		return (Integer) m_baseDao.insert("player.insert", player);
	}

	public int update(Player player) {
		return m_baseDao.update("player.update", player);
	}

	public int delete(int id) {
		return (Integer) m_baseDao.delete("player.delete", id);
	}
}
