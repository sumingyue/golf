package com.golf.main;

import java.util.List;

import com.golf.entity.Court;
import com.golf.entity.News;
import com.golf.service.AdwordsService;
import com.golf.service.CourtService;
import com.golf.service.NewsService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class PracticeAction extends ActionSupport {

	private static final long serialVersionUID = 2801256589554291998L;

	@SuppressWarnings("unused")
   private NewsService m_newsService;

	private CourtService m_courtService;

	private List<News> m_news;

	private List<Court> m_courts;

	private PagedTool m_pagedTool = new PagedTool(15);

	private AdwordsService m_adwordsService;

	public String courtList() {
		m_pagedTool.setTotalNumber(m_courtService.queryAllCourts().size());
		m_courts = m_courtService.queryPagedCourts(m_pagedTool);
		return SUCCESS;
	}

	public AdwordsService getAdwordsService() {
		return m_adwordsService;
	}

	public List<Court> getCourts() {
		return m_courts;
	}

	public List<News> getNews() {
		return m_news;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public void setAdwordsService(AdwordsService adwordsService) {
		m_adwordsService = adwordsService;
	}

	public void setCourtService(CourtService courtService) {
		m_courtService = courtService;
	}

	public void setNewsService(NewsService newsService) {
		m_newsService = newsService;
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}

}