package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.TravelHotelImageDao;
import com.golf.entity.TravelHotelImage;
import com.golf.service.TravelHotelImageService;
import com.golf.tools.PagedTool;

public class TravelHotelImageServiceImpl implements InitializingBean, TravelHotelImageService {

	private TravelHotelImageDao m_travelHotelImageDao;

	private Map<Integer, TravelHotelImage> m_travelHotelImages = new LinkedHashMap<Integer, TravelHotelImage>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<TravelHotelImage> categories = m_travelHotelImageDao.findAllTravelHotelImage();

		for (TravelHotelImage travelHotelImage : categories) {
			m_travelHotelImages.put(travelHotelImage.getId(), travelHotelImage);
		}
	}

	@Override
	public int deleteTravelHotelImage(int travelHotelImageId) {
		int id = m_travelHotelImageDao.delete(travelHotelImageId);
		if (id > 0) {
			m_travelHotelImages.remove(travelHotelImageId);
		}
		return id;
	}

	@Override
	public TravelHotelImage findTravelHotelImage(int travelHotelImageId) {
		TravelHotelImage travelHotelImage = m_travelHotelImages.get(travelHotelImageId);
		if (travelHotelImage == null) {
			TravelHotelImage temp = m_travelHotelImageDao.findById(travelHotelImageId);
			if (temp != null) {
				m_travelHotelImages.put(travelHotelImageId, temp);
			}
			return temp;
		}
		return travelHotelImage;
	}

	@Override
	public int insertTravelHotelImage(TravelHotelImage travelHotelImage) {
		int id = m_travelHotelImageDao.insert(travelHotelImage);
		if (id > 0) {
			m_travelHotelImages.put(travelHotelImage.getId(), travelHotelImage);
		}
		return id;
	}

	@Override
	public List<TravelHotelImage> queryAllTravelHotelImages(int travelHotelId) {
		ArrayList<TravelHotelImage> arrayList = new ArrayList<TravelHotelImage>(m_travelHotelImages.values());
		List<TravelHotelImage> result = new ArrayList<TravelHotelImage>();

		for (TravelHotelImage temp : arrayList) {
			if (temp.getTravelHotelId() == travelHotelId || travelHotelId == 0) {
				result.add(temp);
			}
		}
		Collections.sort(result, new TravelHotelImageCompartor());
		return result;
	}

	@Override
   public List<TravelHotelImage> queryPagedTravelHotelImages(PagedTool pagedTool, int travelHotelId) {
		List<TravelHotelImage> result = queryAllTravelHotelImages(travelHotelId);
		return result.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());
   }

	public void setTravelHotelImageDao(TravelHotelImageDao travelHotelImageDao) {
		m_travelHotelImageDao = travelHotelImageDao;
	}

	@Override
	public int updateTravelHotelImage(TravelHotelImage travelHotelImage) {
		int id = m_travelHotelImageDao.update(travelHotelImage);
		if (id > 0) {
			m_travelHotelImages.put(travelHotelImage.getId(), travelHotelImage);
		}
		return id;
	}

	public static class TravelHotelImageCompartor implements Comparator<TravelHotelImage> {

		@Override
		public int compare(TravelHotelImage o1, TravelHotelImage o2) {
			return o2.getId()-o1.getId();
		}

	}

}
