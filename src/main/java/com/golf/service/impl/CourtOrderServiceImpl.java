package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.CourtOrderDao;
import com.golf.entity.CourtOrder;
import com.golf.service.CourtOrderService;
import com.golf.tools.PagedTool;

public class CourtOrderServiceImpl implements InitializingBean, CourtOrderService {

	private CourtOrderDao m_courtOrderDao;

	private Map<Integer, CourtOrder> m_courtOrders = new LinkedHashMap<Integer, CourtOrder>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<CourtOrder> categories = m_courtOrderDao.findAllCourtOrder();

		for (CourtOrder courtOrder : categories) {
			m_courtOrders.put(courtOrder.getId(), courtOrder);
		}
	}

	@Override
	public int deleteCourtOrder(int courtOrderId) {
		int id = m_courtOrderDao.delete(courtOrderId);
		if (id > 0) {
			m_courtOrders.remove(courtOrderId);
		}
		return id;
	}

	@Override
	public CourtOrder findCourtOrder(int courtOrderId) {
		CourtOrder courtOrder = m_courtOrders.get(courtOrderId);
		if (courtOrder == null) {
			CourtOrder temp = m_courtOrderDao.findById(courtOrderId);
			if (temp != null) {
				m_courtOrders.put(courtOrderId, temp);
			}
			return temp;
		}
		return courtOrder;
	}

	@Override
	public int insertCourtOrder(CourtOrder courtOrder) {
		int id = m_courtOrderDao.insert(courtOrder);
		if (id > 0) {
			m_courtOrders.put(courtOrder.getId(), courtOrder);
		}
		return id;
	}

	@Override
	public List<CourtOrder> queryAllCourtOrders() {
		ArrayList<CourtOrder> arrayList = new ArrayList<CourtOrder>(m_courtOrders.values());
		
		Collections.sort(arrayList,new CourtOrderCompartor());
		return arrayList;
	}

	@Override
   public List<CourtOrder> queryPagedCourtOrders(PagedTool pagedTool) {
		List<CourtOrder> result = queryAllCourtOrders();
		return result.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());

   }

	public void setCourtOrderDao(CourtOrderDao courtOrderDao) {
		m_courtOrderDao = courtOrderDao;
	}

	@Override
	public int updateCourtOrder(CourtOrder courtOrder) {
		int id = m_courtOrderDao.update(courtOrder);
		if (id > 0) {
			m_courtOrders.put(courtOrder.getId(), courtOrder);
		}
		return id;
	}

	public static class CourtOrderCompartor implements Comparator<CourtOrder> {

		@Override
		public int compare(CourtOrder o1, CourtOrder o2) {
			return o2.getId()-o1.getId();
		}

	}
}
