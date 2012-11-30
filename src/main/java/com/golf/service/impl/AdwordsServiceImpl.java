package com.golf.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.AdwordsDao;
import com.golf.entity.Adwords;
import com.golf.service.AdwordsService;
import com.golf.tools.PagedTool;

public class AdwordsServiceImpl implements InitializingBean, AdwordsService {

	private AdwordsDao m_adwordsDao;

	private Map<Integer, Adwords> m_adwordss = new LinkedHashMap<Integer, Adwords>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<Adwords> all = m_adwordsDao.findAllAdwords();

		for (Adwords adwords : all) {
			m_adwordss.put(adwords.getId(), adwords);
		}
	}

	@Override
	public List<Adwords> queryAllAdwordss() {
		return new ArrayList<Adwords>(m_adwordss.values());
	}

	@Override
	public int insertAdwords(Adwords adwords) {
		int id = m_adwordsDao.insert(adwords);
		if (id > 0) {
			m_adwordss.put(adwords.getId(), adwords);
		}
		return id;
	}

	@Override
	public int updateAdwords(Adwords adwords) {
		int id = m_adwordsDao.update(adwords);
		if (id > 0) {
			m_adwordss.put(adwords.getId(), adwords);
		}
		return id;
	}

	@Override
	public int deleteAdwords(int adwordsId) {
		int id = m_adwordsDao.delete(adwordsId);
		if (id > 0) {
			m_adwordss.remove(adwordsId);
		}
		return id;
	}

	@Override
	public Adwords findAdwords(int adwordsId) {
		Adwords adwords = m_adwordss.get(adwordsId);
		if (adwords == null) {
			Adwords temp = m_adwordsDao.findById(adwordsId);
			if (temp != null) {
				m_adwordss.put(adwordsId, temp);
			}
			return temp;
		}
		return adwords;
	}

	public void setAdwordsDao(AdwordsDao adwordsDao) {
		m_adwordsDao = adwordsDao;
	}

	@Override
	public List<Adwords> queryPagedAdwordss(PagedTool tool) {
		List<Adwords> result = queryAllAdwordss();
		return result.subList(tool.getFromIndex(), tool.getToIndex());
	}

}
