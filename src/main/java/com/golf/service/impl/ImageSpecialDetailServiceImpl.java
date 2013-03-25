package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.ImageSpecialDetailDao;
import com.golf.entity.ImageSpecialDetail;
import com.golf.service.ImageSpecialDetailService;
import com.golf.tools.PagedTool;

public class ImageSpecialDetailServiceImpl implements InitializingBean, ImageSpecialDetailService {

	private ImageSpecialDetailDao m_imageSpecialDetailDao;

	private Map<Integer, ImageSpecialDetail> m_imageSpecialDetails = new LinkedHashMap<Integer, ImageSpecialDetail>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<ImageSpecialDetail> categories = m_imageSpecialDetailDao.findAllImageSpecialDetail();

		for (ImageSpecialDetail imageSpecialDetail : categories) {
			m_imageSpecialDetails.put(imageSpecialDetail.getId(), imageSpecialDetail);
		}
	}

	@Override
	public int deleteImageSpecialDetail(int imageSpecialDetailId) {
		int id = m_imageSpecialDetailDao.delete(imageSpecialDetailId);
		if (id > 0) {
			m_imageSpecialDetails.remove(imageSpecialDetailId);
		}
		return id;
	}

	@Override
	public ImageSpecialDetail findImageSpecialDetail(int imageSpecialDetailId) {
		ImageSpecialDetail imageSpecialDetail = m_imageSpecialDetails.get(imageSpecialDetailId);
		if (imageSpecialDetail == null) {
			ImageSpecialDetail temp = m_imageSpecialDetailDao.findById(imageSpecialDetailId);
			if (temp != null) {
				m_imageSpecialDetails.put(imageSpecialDetailId, temp);
			}
			return temp;
		}
		return imageSpecialDetail;
	}

	@Override
	public int insertImageSpecialDetail(ImageSpecialDetail imageSpecialDetail) {
		int id = m_imageSpecialDetailDao.insert(imageSpecialDetail);
		if (id > 0) {
			m_imageSpecialDetails.put(imageSpecialDetail.getId(), imageSpecialDetail);
		}
		return id;
	}

	@Override
	public List<ImageSpecialDetail> queryAllImageSpecialDetails(int specialImageId) {
		ArrayList<ImageSpecialDetail> arrayList = new ArrayList<ImageSpecialDetail>(m_imageSpecialDetails.values());
		List<ImageSpecialDetail> result = new ArrayList<ImageSpecialDetail>();

		for (ImageSpecialDetail temp : arrayList) {
			if (temp.getImageSpecialId() == specialImageId || specialImageId == 0) {
				result.add(temp);
			}
		}
		Collections.sort(result, new ImageSpecialDetailCompartor());
		return result;
	}

	@Override
   public List<ImageSpecialDetail> queryPagedImageSpecialDetails(PagedTool pagedTool, int imageSpecialId) {
		List<ImageSpecialDetail> all = queryAllImageSpecialDetails(imageSpecialId);

		return all.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());
   }

	public void setImageSpecialDetailDao(ImageSpecialDetailDao imageSpecialDetailDao) {
		m_imageSpecialDetailDao = imageSpecialDetailDao;
	}

	@Override
	public int updateImageSpecialDetail(ImageSpecialDetail imageSpecialDetail) {
		int id = m_imageSpecialDetailDao.update(imageSpecialDetail);
		if (id > 0) {
			m_imageSpecialDetails.put(imageSpecialDetail.getId(), imageSpecialDetail);
		}
		return id;
	}

	public static class ImageSpecialDetailCompartor implements Comparator<ImageSpecialDetail> {

		@Override
		public int compare(ImageSpecialDetail o1, ImageSpecialDetail o2) {
			return o2.getId()-o1.getId();
		}

	}
}
