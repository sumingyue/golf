package com.golf.dao;

import java.util.List;

import com.golf.entity.News;

public class NewsDao {

	private BaseDao m_baseDao;

	public int delete(int id) {
		return (Integer) m_baseDao.delete("news.delete", id);
	}

	@SuppressWarnings("rawtypes")
	public List findAllNews() {
		return m_baseDao.queryForList("news.findAll");
	}

	public News findById(int id) {
		return (News) m_baseDao.queryForObject("news.findById", id);
	}

	public int insert(News news) {
		return (Integer) m_baseDao.insert("news.insert", news);
	}

	public void setBaseDao(BaseDao baseDao) {
		m_baseDao = baseDao;
	}

	public int update(int id, int type) {
		if(type==News.TYPE_VIEW){
			return (Integer) m_baseDao.update("news.increaseViewNumber");
		}else if(type==News.TYPE_GOOD){
			return (Integer) m_baseDao.update("news.increaseGood");
		}else if(type==News.TYPE_BAD){
			return (Integer) m_baseDao.update("news.increaseBad");
		}
	   return 0;
   }

	public int update(News news) {
		return m_baseDao.update("news.update", news);
	}
}
