package com.golf.service;

import java.util.List;

import com.golf.entity.Travel;

public interface TravelService {

	public int deleteTravel(int travelId);

	public Travel findTravel(int travelId);

	public int insertTravel(Travel travel);

	public List<Travel> queryAllTravels();

	public int updateTravel(Travel travel);

}
