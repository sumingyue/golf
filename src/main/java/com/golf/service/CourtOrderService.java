package com.golf.service;

import java.util.List;

import com.golf.entity.CourtOrder;
import com.golf.tools.PagedTool;

public interface CourtOrderService {

	public List<CourtOrder> queryAllCourtOrders();

	public int insertCourtOrder(CourtOrder courtOrder);

	public int updateCourtOrder(CourtOrder courtOrder);

	public int deleteCourtOrder(int courtOrderId);

	public CourtOrder findCourtOrder(int courtOrderId);

	public List<CourtOrder> queryPagedCourtOrders(PagedTool pagedTool);

}
