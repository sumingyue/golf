package com.golf.service;

import java.util.List;

import com.golf.entity.ImageSpecial;
import com.golf.tools.PagedTool;

public interface ImageSpecialService {
	public int deleteImageSpecial(int imageSpecialId);

	public ImageSpecial findImageSpecial(int imageSpecialId);

	public int insertImageSpecial(ImageSpecial imageSpecial);

	public List<ImageSpecial> queryAllImageSpecials();

	public List<ImageSpecial> queryAllImageSpecials(int m_categoryId,int m_smallCategoryId);

	public List<ImageSpecial> queryFixedImageSpecials(int size);

	public List<ImageSpecial> queryPagedImageSpecials(PagedTool pagedTool,int m_categoryId,int m_smallCategoryId);

	public int updateImageSpecial(ImageSpecial imageSpecial);

}
