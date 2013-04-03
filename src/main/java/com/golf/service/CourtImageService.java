package com.golf.service;

import java.util.List;

import com.golf.entity.CourtImage;
import com.golf.tools.PagedTool;

public interface CourtImageService {

	public int deleteCourtImage(int courtImageId);

	public CourtImage findCourtImage(int courtImageId);

	public int insertCourtImage(CourtImage courtImage);

	public List<CourtImage> queryAllCourtImages(int courtId);

	public List<CourtImage> queryPagedCourtImages(PagedTool pagedTool, int courtId);

	public int updateCourtImage(CourtImage courtImage);

}
