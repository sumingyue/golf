package com.golf.service;

import java.util.List;

import com.golf.entity.CourtOrder;
import com.golf.tools.PagedTool;

public interface CourtOrderService {

	public int deleteCourtOrder(int courtOrderId);

	public CourtOrder findCourtOrder(int courtOrderId);

	public int insertCourtOrder(CourtOrder courtOrder);

	public List<CourtOrder> queryAllCourtOrders();

	public List<CourtOrder> queryPagedCourtOrders(PagedTool pagedTool);

	public int updateCourtOrder(CourtOrder courtOrder);

}
