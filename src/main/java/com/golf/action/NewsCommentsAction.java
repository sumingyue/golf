package com.golf.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.NewsComments;
import com.golf.service.NewsCommentsService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class NewsCommentsAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(NewsCommentsAction.class);

	private List<NewsComments> m_newsCommentss;

	private int m_newsCommentsId;

	private NewsCommentsService m_newsCommentsService;

	private NewsComments m_newsComments = new NewsComments();

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public NewsComments getNewsComments() {
		return m_newsComments;
	}

	public List<NewsComments> getNewsCommentss() {
		return m_newsCommentss;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public String newsCommentsAddSubmit() {
		try {
			int id = m_newsCommentsService.insertNewsComments(m_newsComments);
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

	public String newsCommentsDelete() {
		try {
			int count = m_newsCommentsService.deleteNewsComments(m_newsCommentsId);
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

	public String newsCommentsList() {
		try {
			//m_pagedTool.setTotalNumber(m_newsCommentsService.queryAllNewsCommentss().size());
			//m_newsCommentss = m_newsCommentsService.queryPagedNewsCommentss(m_pagedTool);
			m_newsCommentss = m_newsCommentsService.queryAllNewsCommentss();
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String newsCommentsUpdate() {
		try {
			m_newsComments = m_newsCommentsService.findNewsComments(m_newsCommentsId);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String newsCommentsUpdateSubmit() {
		try {
			int count = m_newsCommentsService.updateNewsComments(m_newsComments);
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

	public void setIndex(int index){
		m_pagedTool.setPageIndex(index);
	}

	public void setNewsComments(NewsComments newsComments) {
		m_newsComments = newsComments;
	}
	public void setNewsCommentsId(int newsCommentsId) {
		m_newsCommentsId = newsCommentsId;
	}

	public void setNewsCommentsService(NewsCommentsService newsCommentsService) {
		m_newsCommentsService = newsCommentsService;
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}
}