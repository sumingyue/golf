package com.golf.dao;

import java.util.List;

import com.golf.entity.UserMessage;

public class UserMessageDao {

	private BaseDao m_baseDao;

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	@SuppressWarnings("rawtypes")
   public List findAllUserMessage() {
		return m_baseDao.queryForList("userMessage.findAll");
	}

	public UserMessage findById(int id) {
		return (UserMessage) m_baseDao.queryForObject("userMessage.findById", id);
	}

	public int insert(UserMessage userMessage) {
		return (Integer) m_baseDao.insert("userMessage.insert", userMessage);
	}

	public int update(UserMessage userMessage) {
		return m_baseDao.update("userMessage.update", userMessage);
	}

	public int delete(int id) {
		return (Integer) m_baseDao.delete("userMessage.delete", id);
	}
}
