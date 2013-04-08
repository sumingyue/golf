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

	@Override
	public int insertImageSpecial(ImageSpecial imageSpecial) {
		int id = m_imageSpecialDao.insert(imageSpecial);
		if (id > 0) {
			m_imageSpecials.put(imageSpecial.getId(), imageSpecial);
		}
		return id;
	}

	@Override
	public List<ImageSpecial> queryAllImageSpecials() {
		return new ArrayList<ImageSpecial>(m_imageSpecials.values());
	}

	@Override
	public List<ImageSpecial> queryAllImageSpecials(int categoryId, int smallCategoryId) {
		ArrayList<ImageSpecial> all = new ArrayList<ImageSpecial>(m_imageSpecials.values());
		List<ImageSpecial> result = new ArrayList<ImageSpecial>();
		for (ImageSpecial temp : all) {
			if (smallCategoryId > 0) {
				if (temp.getSmallCategoryId() == smallCategoryId) {
					result.add(temp);
				}
			} else if (categoryId > 0) {
				if (temp.getCategoryId() == categoryId) {
					result.add(temp);
				}
			} else {
				result.add(temp);
			}
		}
		Collections.sort(result, new ImageSpecialCompartor());
		return result;
	}

	@Override
	public List<ImageSpecial> queryFixedImageSpecials(int size) {
		List<ImageSpecial> all = queryAllImageSpecials();

		return resizeList(all, size);
	}

	@Override
	public List<ImageSpecial> queryPagedImageSpecials(PagedTool pagedTool, int categoryId, int smallCategoryId) {
		List<ImageSpecial> all = queryAllImageSpecials(categoryId, smallCategoryId);

		return all.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());

	}

	private List<ImageSpecial> resizeList(List<ImageSpecial> all, int size) {
		int totalSize = all.size();
		if (size > totalSize) {
			int duration = size - totalSize;
			for (int i = 0; i < duration; i++) {
				all.add(findImageSpecial(1));
			}
		} else {
			all = all.subList(0, size);
		}
		return all;
	}

	public void setImageSpecialDao(ImageSpecialDao imageSpecialDao) {
		m_imageSpecialDao = imageSpecialDao;
	}

	@Override
	public int updateImageSpecial(ImageSpecial imageSpecial) {
		int id = m_imageSpecialDao.update(imageSpecial);
		if (id > 0) {
			m_imageSpecials.put(imageSpecial.getId(), imageSpecial);
		}
		return id;
	}

	public static class ImageSpecialCompartor implements Comparator<ImageSpecial> {

		@Override
		public int compare(ImageSpecial o1, ImageSpecial o2) {
			return o2.getId() - o1.getId();
		}

	}

}
