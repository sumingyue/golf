package com.golf.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.MatchService;
import com.golf.service.MatchServiceService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class MatchServiceAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(MatchServiceAction.class);

	private List<MatchService> m_matchServices;

	private int m_matchServiceId;

	private MatchServiceService m_matchServiceService;

	private MatchService m_matchService = new MatchService();

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public String matchServiceList() {
		try {
			//m_pagedTool.setTotalNumber(m_matchServiceService.queryAllMatchServices().size());
			//m_matchServices = m_matchServiceService.queryPagedMatchServices(m_pagedTool);
			m_matchServices = m_matchServiceService.queryAllMatchServices();
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String matchServiceAddSubmit() {
		try {
			int id = m_matchServiceService.insertMatchService(m_matchService);
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

	public String matchServiceUpdate() {
		try {
			m_matchService = m_matchServiceService.findMatchService(m_matchServiceId);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String matchServiceUpdateSubmit() {
		try {
			int count = m_matchServiceService.updateMatchService(m_matchService);
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

	public String matchServiceDelete() {
		try {
			int count = m_matchServiceService.deleteMatchService(m_matchServiceId);
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

	public MatchService getMatchService() {
		return m_matchService;
	}

	public void setMatchService(MatchService matchService) {
		m_matchService = matchService;
	}

	public void setMatchServiceService(MatchServiceService matchServiceService) {
		m_matchServiceService = matchServiceService;
	}

	public List<MatchService> getMatchServices() {
		return m_matchServices;
	}

	public void setMatchServiceId(int matchServiceId) {
		m_matchServiceId = matchServiceId;
	}
	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}

	public void setIndex(int index){
		m_pagedTool.setPageIndex(index);
	}
}