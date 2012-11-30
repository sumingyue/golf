package com.golf.dao;

import java.util.List;

import com.golf.entity.Image;

public class ImageDao {

	private BaseDao m_baseDao;

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	@SuppressWarnings("rawtypes")
   public List findAllImage() {
		return m_baseDao.queryForList("image.findAll");
	}

	public Image findById(int id) {
		return (Image) m_baseDao.queryForObject("image.findById", id);
	}

	public int insert(Image image) {
		return (Integer) m_baseDao.insert("image.insert", image);
	}

	public int update(Image image) {
		return m_baseDao.update("image.update", image);
	}

	public int delete(int id) {
		return (Integer) m_baseDao.delete("image.delete", id);
	}
}
