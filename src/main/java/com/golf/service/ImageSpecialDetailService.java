package com.golf.service;

import java.util.List;

import com.golf.entity.ImageSpecialDetail;
import com.golf.tools.PagedTool;

public interface ImageSpecialDetailService {

	public List<ImageSpecialDetail> queryAllImageSpecialDetails(int imageSpecialId);

	public int insertImageSpecialDetail(ImageSpecialDetail imageSpecialDetail);

	public int updateImageSpecialDetail(ImageSpecialDetail imageSpecialDetail);

	public int deleteImageSpecialDetail(int imageSpecialDetailId);

	public ImageSpecialDetail findImageSpecialDetail(int imageSpecialDetailId);

	public List<ImageSpecialDetail> queryPagedImageSpecialDetails(PagedTool tool, int imageSpecialId);

}
