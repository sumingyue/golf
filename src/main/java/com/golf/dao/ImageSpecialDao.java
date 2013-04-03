package com.golf.dao;

import java.util.List;

import com.golf.entity.ImageSpecial;

public class ImageSpecialDao {

	private BaseDao m_baseDao;

	public int delete(int id) {
		return (Integer) m_baseDao.delete("imageSpecial.delete", id);
	}

	@SuppressWarnings("rawtypes")
   public List findAllImageSpecial() {
		return m_baseDao.queryForList("imageSpecial.findAll");
	}

	public ImageSpecial findById(int id) {
		return (ImageSpecial) m_baseDao.queryForObject("imageSpecial.findById", id);
	}

	public int insert(ImageSpecial imageSpecial) {
		return (Integer) m_baseDao.insert("imageSpecial.insert", imageSpecial);
	}

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	public int update(ImageSpecial imageSpecial) {
		return m_baseDao.update("imageSpecial.update", imageSpecial);
	}
}
