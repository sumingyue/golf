package com.golf.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.InitializingBean;

import com.golf.Config;
import com.golf.dao.ImageDao;
import com.golf.entity.Image;
import com.golf.entity.ImageType;
import com.golf.entity.UploadFile;
import com.golf.service.ImageService;
import com.golf.tools.Files;
import com.golf.tools.ImageTools;

public class ImageServiceImpl implements ImageService, InitializingBean {

	private ImageDao m_imageDao;

	private Map<Integer, Image> m_images = new LinkedHashMap<Integer, Image>();

	private Logger m_logger = Logger.getLogger(ImageServiceImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<Image> images = m_imageDao.findAllImage();

		for (Image image : images) {
			m_images.put(image.getId(), image);
		}

		for (Image image : images) {
			String smallPath = image.getSmallPath();
			String path = image.getPath();
			String oldPath = "news/news";
			String newPath = "news";

			if (smallPath.indexOf(oldPath) > -1 && path.indexOf(oldPath) > -1) {
				smallPath = smallPath.replace(oldPath, newPath);
				path = path.replace(oldPath, newPath);

				image.setSmallPath(smallPath);
				image.setPath(path);

				updateImage(image);
				m_logger.info("Update image id " + image.getId() + image.getSmallPath() + image.getPath());
			}
		}
		// reload image file

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

	/***
	 * upload 原始文件 uploadFile 原始文件基本信息 type 图片分类
	 * 
	 */
	// @Override
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
			image.setType(type);

			return insertImage(image);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return -1;
		}
	}

	private void buildFilePath(UploadFile uploadFile, ImageType imageType) {
		int type = imageType.getType();

		String fileName = uploadFile.getFilename();
		String relativePath = Config.IMAGE_PATH + getImageStorePath(fileName, "_normal", type);
		String storePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + relativePath;

		String compressRelativePath = Config.IMAGE_PATH + getImageStorePath(fileName, "_small", type);
		String compressStorePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + compressRelativePath;

		String originalPath = getOriginalPath(fileName, type);
		uploadFile.setOriginalPath(originalPath);

		uploadFile.setPath(relativePath);
		uploadFile.setStorePath(storePath);

		uploadFile.setCompressedPath(compressRelativePath);
		uploadFile.setCompressedStorePath(compressStorePath);
	}

	public int insert(File upload, UploadFile uploadFile, ImageType imageType) {
		buildFilePath(uploadFile, imageType);

		int type = imageType.getType();
		int width = imageType.getWidth();
		int heigth = imageType.getHeight();
		boolean compressed = imageType.isCompress();
		int compressedWidth = imageType.getSmallWidth();
		int compressedHeight = imageType.getSmallHeight();

		try {
			double size = upload.length() * 1.0 / 1024;
			m_logger.info("upload file name:" + uploadFile.getFilename() + " size:" + size + "KB");
			storeOriginalImage(upload, uploadFile.getOriginalPath());

			String pathname = uploadFile.getStorePath();
			String pattern = pathname.substring(pathname.indexOf('.') + 1);

			File file = new File(pathname);
			file.getParentFile().mkdirs();

			if (size > 100) {
				ImageTools.compress(upload, pathname, pattern, width, heigth);
			} else {
				m_logger.info("store the orginal file to " + pathname);
				storeOriginalImage(upload, pathname);
			}

			if (compressed) {
				String compressedPath = uploadFile.getCompressedStorePath();
				file = new File(compressedPath);
				file.getParentFile().mkdirs();

				if (size > 100) {
					ImageTools.compress(upload, compressedPath, pattern, compressedWidth, compressedHeight);
				} else {
					m_logger.info("store the orginal file to " + pathname);
					storeOriginalImage(upload, compressedPath);
				}
			}

			Image image = new Image();
			image.setName(uploadFile.getFilename());
			image.setPath(uploadFile.getPath());
			image.setSmallPath(uploadFile.getCompressedPath());
			image.setOriginalPath(uploadFile.getOriginalPath());
			image.setType(type);
			image.setNetPath("");
			return insertImage(image);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return -1;
		}
	}

	private int insertImage(Image image) {
		int id = m_imageDao.insert(image);
		if (id > 0) {
			m_images.put(image.getId(), image);
		}
		return id;
	}

	@Override
	public List<Image> queryAllCategories() {
		return new ArrayList<Image>(m_images.values());
	}

	public void setImageDao(ImageDao imageDao) {
		m_imageDao = imageDao;
	}

	private void storeOriginalImage(File upload, String desPath) throws FileNotFoundException, IOException {
		InputStream in = new FileInputStream(upload);
		File file = new File(desPath);
		if (!file.getParentFile().exists()) {
			if (!file.getParentFile().mkdirs()) {
				m_logger.error("Error create parent file " + desPath);
			}
		}

		file.createNewFile();
		OutputStream os = new FileOutputStream(file);
		Files.forIO().copy(in, os);
	}

	@Override
	public int updateImage(Image image) {
		int id = m_imageDao.update(image);
		if (id > 0) {
			m_images.put(image.getId(), image);
		}
		return id;
	}

	private static String getImagePattern(String fileName) {
		int index = fileName.lastIndexOf('.');

		if (index > 0) {
			return fileName.substring(index);
		}
		return ".png";
	}

	public String getOriginalPath(String fileName, int type) {
		String path = new SimpleDateFormat("yyyyMMdd/").format(new Date()) + fileName;
		String base = "/data/appdatas/golf/image" + getImageType(type);
		return base + path;
	}

	public String getImageStorePath(String fileName, int type) {
		String typeName = getImageType(type);
		String day = new SimpleDateFormat("yyyyMMdd/").format(new Date());
		String path = typeName + day + System.currentTimeMillis() + getImagePattern(fileName);
		return path;
	}

	public String getImageStorePath(String fileName, String flag, int type) {
		String typeName = getImageType(type);
		String day = new SimpleDateFormat("yyyyMMdd/").format(new Date());
		String path = typeName + day + System.currentTimeMillis() + flag + getImagePattern(fileName);
		return path;
	}

	private static String getImageType(int type) {
		for (ImageType temp : ImageType.values()) {
			if (temp.getType() == type) {
				return '/' + temp.getFloder() + '/';
			}
		}
		return "/other/";
	}
}
