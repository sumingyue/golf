package com.golf.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.CourtOrder;
import com.golf.service.CourtOrderService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class CourtOrderAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(CourtOrderAction.class);

	private List<CourtOrder> m_courtOrders;

	private int m_courtOrderId;

	private CourtOrderService m_courtOrderService;

	private CourtOrder m_courtOrder = new CourtOrder();

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public String courtOrderAddSubmit() {
		try {
			int id = m_courtOrderService.insertCourtOrder(m_courtOrder);
			if (id > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}

		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public String courtOrderDelete() {
		try {
			int count = m_courtOrderService.deleteCourtOrder(m_courtOrderId);
			if (count > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public String courtOrderList() {
		try {
			//m_pagedTool.setTotalNumber(m_courtOrderService.queryAllCourtOrders().size());
			//m_courtOrders = m_courtOrderService.queryPagedCourtOrders(m_pagedTool);
			m_courtOrders = m_courtOrderService.queryAllCourtOrders();
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String courtOrderUpdate() {
		try {
			m_courtOrder = m_courtOrderService.findCourtOrder(m_courtOrderId);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String courtOrderUpdateSubmit() {
		try {
			int count = m_courtOrderService.updateCourtOrder(m_courtOrder);
			if (count > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public CourtOrder getCourtOrder() {
		return m_courtOrder;
	}

	public List<CourtOrder> getCourtOrders() {
		return m_courtOrders;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public void setCourtOrder(CourtOrder courtOrder) {
		m_courtOrder = courtOrder;
	}

	public void setCourtOrderId(int courtOrderId) {
		m_courtOrderId = courtOrderId;
	}
	public void setCourtOrderService(CourtOrderService courtOrderService) {
		m_courtOrderService = courtOrderService;
	}

	public void setIndex(int index){
		m_pagedTool.setPageIndex(index);
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}
}