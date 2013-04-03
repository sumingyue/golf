package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.DrivingRangeDao;
import com.golf.entity.DrivingRange;
import com.golf.service.DrivingRangeService;

public class DrivingRangeServiceImpl implements InitializingBean, DrivingRangeService {

	private DrivingRangeDao m_drivingRangeDao;

	private Map<Integer, DrivingRange> m_drivingRanges = new LinkedHashMap<Integer, DrivingRange>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<DrivingRange> categories = m_drivingRangeDao.findAllDrivingRange();

		for (DrivingRange drivingRange : categories) {
			m_drivingRanges.put(drivingRange.getId(), drivingRange);
		}
	}

	@Override
	public int deleteDrivingRange(int drivingRangeId) {
		int id = m_drivingRangeDao.delete(drivingRangeId);
		if (id > 0) {
			m_drivingRanges.remove(drivingRangeId);
		}
		return id;
	}

	@Override
	public DrivingRange findDrivingRange(int drivingRangeId) {
		DrivingRange drivingRange = m_drivingRanges.get(drivingRangeId);
		if (drivingRange == null) {
			drivingRange = m_drivingRangeDao.findById(drivingRangeId);
			if (drivingRange != null) {
				m_drivingRanges.put(drivingRangeId, drivingRange);
			}
		}
		return drivingRange;
	}

	@Override
	public int insertDrivingRange(DrivingRange drivingRange) {
		int id = m_drivingRangeDao.insert(drivingRange);
		if (id > 0) {
			m_drivingRanges.put(drivingRange.getId(), drivingRange);
		}
		return id;
	}

	@Override
	public List<DrivingRange> queryAllDrivingRanges() {
		ArrayList<DrivingRange> arrayList = new ArrayList<DrivingRange>(m_drivingRanges.values());
		Collections.sort(arrayList, new DrivingRangeCompartor());
		return arrayList;
	}

	public void setDrivingRangeDao(DrivingRangeDao drivingRangeDao) {
		m_drivingRangeDao = drivingRangeDao;
	}

	@Override
	public int updateDrivingRange(DrivingRange drivingRange) {
		int id = m_drivingRangeDao.update(drivingRange);
		if (id > 0) {
			m_drivingRanges.put(drivingRange.getId(), drivingRange);
		}
		return id;
	}

	public static class DrivingRangeCompartor implements Comparator<DrivingRange> {

		@Override
		public int compare(DrivingRange o1, DrivingRange o2) {
			return o2.getId() - o1.getId();
		}
	}

}
