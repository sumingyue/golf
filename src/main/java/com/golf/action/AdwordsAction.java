package com.golf.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.Adwords;
import com.golf.service.AdwordsService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class AdwordsAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(AdwordsAction.class);

	private List<Adwords> m_adwordss;

	private int m_adwordsId;

	private AdwordsService m_adwordsService;

	private Adwords m_adwords = new Adwords();

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public String adwordsList() {
		try {
			m_pagedTool.setTotalNumber(m_adwordsService.queryAllAdwordss().size());
			m_adwordss = m_adwordsService.queryPagedAdwordss(m_pagedTool);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String adwordsAddSubmit() {
		try {
			int id = m_adwordsService.insertAdwords(m_adwords);
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

	public String adwordsUpdate() {
		try {
			m_adwords = m_adwordsService.findAdwords(m_adwordsId);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String adwordsUpdateSubmit() {
		try {
			int count = m_adwordsService.updateAdwords(m_adwords);
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

	public String adwordsDelete() {
		try {
			int count = m_adwordsService.deleteAdwords(m_adwordsId);
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

	public Adwords getAdwords() {
		return m_adwords;
	}

	public void setAdwords(Adwords adwords) {
		m_adwords = adwords;
	}

	public void setAdwordsService(AdwordsService adwordsService) {
		m_adwordsService = adwordsService;
	}

	public List<Adwords> getAdwordss() {
		return m_adwordss;
	}

	public void setAdwordsId(int adwordsId) {
		m_adwordsId = adwordsId;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}

	public void setIndex(int index) {
		m_pagedTool.setPageIndex(index);
	}
}