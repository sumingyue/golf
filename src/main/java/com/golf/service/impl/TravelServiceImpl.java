package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.TravelDao;
import com.golf.entity.Travel;
import com.golf.service.TravelService;

public class TravelServiceImpl implements InitializingBean, TravelService {

	private TravelDao m_travelDao;

	private Map<Integer, Travel> m_travels = new LinkedHashMap<Integer, Travel>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<Travel> categories = m_travelDao.findAllTravel();

		for (Travel travel : categories) {
			m_travels.put(travel.getId(), travel);
		}
	}

	@Override
	public int deleteTravel(int travelId) {
		int id = m_travelDao.delete(travelId);
		if (id > 0) {
			m_travels.remove(travelId);
		}
		return id;
	}

	@Override
	public Travel findTravel(int travelId) {
		Travel travel = m_travels.get(travelId);
		if (travel == null) {
			travel = m_travelDao.findById(travelId);
			if (travel != null) {
				m_travels.put(travelId, travel);
			}
		}
		return travel;
	}

	@Override
	public int insertTravel(Travel travel) {
		int id = m_travelDao.insert(travel);
		if (id > 0) {
			m_travels.put(travel.getId(), travel);
		}
		return id;
	}

	@Override
	public List<Travel> queryAllTravels() {
		ArrayList<Travel> arrayList = new ArrayList<Travel>(m_travels.values());
		Collections.sort(arrayList, new TravelCompartor());
		return arrayList;
	}

	public void setTravelDao(TravelDao travelDao) {
		m_travelDao = travelDao;
	}

	@Override
	public int updateTravel(Travel travel) {
		int id = m_travelDao.update(travel);
		if (id > 0) {
			m_travels.put(travel.getId(), travel);
		}
		return id;
	}

	public static class TravelCompartor implements Comparator<Travel> {

		@Override
		public int compare(Travel o1, Travel o2) {
			return o2.getId() - o1.getId();
		}
	}

}
