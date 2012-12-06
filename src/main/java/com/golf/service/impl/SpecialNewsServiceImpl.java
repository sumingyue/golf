package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.SpecialNewsDao;
import com.golf.entity.SpecialNews;
import com.golf.service.SpecialNewsService;
import com.golf.tools.PagedTool;

public class SpecialNewsServiceImpl implements InitializingBean, SpecialNewsService {

	private SpecialNewsDao m_specialNewsDao;

	private Map<Integer, SpecialNews> m_specialNewss = new LinkedHashMap<Integer, SpecialNews>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<SpecialNews> categories = m_specialNewsDao.findAllSpecialNews();

		for (SpecialNews specialNews : categories) {
			m_specialNewss.put(specialNews.getId(), specialNews);
		}
	}

	@Override
	public List<SpecialNews> queryAllSpecialNewss() {
		ArrayList<SpecialNews> arrayList = new ArrayList<SpecialNews>(m_specialNewss.values());
		Collections.sort(arrayList, new SpecialNewsCompartor());
		return arrayList;
	}

	@Override
	public int insertSpecialNews(SpecialNews specialNews) {
		int id = m_specialNewsDao.insert(specialNews);
		if (id > 0) {
			m_specialNewss.put(specialNews.getId(), specialNews);
		}
		return id;
	}

	@Override
	public int updateSpecialNews(SpecialNews specialNews) {
		int id = m_specialNewsDao.update(specialNews);
		if (id > 0) {
			m_specialNewss.put(specialNews.getId(), specialNews);
		}
		return id;
	}

	@Override
	public int deleteSpecialNews(int specialNewsId) {
		int id = m_specialNewsDao.delete(specialNewsId);
		if (id > 0) {
			m_specialNewss.remove(specialNewsId);
		}
		return id;
	}

	@Override
	public SpecialNews findSpecialNews(int specialNewsId) {
		SpecialNews specialNews = m_specialNewss.get(specialNewsId);
		if (specialNews == null) {
			specialNews = m_specialNewsDao.findById(specialNewsId);
			if (specialNews != null) {
				m_specialNewss.put(specialNewsId, specialNews);
			}
		}
		return specialNews;
	}

	public void setSpecialNewsDao(SpecialNewsDao specialNewsDao) {
		m_specialNewsDao = specialNewsDao;
	}

	public static class SpecialNewsCompartor implements Comparator<SpecialNews> {

		@Override
		public int compare(SpecialNews o1, SpecialNews o2) {
			return o2.getId() - o1.getId();
		}

	}

	@Override
	public List<SpecialNews> queryPagedSpecialNewss(PagedTool pagedTool) {
		List<SpecialNews> result = queryAllSpecialNewss();
		return result.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());

	}

	private List<SpecialNews> resizeList(List<SpecialNews> all, int size) {
		int totalSize = all.size();
		if (size > totalSize) {
			int duration = size - totalSize;
			for (int i = 0; i < duration; i++) {
				all.add(findSpecialNews(1));
			}
		} else {
			all = all.subList(0, size);
		}
		return all;
	}

	@Override
	public List<SpecialNews> queryLastestSpecialNews(int size) {
		List<SpecialNews> all = queryAllSpecialNewss();
		resizeList(all, size);
		return all;
	}

}
