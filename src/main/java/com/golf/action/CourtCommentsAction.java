package com.golf.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.Court;
import com.golf.entity.CourtComments;
import com.golf.service.CourtCommentsService;
import com.golf.service.CourtService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class CourtCommentsAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(CourtCommentsAction.class);

	private List<CourtComments> m_courtCommentss;

	private int m_courtCommentsId;

	private CourtService m_courtService;

	private List<Court> m_courts;
	
	private int m_courtId;

	private CourtCommentsService m_courtCommentsService;

	private CourtComments m_courtComments = new CourtComments();
	
	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public String courtCommentsList() {
		try {
			m_courts =m_courtService.queryAllCourts();
			m_pagedTool.setTotalNumber(m_courtCommentsService.queryAllCourtCommentss(m_courtId).size());
			m_courtCommentss = m_courtCommentsService.queryPagedCourtCommentss(m_pagedTool,m_courtId);
			
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String courtCommentsAdd(){
		m_courts =m_courtService.queryAllCourts();
		return SUCCESS;
	}

	public String courtCommentsAddSubmit() {
		try {
			int id = m_courtCommentsService.insertCourtComments(m_courtComments);
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

	public String courtCommentsUpdate() {
		m_courts =m_courtService.queryAllCourts();
		try {
			m_courtComments = m_courtCommentsService.findCourtComments(m_courtCommentsId);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String courtCommentsUpdateSubmit() {
		try {
			int count = m_courtCommentsService.updateCourtComments(m_courtComments);
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

	public String courtCommentsDelete() {
		try {
			int count = m_courtCommentsService.deleteCourtComments(m_courtCommentsId);
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

	public CourtComments getCourtComments() {
		return m_courtComments;
	}

	public void setCourtComments(CourtComments courtComments) {
		m_courtComments = courtComments;
	}

	public void setCourtCommentsService(CourtCommentsService courtCommentsService) {
		m_courtCommentsService = courtCommentsService;
	}

	public List<CourtComments> getCourtCommentss() {
		return m_courtCommentss;
	}

	public void setCourtCommentsId(int courtCommentsId) {
		m_courtCommentsId = courtCommentsId;
	}

	public List<Court> getCourts() {
		return m_courts;
	}

	public void setCourtService(CourtService courtService) {
		m_courtService = courtService;
	}

	public int getCourtId() {
		return m_courtId;
	}

	public void setCourtId(int courtId) {
		m_courtId = courtId;
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