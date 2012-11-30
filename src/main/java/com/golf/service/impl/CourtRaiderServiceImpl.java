package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.CourtRaiderDao;
import com.golf.entity.CourtRaider;
import com.golf.service.CourtRaiderService;
import com.golf.tools.PagedTool;

public class CourtRaiderServiceImpl implements InitializingBean, CourtRaiderService {

	private CourtRaiderDao m_courtRaiderDao;

	private Map<Integer, CourtRaider> m_courtRaiders = new LinkedHashMap<Integer, CourtRaider>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<CourtRaider> categories = m_courtRaiderDao.findAllCourtRaider();

		for (CourtRaider courtRaider : categories) {
			m_courtRaiders.put(courtRaider.getId(), courtRaider);
		}
	}

	@Override
	public List<CourtRaider> queryAllCourtRaiders(int courtId) {
		ArrayList<CourtRaider> arrayList = new ArrayList<CourtRaider>(m_courtRaiders.values());
		List<CourtRaider> result = new ArrayList<CourtRaider>();
		
		for (CourtRaider temp : arrayList) {
			if (temp.getCourtId() == courtId || courtId == 0) {
				result.add(temp);
			}
		}
		Collections.sort(result, new CourtRaiderCompartor());
		return result;
	}

	@Override
	public int insertCourtRaider(CourtRaider courtRaider) {
		int id = m_courtRaiderDao.insert(courtRaider);
		if (id > 0) {
			m_courtRaiders.put(courtRaider.getId(), courtRaider);
		}
		return id;
	}

	@Override
	public int updateCourtRaider(CourtRaider courtRaider) {
		int id = m_courtRaiderDao.update(courtRaider);
		if (id > 0) {
			m_courtRaiders.put(courtRaider.getId(), courtRaider);
		}
		return id;
	}

	@Override
	public int deleteCourtRaider(int courtRaiderId) {
		int id = m_courtRaiderDao.delete(courtRaiderId);
		if (id > 0) {
			m_courtRaiders.remove(courtRaiderId);
		}
		return id;
	}

	@Override
	public CourtRaider findCourtRaider(int courtRaiderId) {
		CourtRaider courtRaider = m_courtRaiders.get(courtRaiderId);
		if (courtRaider == null) {
			courtRaider = m_courtRaiderDao.findById(courtRaiderId);
			if (courtRaider != null) {
				m_courtRaiders.put(courtRaiderId, courtRaider);
			}
		}
		return courtRaider;
	}

	public void setCourtRaiderDao(CourtRaiderDao courtRaiderDao) {
		m_courtRaiderDao = courtRaiderDao;
	}

	public static class CourtRaiderCompartor implements Comparator<CourtRaider> {

		@Override
		public int compare(CourtRaider o1, CourtRaider o2) {
			return o2.getId()-o1.getId();
		}

	}

	@Override
   public List<CourtRaider> queryPagedCourtRaiders(PagedTool pagedTool, int courtId) {
		List<CourtRaider> result = queryAllCourtRaiders(courtId);
		return result.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());
	}

}
