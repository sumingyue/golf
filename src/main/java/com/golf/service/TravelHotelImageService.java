package com.golf.service;

import java.util.List;

import com.golf.entity.TravelHotelImage;
import com.golf.tools.PagedTool;

public interface TravelHotelImageService {

	public int deleteTravelHotelImage(int travelHotelImageId);

	public TravelHotelImage findTravelHotelImage(int travelHotelImageId);

	public int insertTravelHotelImage(TravelHotelImage travelHotelImage);

	public List<TravelHotelImage> queryAllTravelHotelImages(int travelHotelId);

	public List<TravelHotelImage> queryPagedTravelHotelImages(PagedTool pagedTool, int travelHotelId);

	public int updateTravelHotelImage(TravelHotelImage travelHotelImage);

}
