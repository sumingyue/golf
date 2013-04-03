package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.TravelHotelDao;
import com.golf.entity.TravelHotel;
import com.golf.service.TravelHotelService;

public class TravelHotelServiceImpl implements InitializingBean, TravelHotelService {

	private TravelHotelDao m_travelHotelDao;

	private Map<Integer, TravelHotel> m_travelHotels = new LinkedHashMap<Integer, TravelHotel>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<TravelHotel> categories = m_travelHotelDao.findAllTravelHotel();

		for (TravelHotel travelHotel : categories) {
			m_travelHotels.put(travelHotel.getId(), travelHotel);
		}
	}

	@Override
	public int deleteTravelHotel(int travelHotelId) {
		int id = m_travelHotelDao.delete(travelHotelId);
		if (id > 0) {
			m_travelHotels.remove(travelHotelId);
		}
		return id;
	}

	@Override
	public TravelHotel findTravelHotel(int travelHotelId) {
		TravelHotel travelHotel = m_travelHotels.get(travelHotelId);
		if (travelHotel == null) {
			travelHotel = m_travelHotelDao.findById(travelHotelId);
			if (travelHotel != null) {
				m_travelHotels.put(travelHotelId, travelHotel);
			}
		}
		return travelHotel;
	}

	@Override
	public int insertTravelHotel(TravelHotel travelHotel) {
		int id = m_travelHotelDao.insert(travelHotel);
		if (id > 0) {
			m_travelHotels.put(travelHotel.getId(), travelHotel);
		}
		return id;
	}

	@Override
	public List<TravelHotel> queryAllTravelHotels() {
		ArrayList<TravelHotel> arrayList = new ArrayList<TravelHotel>(m_travelHotels.values());
		Collections.sort(arrayList, new TravelHotelCompartor());
		return arrayList;
	}

	public void setTravelHotelDao(TravelHotelDao travelHotelDao) {
		m_travelHotelDao = travelHotelDao;
	}

	@Override
	public int updateTravelHotel(TravelHotel travelHotel) {
		int id = m_travelHotelDao.update(travelHotel);
		if (id > 0) {
			m_travelHotels.put(travelHotel.getId(), travelHotel);
		}
		return id;
	}

	public static class TravelHotelCompartor implements Comparator<TravelHotel> {

		@Override
		public int compare(TravelHotel o1, TravelHotel o2) {
			return o2.getId() - o1.getId();
		}
	}

}
