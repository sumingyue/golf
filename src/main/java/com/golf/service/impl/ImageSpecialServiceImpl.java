package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.ImageSpecialDao;
import com.golf.entity.ImageSpecial;
import com.golf.service.ImageSpecialService;
import com.golf.tools.PagedTool;

public class ImageSpecialServiceImpl implements InitializingBean, ImageSpecialService {

	private ImageSpecialDao m_imageSpecialDao;

	private Map<Integer, ImageSpecial> m_imageSpecials = new LinkedHashMap<Integer, ImageSpecial>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<ImageSpecial> categories = m_imageSpecialDao.findAllImageSpecial();

		for (ImageSpecial imageSpecial : categories) {
			m_imageSpecials.put(imageSpecial.getId(), imageSpecial);
		}
	}

	@Override
	public List<ImageSpecial> queryAllImageSpecials() {
		ArrayList<ImageSpecial> arrayList = new ArrayList<ImageSpecial>(m_imageSpecials.values());
		Collections.sort(arrayList, new ImageSpecialCompartor());
		return arrayList;
	}

	@Override
	public int insertImageSpecial(ImageSpecial imageSpecial) {
		int id = m_imageSpecialDao.insert(imageSpecial);
		if (id > 0) {
			m_imageSpecials.put(imageSpecial.getId(), imageSpecial);
		}
		return id;
	}

	@Override
	public int updateImageSpecial(ImageSpecial imageSpecial) {
		int id = m_imageSpecialDao.update(imageSpecial);
		if (id > 0) {
			m_imageSpecials.put(imageSpecial.getId(), imageSpecial);
		}
		return id;
	}

	@Override
	public int deleteImageSpecial(int imageSpecialId) {
		int id = m_imageSpecialDao.delete(imageSpecialId);
		if (id > 0) {
			m_imageSpecials.remove(imageSpecialId);
		}
		return id;
	}

	@Override
	public ImageSpecial findImageSpecial(int imageSpecialId) {
		ImageSpecial imageSpecial = m_imageSpecials.get(imageSpecialId);
		if (imageSpecial == null) {
			 imageSpecial = m_imageSpecialDao.findById(imageSpecialId);
			if (imageSpecial != null) {
				m_imageSpecials.put(imageSpecialId, imageSpecial);
			}
		}
		return imageSpecial;
	}

	public void setImageSpecialDao(ImageSpecialDao imageSpecialDao) {
		m_imageSpecialDao = imageSpecialDao;
	}

	public static class ImageSpecialCompartor implements Comparator<ImageSpecial> {

		@Override
		public int compare(ImageSpecial o1, ImageSpecial o2) {
			return o2.getId()-o1.getId();
		}

	}

	@Override
   public List<ImageSpecial> queryPagedImageSpecials(PagedTool pagedTool) {
		List<ImageSpecial> result = queryAllImageSpecials();
		return result.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());

   }

}
