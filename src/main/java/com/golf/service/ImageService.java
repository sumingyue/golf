package com.golf.service;

import java.io.File;
import java.util.List;

import com.golf.entity.Image;
import com.golf.entity.ImageType;
import com.golf.entity.UploadFile;

public interface ImageService {
	public int deleteImage(int imageId);

	public Image findImage(int imageId);

	public int insert(File upload, UploadFile uploadFile, ImageType type);

	public List<Image> queryAllCategories();

	public int updateImage(Image image);

}
