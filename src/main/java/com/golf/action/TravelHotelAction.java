package com.golf.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.TravelHotel;
import com.golf.service.TravelHotelService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class TravelHotelAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(TravelHotelAction.class);
	
	private static final String LIST="travelHotelList.do";

	private List<TravelHotel> m_travelHotels;

	private int m_travelHotelId;

	private TravelHotelService m_travelHotelService;

	private TravelHotel m_travelHotel = new TravelHotel();

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public String getActionList(){
		return LIST;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public TravelHotel getTravelHotel() {
		return m_travelHotel;
	}

	public List<TravelHotel> getTravelHotels() {
		return m_travelHotels;
	}

	public void setId(int id){
		m_travelHotelId = id;
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}

	public void setTravelHotel(TravelHotel travelHotel) {
		m_travelHotel = travelHotel;
	}

	public void setTravelHotelId(int travelHotelId) {
		m_travelHotelId = travelHotelId;
	}

	public void setTravelHotelService(TravelHotelService travelHotelService) {
		m_travelHotelService = travelHotelService;
	}

	public String travelHotelAddSubmit() {
		try {
			int id = m_travelHotelService.insertTravelHotel(m_travelHotel);
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

	public String travelHotelDelete() {
		try {
			int count = m_travelHotelService.deleteTravelHotel(m_travelHotelId);
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

	public String travelHotelList() {
		try {
			m_travelHotels = m_travelHotelService.queryAllTravelHotels();
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String travelHotelUpdate() {
		try {
			m_travelHotel = m_travelHotelService.findTravelHotel(m_travelHotelId);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}
	public String travelHotelUpdateSubmit() {
		try {
			int count = m_travelHotelService.updateTravelHotel(m_travelHotel);
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
}