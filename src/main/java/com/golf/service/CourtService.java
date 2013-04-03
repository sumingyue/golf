package com.golf.service;

import java.util.List;

import com.golf.entity.Court;
import com.golf.tools.PagedTool;

public interface CourtService {

	public int deleteCourt(int courtId);

	public Court findCourt(int courtId);

	public int insertCourt(Court court);

	public List<Court> queryAllCourts();

	public List<Court> queryFixedCourts(int i);

	public List<Court> queryPagedCourts(PagedTool tool);

	public int updateCourt(Court court);

}
