package com.golf.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.Team;
import com.golf.entity.TeamNews;
import com.golf.service.TeamNewsService;
import com.golf.service.TeamService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class TeamNewsAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(TeamNewsAction.class);

	private List<TeamNews> m_teamNewss;

	private List<Team> m_teams;

	private int m_teamNewsId;
	
	private int m_teamId;

	private int m_type;
	
	private TeamNewsService m_teamNewsService;
	
	private TeamService m_teamService;

	private TeamNews m_teamNews = new TeamNews();
	
	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public String teamNewsList() {
		try {
//			m_teams = m_teamService.queryAllTeams();
//			m_pagedTool.setTotalNumber(m_teamNewsService.queryNewByTeamAndType(m_teamId,m_type).size());
//			m_teamNewss = m_teamNewsService.queryPagedNewByTeamAndType(m_pagedTool,m_teamId,m_type);
			m_teamNewss = m_teamNewsService.queryAllTeamNewss();
			for(TeamNews temp:m_teamNewss){
				temp.setTeam(m_teamService.findTeam(temp.getTeamId()));
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String teamNewsAdd(){
		m_teams = m_teamService.queryAllTeams();
		return SUCCESS;
	}
	
	public String teamNewsAddSubmit() {
		try {
			int id = m_teamNewsService.insertTeamNews(m_teamNews);
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

	public String teamNewsUpdate() {
		try {
			m_teams = m_teamService.queryAllTeams();
			m_teamNews = m_teamNewsService.findTeamNews(m_teamNewsId);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String teamNewsUpdateSubmit() {
		try {
			int count = m_teamNewsService.updateTeamNews(m_teamNews);
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

	public String teamNewsDelete() {
		try {
			int count = m_teamNewsService.deleteTeamNews(m_teamNewsId);
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

	public TeamNews getTeamNews() {
		return m_teamNews;
	}

	public void setTeamNews(TeamNews teamNews) {
		m_teamNews = teamNews;
	}

	public void setTeamNewsService(TeamNewsService teamNewsService) {
		m_teamNewsService = teamNewsService;
	}

	public List<TeamNews> getTeamNewss() {
		return m_teamNewss;
	}

	public void setTeamNewsId(int teamNewsId) {
		m_teamNewsId = teamNewsId;
	}

	public void setTeamService(TeamService teamService) {
		m_teamService = teamService;
	}

	public List<Team> getTeams() {
		return m_teams;
	}

	public int getTeamId() {
		return m_teamId;
	}

	public void setTeamId(int teamId) {
		m_teamId = teamId;
	}

	public int getType() {
		return m_type;
	}

	public void setType(int type) {
		m_type = type;
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