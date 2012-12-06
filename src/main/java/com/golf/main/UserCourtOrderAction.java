package com.golf.main;

import org.apache.log4j.Logger;

import com.golf.action.CourtOrderAction;
import com.golf.entity.CourtOrder;
import com.golf.service.AdwordsService;
import com.golf.service.CourtOrderService;
import com.opensymphony.xwork2.ActionSupport;

public class UserCourtOrderAction extends ActionSupport {

	private static final long serialVersionUID = 2801356599554299998L;

	private Logger m_logger = Logger.getLogger(CourtOrderAction.class);

	private CourtOrderService m_courtOrderService;

	private CourtOrder m_courtOrder = new CourtOrder();

	private AdwordsService m_adwordsService;

	public String courtOrderAdd() {
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

	public CourtOrder getCourtOrder() {
		return m_courtOrder;
	}

	public void setCourtOrder(CourtOrder courtOrder) {
		m_courtOrder = courtOrder;
	}

	public void setCourtOrderService(CourtOrderService courtOrderService) {
		m_courtOrderService = courtOrderService;
	}
	
	public void setAdwordsService(AdwordsService adwordsService) {
		m_adwordsService = adwordsService;
	}
	
	public AdwordsService getAdwordsService() {
		return m_adwordsService;
	}

}