package com.golf.service;

import java.io.File;
import java.util.List;

import com.golf.entity.Image;
import com.golf.entity.UploadFile;

public interface ImageService {
	public int deleteImage(int imageId);

	public Image findImage(int imageId);

	public int insert(File upload, UploadFile uploadFile, int type, int width, int heigth, boolean compressed,
	      int compressedWidh, int compressedHeigth);

	public List<Image> queryAllCategories();

   //public int insert(File file, UploadFile uploadFile, int type);
	
	public int updateImage(Image image);
	
}
