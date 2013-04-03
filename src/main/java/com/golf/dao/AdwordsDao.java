package com.golf.dao;

import java.util.List;

import com.golf.entity.Adwords;

public class AdwordsDao {

	private BaseDao m_baseDao;

	public int delete(int id) {
		return (Integer) m_baseDao.delete("adwords.delete", id);
	}

	@SuppressWarnings("rawtypes")
   public List findAllAdwords() {
		return m_baseDao.queryForList("adwords.findAll");
	}

	public Adwords findById(int id) {
		return (Adwords) m_baseDao.queryForObject("adwords.findById", id);
	}

	public int insert(Adwords adwords) {
		return (Integer) m_baseDao.insert("adwords.insert", adwords);
	}

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	public int update(Adwords adwords) {
		return m_baseDao.update("adwords.update", adwords);
	}
}
