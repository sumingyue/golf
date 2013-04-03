package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.TravelPlanDao;
import com.golf.entity.TravelPlan;
import com.golf.service.TravelPlanService;
import com.golf.tools.PagedTool;

public class TravelPlanServiceImpl implements InitializingBean, TravelPlanService {

	private TravelPlanDao m_travelPlanDao;

	private Map<Integer, TravelPlan> m_travelPlans = new LinkedHashMap<Integer, TravelPlan>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<TravelPlan> categories = m_travelPlanDao.findAllTravelPlan();

		for (TravelPlan travelPlan : categories) {
			m_travelPlans.put(travelPlan.getId(), travelPlan);
		}
	}

	@Override
	public int deleteTravelPlan(int travelPlanId) {
		int id = m_travelPlanDao.delete(travelPlanId);
		if (id > 0) {
			m_travelPlans.remove(travelPlanId);
		}
		return id;
	}

	@Override
	public TravelPlan findTravelPlan(int travelPlanId) {
		TravelPlan travelPlan = m_travelPlans.get(travelPlanId);
		if (travelPlan == null) {
			TravelPlan temp = m_travelPlanDao.findById(travelPlanId);
			if (temp != null) {
				m_travelPlans.put(travelPlanId, temp);
			}
			return temp;
		}
		return travelPlan;
	}

	@Override
	public int insertTravelPlan(TravelPlan travelPlan) {
		int id = m_travelPlanDao.insert(travelPlan);
		if (id > 0) {
			m_travelPlans.put(travelPlan.getId(), travelPlan);
		}
		return id;
	}

	@Override
	public List<TravelPlan> queryAllTravelPlans(int traveId) {
		ArrayList<TravelPlan> arrayList = new ArrayList<TravelPlan>(m_travelPlans.values());
		List<TravelPlan> result = new ArrayList<TravelPlan>();

		for (TravelPlan temp : arrayList) {
			if (temp.getTravelId() == traveId || traveId == 0) {
				result.add(temp);
			}
		}
		Collections.sort(result, new TravelPlanAscCompartor());
		return result;
	}

	@Override
   public List<TravelPlan> queryPagedTravelPlans(PagedTool pagedTool, int travelHotelId) {
		List<TravelPlan> result = queryAllTravelPlans(travelHotelId);
		return result.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());
   }

	public void setTravelPlanDao(TravelPlanDao travelPlanDao) {
		m_travelPlanDao = travelPlanDao;
	}

	@Override
	public int updateTravelPlan(TravelPlan travelPlan) {
		int id = m_travelPlanDao.update(travelPlan);
		if (id > 0) {
			m_travelPlans.put(travelPlan.getId(), travelPlan);
		}
		return id;
	}

	public static class TravelPlanCompartor implements Comparator<TravelPlan> {

		@Override
		public int compare(TravelPlan o1, TravelPlan o2) {
			return o2.getId()-o1.getId();
		}

	}
	public static class TravelPlanAscCompartor implements Comparator<TravelPlan> {

		@Override
		public int compare(TravelPlan o1, TravelPlan o2) {
			return o1.getId()-o2.getId();
		}
	}

}
