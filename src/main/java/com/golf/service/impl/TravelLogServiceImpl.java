package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.TravelLogDao;
import com.golf.entity.TravelLog;
import com.golf.service.TravelLogService;

public class TravelLogServiceImpl implements InitializingBean, TravelLogService {

	private TravelLogDao m_travelLogDao;

	private Map<Integer, TravelLog> m_travelLogs = new LinkedHashMap<Integer, TravelLog>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<TravelLog> categories = m_travelLogDao.findAllTravelLog();

		for (TravelLog travelLog : categories) {
			m_travelLogs.put(travelLog.getId(), travelLog);
		}
	}

	@Override
	public int deleteTravelLog(int travelLogId) {
		int id = m_travelLogDao.delete(travelLogId);
		if (id > 0) {
			m_travelLogs.remove(travelLogId);
		}
		return id;
	}

	@Override
	public TravelLog findTravelLog(int travelLogId) {
		TravelLog travelLog = m_travelLogs.get(travelLogId);
		if (travelLog == null) {
			TravelLog temp = m_travelLogDao.findById(travelLogId);
			if (temp != null) {
				m_travelLogs.put(travelLogId, temp);
			}
			return temp;
		}
		return travelLog;
	}

	@Override
	public int insertTravelLog(TravelLog travelLog) {
		int id = m_travelLogDao.insert(travelLog);
		if (id > 0) {
			m_travelLogs.put(travelLog.getId(), travelLog);
		}
		return id;
	}

	@Override
	public List<TravelLog> queryAllTravelLogs() {
		ArrayList<TravelLog> arrayList = new ArrayList<TravelLog>(m_travelLogs.values());

		Collections.sort(arrayList, new TravelLogCompartor());
		return arrayList;
	}

	@Override
	public List<TravelLog> queryFixedTravelLogs(int size) {
		List<TravelLog> all = queryAllTravelLogs();
		return resizeList(all, size);
	}


	@Override
	public List<TravelLog> queryTravelLogByTravelId(int travelId) {
		List<TravelLog> all = queryAllTravelLogs();
		List<TravelLog> result = queryAllTravelLogs();

		for (TravelLog temp : all) {
			if (temp.getTravelId() == travelId) {
				result.add(temp);
			}
		}
		return result;
	}

	private List<TravelLog> resizeList(List<TravelLog> all, int size) {
		int totalSize = all.size();
		if (size > totalSize) {
			int duration = size - totalSize;
			for (int i = 0; i < duration; i++) {
				all.add(findTravelLog(1));
			}
		} else {
			all = all.subList(0, size);
		}
		return all;
	}

	public void setTravelLogDao(TravelLogDao travelLogDao) {
		m_travelLogDao = travelLogDao;
	}

	@Override
	public int updateTravelLog(TravelLog travelLog) {
		int id = m_travelLogDao.update(travelLog);
		if (id > 0) {
			m_travelLogs.put(travelLog.getId(), travelLog);
		}
		return id;
	}

	public static class TravelLogCompartor implements Comparator<TravelLog> {

		@Override
		public int compare(TravelLog o1, TravelLog o2) {
			return o2.getId() - o1.getId();
		}
	}
}
