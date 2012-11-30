package com.golf.main;

import java.util.List;

import com.golf.Config;
import com.golf.entity.Court;
import com.golf.entity.News;
import com.golf.service.CourtService;
import com.golf.service.NewsService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class PracticeAction extends ActionSupport {

	private static final long serialVersionUID = 2801256589554291998L;

	private NewsService m_newsService;

	private CourtService m_courtService;

	private List<News> m_news;

	private List<Court> m_courts;

	private List<News> m_qiuhui;

	private List<News> m_xiehui;

	private List<News> m_huiji;

	private PagedTool m_pagedTool = new PagedTool(15);

	public String practiceList() {
		m_pagedTool.setTotalNumber(m_newsService.queryTotalSize(0, Config.QiuChang_Lianxi));
		m_news = m_newsService.queryPagedNews(m_pagedTool, 0,
		      Config.QiuChang_Lianxi);

		m_qiuhui = m_newsService.queryNewsBySmallCategoryId(8, Config.QiuHui_ZiXun);
		m_xiehui = m_newsService.queryNewsBySmallCategoryId(8, Config.QiuHui_ZiXun);
		m_huiji = m_newsService.queryNewsBySmallCategoryId(8, Config.QiuHui_ZiXun);
		// TOOD
		if (m_news.size() < 15) {
			int total = 15 - m_news.size();
			for (int i = 0; i < total; i++) {
				m_news.add(m_newsService.findNews(27));
			}
		}
		return SUCCESS;
	}

	public String courtList() {
		m_pagedTool.setTotalNumber(m_courtService.queryAllCourts().size());
		m_courts = m_courtService.queryPagedCourts(m_pagedTool);

		m_qiuhui = m_newsService.queryNewsBySmallCategoryId(8, Config.QiuHui_ZiXun);
		m_xiehui = m_newsService.queryNewsBySmallCategoryId(8, Config.QiuHui_ZiXun);
		m_huiji = m_newsService.queryNewsBySmallCategoryId(8, Config.QiuHui_ZiXun);
		return SUCCESS;
	}

	public String clubList() {
		return SUCCESS;
	}

	public List<News> getNews() {
		return m_news;
	}

	public void setNewsService(NewsService newsService) {
		m_newsService = newsService;
	}

	public List<News> getQiuhui() {
		return m_qiuhui;
	}

	public List<News> getXiehui() {
		return m_xiehui;
	}

	public List<News> getHuiji() {
		return m_huiji;
	}

	public void setCourtService(CourtService courtService) {
		m_courtService = courtService;
	}

	public List<Court> getCourts() {
		return m_courts;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}

}