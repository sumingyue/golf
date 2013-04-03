package com.golf.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.Travel;
import com.golf.entity.TravelLog;
import com.golf.service.TravelLogService;
import com.golf.service.TravelService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class TravelLogAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private static final String LIST = "travelLogList.do";

	private Logger m_logger = Logger.getLogger(TravelLogAction.class);

	private List<TravelLog> m_travelLogs;

	private List<Travel> m_travels;

	private int m_travelLogId;
	
	private int m_travelId;

	private int m_type;
	
	private TravelLogService m_travelLogService;
	
	private TravelService m_travelService;

	private TravelLog m_travelLog = new TravelLog();
	
	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public String getActionList() {
		return LIST;
	}
	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public int getTravelId() {
		return m_travelId;
	}
	
	public TravelLog getTravelLog() {
		return m_travelLog;
	}

	public List<TravelLog> getTravelLogs() {
		return m_travelLogs;
	}

	public List<Travel> getTravels() {
		return m_travels;
	}

	public int getType() {
		return m_type;
	}

	public void setIndex(int index){
		m_pagedTool.setPageIndex(index);
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}

	public void setTravelId(int travelId) {
		m_travelId = travelId;
	}

	public void setTravelLog(TravelLog travelLog) {
		m_travelLog = travelLog;
	}

	public void setTravelLogId(int travelLogId) {
		m_travelLogId = travelLogId;
	}

	public void setTravelLogService(TravelLogService travelLogService) {
		m_travelLogService = travelLogService;
	}

	public void setTravelService(TravelService travelService) {
		m_travelService = travelService;
	}

	public void setType(int type) {
		m_type = type;
	}

	public String travelLogAdd(){
		m_travels = m_travelService.queryAllTravels();
		return SUCCESS;
	}

	public String travelLogAddSubmit() {
		try {
			int id = m_travelLogService.insertTravelLog(m_travelLog);
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

	public String travelLogDelete() {
		try {
			int count = m_travelLogService.deleteTravelLog(m_travelLogId);
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
	public String travelLogList() {
		try {
//			m_travels = m_travelService.queryAllTravels();
//			m_pagedTool.setTotalNumber(m_travelLogService.queryNewByTravelAndType(m_travelId,m_type).size());
//			m_travelLogs = m_travelLogService.queryPagedNewByTravelAndType(m_pagedTool,m_travelId,m_type);
			m_travelLogs = m_travelLogService.queryAllTravelLogs();
			for(TravelLog temp:m_travelLogs){
				temp.setTravel(m_travelService.findTravel(temp.getTravelId()));
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String travelLogUpdate() {
		try {
			m_travels = m_travelService.queryAllTravels();
			m_travelLog = m_travelLogService.findTravelLog(m_travelLogId);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String travelLogUpdateSubmit() {
		try {
			int count = m_travelLogService.updateTravelLog(m_travelLog);
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