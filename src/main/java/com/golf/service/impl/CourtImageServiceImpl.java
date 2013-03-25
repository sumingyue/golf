package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.CourtImageDao;
import com.golf.entity.CourtImage;
import com.golf.service.CourtImageService;
import com.golf.tools.PagedTool;

public class CourtImageServiceImpl implements InitializingBean, CourtImageService {

	private CourtImageDao m_courtImageDao;

	private Map<Integer, CourtImage> m_courtImages = new LinkedHashMap<Integer, CourtImage>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<CourtImage> categories = m_courtImageDao.findAllCourtImage();

		for (CourtImage courtImage : categories) {
			m_courtImages.put(courtImage.getId(), courtImage);
		}
	}

	@Override
	public int deleteCourtImage(int courtImageId) {
		int id = m_courtImageDao.delete(courtImageId);
		if (id > 0) {
			m_courtImages.remove(courtImageId);
		}
		return id;
	}

	@Override
	public CourtImage findCourtImage(int courtImageId) {
		CourtImage courtImage = m_courtImages.get(courtImageId);
		if (courtImage == null) {
			CourtImage temp = m_courtImageDao.findById(courtImageId);
			if (temp != null) {
				m_courtImages.put(courtImageId, temp);
			}
			return temp;
		}
		return courtImage;
	}

	@Override
	public int insertCourtImage(CourtImage courtImage) {
		int id = m_courtImageDao.insert(courtImage);
		if (id > 0) {
			m_courtImages.put(courtImage.getId(), courtImage);
		}
		return id;
	}

	@Override
	public List<CourtImage> queryAllCourtImages(int courtId) {
		ArrayList<CourtImage> arrayList = new ArrayList<CourtImage>(m_courtImages.values());
		List<CourtImage> result = new ArrayList<CourtImage>();

		for (CourtImage temp : arrayList) {
			if (temp.getCourtId() == courtId || courtId == 0) {
				result.add(temp);
			}
		}
		Collections.sort(result, new CourtImageCompartor());
		return result;
	}

	@Override
   public List<CourtImage> queryPagedCourtImages(PagedTool pagedTool, int courtId) {
		List<CourtImage> result = queryAllCourtImages(courtId);
		return result.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());
   }

	public void setCourtImageDao(CourtImageDao courtImageDao) {
		m_courtImageDao = courtImageDao;
	}

	@Override
	public int updateCourtImage(CourtImage courtImage) {
		int id = m_courtImageDao.update(courtImage);
		if (id > 0) {
			m_courtImages.put(courtImage.getId(), courtImage);
		}
		return id;
	}

	public static class CourtImageCompartor implements Comparator<CourtImage> {

		@Override
		public int compare(CourtImage o1, CourtImage o2) {
			return o2.getId()-o1.getId();
		}

	}

}
