package com.golf.service;

import java.util.List;

import com.golf.entity.TravelPlan;
import com.golf.tools.PagedTool;

public interface TravelPlanService {

	public int deleteTravelPlan(int travelPlanId);

	public TravelPlan findTravelPlan(int travelPlanId);

	public int insertTravelPlan(TravelPlan travelPlan);

	public List<TravelPlan> queryAllTravelPlans(int travelId);

	public List<TravelPlan> queryPagedTravelPlans(PagedTool pagedTool, int courtId);

	public int updateTravelPlan(TravelPlan travelPlan);

}
