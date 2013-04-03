package com.golf.dao;

import java.util.List;

import com.golf.entity.ImageSpecialDetail;

public class ImageSpecialDetailDao {

	private BaseDao m_baseDao;

	public int delete(int id) {
		return (Integer) m_baseDao.delete("imageSpecialDetail.delete", id);
	}

	@SuppressWarnings("rawtypes")
   public List findAllImageSpecialDetail() {
		return m_baseDao.queryForList("imageSpecialDetail.findAll");
	}

	public ImageSpecialDetail findById(int id) {
		return (ImageSpecialDetail) m_baseDao.queryForObject("imageSpecialDetail.findById", id);
	}

	public int insert(ImageSpecialDetail imageSpecialDetail) {
		return (Integer) m_baseDao.insert("imageSpecialDetail.insert", imageSpecialDetail);
	}

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	public int update(ImageSpecialDetail imageSpecialDetail) {
		return m_baseDao.update("imageSpecialDetail.update", imageSpecialDetail);
	}
}
