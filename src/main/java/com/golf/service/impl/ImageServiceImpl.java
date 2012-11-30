package com.golf.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.ImageDao;
import com.golf.entity.Image;
import com.golf.entity.UploadFile;
import com.golf.service.ImageService;
import com.golf.tools.Files;

public class ImageServiceImpl implements ImageService, InitializingBean {

	private ImageDao m_imageDao;

	private Map<Integer, Image> m_images = new LinkedHashMap<Integer, Image>();

	private Logger m_logger = Logger.getLogger(ImageServiceImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<Image> categories = m_imageDao.findAllImage();

		for (Image image : categories) {
			m_images.put(image.getId(), image);
		}
	}

	@Override
	public List<Image> queryAllCategories() {
		return new ArrayList<Image>(m_images.values());
	}

	private int insertImage(Image image) {
		int id = m_imageDao.insert(image);
		if (id > 0) {
			m_images.put(image.getId(), image);
		}
		return id;
	}

	@Override
	public int updateImage(Image image) {
		int id = m_imageDao.update(image);
		if (id > 0) {
			m_images.put(image.getId(), image);
		}
		return id;
	}

	@Override
	public int deleteImage(int imageId) {
		int id = m_imageDao.delete(imageId);
		if (id > 0) {
			m_images.remove(imageId);
		}
		return id;
	}

	@Override
	public Image findImage(int imageId) {
		Image image = m_images.get(imageId);
		if (image == null) {
			Image temp = m_imageDao.findById(imageId);
			if (temp != null) {
				m_images.put(imageId, temp);
			}
			return temp;
		}
		return image;
	}

	public void setImageDao(ImageDao imageDao) {
		m_imageDao = imageDao;
	}

	@Override
	public int insert(File upload, UploadFile uploadFile, int type) {
		try {
			InputStream in = new FileInputStream(upload);

			String pathname = uploadFile.getStorePath();
			File file = new File(pathname);

			file.getParentFile().mkdirs();
			OutputStream os = new FileOutputStream(file);
			Files.forIO().copy(in, os);

			Image image = new Image();
			image.setName(uploadFile.getFilename());
			image.setPath(uploadFile.getPath());
			image.setNetPath("");
			image.setStorePath(pathname);
			image.setType(type);

			return insertImage(image);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return -1;
		}
	}

}
