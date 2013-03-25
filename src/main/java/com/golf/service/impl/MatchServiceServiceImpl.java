package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.MatchServiceDao;
import com.golf.entity.MatchService;
import com.golf.service.MatchServiceService;
import com.golf.tools.PagedTool;

public class MatchServiceServiceImpl implements InitializingBean, MatchServiceService {

	private MatchServiceDao m_matchServiceDao;

	private Map<Integer, MatchService> m_matchServices = new LinkedHashMap<Integer, MatchService>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<MatchService> categories = m_matchServiceDao.findAllMatchService();

		for (MatchService matchService : categories) {
			m_matchServices.put(matchService.getId(), matchService);
		}
	}

	@Override
	public int deleteMatchService(int matchServiceId) {
		int id = m_matchServiceDao.delete(matchServiceId);
		if (id > 0) {
			m_matchServices.remove(matchServiceId);
		}
		return id;
	}

	@Override
	public MatchService findMatchService(int matchServiceId) {
		MatchService matchService = m_matchServices.get(matchServiceId);
		if (matchService == null) {
			 matchService = m_matchServiceDao.findById(matchServiceId);
			if (matchService != null) {
				m_matchServices.put(matchServiceId, matchService);
			}
		}
		return matchService;
	}

	@Override
	public int insertMatchService(MatchService matchService) {
		int id = m_matchServiceDao.insert(matchService);
		if (id > 0) {
			m_matchServices.put(matchService.getId(), matchService);
		}
		return id;
	}

	@Override
	public List<MatchService> queryAllMatchServices() {
		ArrayList<MatchService> arrayList = new ArrayList<MatchService>(m_matchServices.values());
		Collections.sort(arrayList, new MatchServiceCompartor());
		return arrayList;
	}

	@Override
   public List<MatchService> queryPagedMatchServices(PagedTool pagedTool) {
		List<MatchService> result = queryAllMatchServices();
		return result.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());

   }

	public void setMatchServiceDao(MatchServiceDao matchServiceDao) {
		m_matchServiceDao = matchServiceDao;
	}

	@Override
	public int updateMatchService(MatchService matchService) {
		int id = m_matchServiceDao.update(matchService);
		if (id > 0) {
			m_matchServices.put(matchService.getId(), matchService);
		}
		return id;
	}

	public static class MatchServiceCompartor implements Comparator<MatchService> {

		@Override
		public int compare(MatchService o1, MatchService o2) {
			return o2.getId()-o1.getId();
		}

	}

}
