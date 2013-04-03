package com.golf.service;

import java.util.List;

import com.golf.entity.TravelCourt;

public interface TravelCourtService {

	public int deleteTravelCourt(int travelCourtId);
	
	public int deleteByTravelId(int travelId);

	public TravelCourt findTravelCourt(int travelCourtId);

	public int insertTravelCourt(TravelCourt travelCourt);

	public List<TravelCourt> queryAllTravelCourts();
	
	public List<TravelCourt> queryAllByTravelId(int travelId);

	public int updateTravelCourt(TravelCourt travelCourt);

}
