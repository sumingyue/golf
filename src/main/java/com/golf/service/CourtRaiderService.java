package com.golf.service;

import java.util.List;

import com.golf.entity.CourtRaider;
import com.golf.tools.PagedTool;

public interface CourtRaiderService {

	public int deleteCourtRaider(int courtRaiderId);

	public CourtRaider findCourtRaider(int courtRaiderId);

	public int insertCourtRaider(CourtRaider courtRaider);

	public List<CourtRaider> queryAllCourtRaiders(int courtId);

	public List<CourtRaider> queryPagedCourtRaiders(PagedTool pagedTool, int courtId);

	public int updateCourtRaider(CourtRaider courtRaider);

}
