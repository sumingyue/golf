package com.golf.service;

import java.util.List;

import com.golf.entity.ImageSpecialDetail;
import com.golf.tools.PagedTool;

public interface ImageSpecialDetailService {

	public int deleteImageSpecialDetail(int imageSpecialDetailId);

	public ImageSpecialDetail findImageSpecialDetail(int imageSpecialDetailId);

	public int insertImageSpecialDetail(ImageSpecialDetail imageSpecialDetail);

	public List<ImageSpecialDetail> queryAllImageSpecialDetails(int imageSpecialId);

	public List<ImageSpecialDetail> queryPagedImageSpecialDetails(PagedTool tool, int imageSpecialId);

	public int updateImageSpecialDetail(ImageSpecialDetail imageSpecialDetail);

}
