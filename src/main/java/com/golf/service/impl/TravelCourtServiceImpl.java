package com.golf.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.golf.dao.TravelCourtDao;
import com.golf.entity.TravelCourt;
import com.golf.service.TravelCourtService;

public class TravelCourtServiceImpl implements TravelCourtService {

	private TravelCourtDao m_travelCourtDao;

	private Map<Integer, TravelCourt> m_travelCourts = new LinkedHashMap<Integer, TravelCourt>();

	@Override
	public int deleteTravelCourt(int travelCourtId) {
		int id = m_travelCourtDao.delete(travelCourtId);
		if (id > 0) {
			m_travelCourts.remove(travelCourtId);
		}
		return id;
	}

	@Override
	public TravelCourt findTravelCourt(int travelCourtId) {
		TravelCourt travelCourt = m_travelCourts.get(travelCourtId);
		if (travelCourt == null) {
			travelCourt = m_travelCourtDao.findById(travelCourtId);
			if (travelCourt != null) {
				m_travelCourts.put(travelCourtId, travelCourt);
			}
		}
		return travelCourt;
	}

	@Override
	public int insertTravelCourt(TravelCourt travelCourt) {
		int id = m_travelCourtDao.insert(travelCourt);
		if (id > 0) {
			m_travelCourts.put(travelCourt.getId(), travelCourt);
		}
		return id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TravelCourt> queryAllTravelCourts() {
		return m_travelCourtDao.findAllTravelCourt();
	}

	public void setTravelCourtDao(TravelCourtDao travelCourtDao) {
		m_travelCourtDao = travelCourtDao;
	}

	@Override
	public int updateTravelCourt(TravelCourt travelCourt) {
		int id = m_travelCourtDao.update(travelCourt);
		if (id > 0) {
			m_travelCourts.put(travelCourt.getId(), travelCourt);
		}
		return id;
	}

	@Override
	public int deleteByTravelId(int travelId) {
		return m_travelCourtDao.deleteByTravelId(travelId);
	}

	@SuppressWarnings("unchecked")
   @Override
   public List<TravelCourt> queryAllByTravelId(int travelId) {
	   return m_travelCourtDao.queryAllByTravelId(travelId);
   }

}
