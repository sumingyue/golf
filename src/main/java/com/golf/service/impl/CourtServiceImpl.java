package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.Config;
import com.golf.dao.CourtDao;
import com.golf.entity.Court;
import com.golf.service.CourtService;
import com.golf.service.ImageService;
import com.golf.tools.PagedTool;

public class CourtServiceImpl implements InitializingBean, CourtService {

	private CourtDao m_courtDao;

	private Map<Integer, Court> m_courts = new LinkedHashMap<Integer, Court>();

	private ImageService m_imageService;

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<Court> all = m_courtDao.findAllCourt();

		for (Court court : all) {
			m_courts.put(court.getId(), court);
		}
		
		if (Config.DUBUG) {
			int size = all.size();
			if (size > 1) {
				Court temp = all.get(0);
				String name =temp.getName();
				int total = Config.DEBUG_TOTAL - size;
				if (total > 0) {
					for (int i = 0; i < total; i++) {
						temp.setName(name+i);
						m_courts.put(size + i, temp);
					}
				}
			}
		}
	}

	@Override
	public List<Court> queryAllCourts() {
		ArrayList<Court> arrayList = new ArrayList<Court>(m_courts.values());
		Collections.sort(arrayList, new CourtCompartor());
		return arrayList;
	}

	@Override
	public int insertCourt(Court court) {
		int id = m_courtDao.insert(court);
		if (id > 0) {
			m_courts.put(court.getId(), court);
		}
		return id;
	}

	@Override
	public int updateCourt(Court court) {
		int id = m_courtDao.update(court);
		if (id > 0) {
			m_courts.put(court.getId(), court);
		}
		return id;
	}

	@Override
	public int deleteCourt(int courtId) {
		int id = m_courtDao.delete(courtId);
		if (id > 0) {
			m_courts.remove(courtId);
		}
		return id;
	}

	@Override
	public Court findCourt(int courtId) {
		Court court = m_courts.get(courtId);
		if (court == null) {
			court = m_courtDao.findById(courtId);
			if (court != null) {
				m_courts.put(courtId, court);
			}
		}
		if (court != null) {
			court.setMapImage(m_imageService.findImage(court.getMapImageId()));
		}
		return court;
	}

	public void setCourtDao(CourtDao courtDao) {
		m_courtDao = courtDao;
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public static class CourtCompartor implements Comparator<Court> {

		@Override
		public int compare(Court o1, Court o2) {
			return o2.getId() - o1.getId();
		}

	}

	@Override
	public List<Court> queryPagedCourts(PagedTool tool) {
		List<Court> result = queryAllCourts();

		return result.subList(tool.getFromIndex(), tool.getToIndex());
	}

}
