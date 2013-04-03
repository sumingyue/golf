package com.golf.service;

import java.util.List;

import com.golf.entity.TravelHotel;

public interface TravelHotelService {

	public int deleteTravelHotel(int travelHotelId);

	public TravelHotel findTravelHotel(int travelHotelId);

	public int insertTravelHotel(TravelHotel travelHotel);

	public List<TravelHotel> queryAllTravelHotels();

	public int updateTravelHotel(TravelHotel travelHotel);

}
