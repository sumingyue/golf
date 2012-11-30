package com.golf.service;

import java.util.List;

import com.golf.entity.CourtImage;
import com.golf.tools.PagedTool;

public interface CourtImageService {

	public List<CourtImage> queryAllCourtImages(int courtId);

	public int insertCourtImage(CourtImage courtImage);

	public int updateCourtImage(CourtImage courtImage);

	public int deleteCourtImage(int courtImageId);

	public CourtImage findCourtImage(int courtImageId);

	public List<CourtImage> queryPagedCourtImages(PagedTool pagedTool, int courtId);

}
