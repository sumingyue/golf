package com.golf.service;

import java.util.List;

import com.golf.entity.TravelLog;

public interface TravelLogService {

	public int deleteTravelLog(int travelLogsId);

	public TravelLog findTravelLog(int travelLogsId);

	public int insertTravelLog(TravelLog travelLogs);

	public List<TravelLog> queryAllTravelLogs();

	public List<TravelLog> queryFixedTravelLogs(int size);

	public List<TravelLog> queryTravelLogByTravelId(int travelId);

	public int updateTravelLog(TravelLog travelLogs);

}
