package com.golf.main;

import java.util.List;

import com.golf.entity.Team;
import com.golf.entity.TeamMemberImage;
import com.golf.entity.TeamNews;
import com.golf.service.ImageService;
import com.golf.service.TeamMemberImageService;
import com.golf.service.TeamNewsService;
import com.golf.service.TeamService;
import com.opensymphony.xwork2.ActionSupport;

public class TeamAction extends ActionSupport {
	private static final long serialVersionUID = 5395613067629677634L;

	private List<Team> m_teams;

	private int m_teamId;

	private TeamService m_teamService;

	private TeamNewsService m_teamNewsService;

	private TeamMemberImageService m_teamMemberImageService;

	private ImageService m_imageService;

	private Team m_team = new Team();

	private int m_type;

	private List<TeamNews> m_teamNewss;

	private List<TeamNews> m_news1;

	private List<TeamNews> m_news2;

	private List<TeamNews> m_news3;

	private List<TeamNews> m_news4;

	private int m_teamNewsId;

	private TeamNews m_teamNews;
	
	private List<TeamMemberImage> m_images;

	public String teamList() {
		m_teams = m_teamService.queryAllTeams();
		for (Team team : m_teams) {
			team.setLogo(m_imageService.findImage(team.getImageId()));
		}
		return SUCCESS;
	}

	public String teamDetail() {
		m_team = m_teamService.findTeam(m_teamId);
		m_team.setLogo(m_imageService.findImage(m_team.getImageId()));
		m_news1 = m_teamNewsService.queryNewByTeamAndType(8, m_teamId, 1);
		m_news2 = m_teamNewsService.queryNewByTeamAndType(8, m_teamId, 2);
		m_news3 = m_teamNewsService.queryNewByTeamAndType(8, m_teamId, 3);
		m_news4 = m_teamNewsService.queryNewByTeamAndType(8, m_teamId, 4);

		m_images = m_teamMemberImageService.queryAllTeamMemberImages(m_teamId);

		int size = 4;
		if (m_images.size() > size) {
			m_images = m_images.subList(0, size);
		}
		for(TeamMemberImage image:m_images){
			image.setImage(m_imageService.findImage(image.getImageId()));
		}
		
		match(m_news1, 6);
		match(m_news2, 6);
		match(m_news3, 6);
		match(m_news4, 6);
		return SUCCESS;
	}

	private void match(List<TeamNews> list, int size) {
		int total = list.size();
		if (total < size) {
			int o = size - total;
			for (int i = 0; i < o; i++) {
				list.add(m_teamNewsService.findTeamNews(3));
			}
		}
	}

	public String teamNewsList() {
		m_teamNewss = m_teamNewsService.queryNewByTeamAndType(m_teamId, m_type);

		match(m_teamNewss, 15);
		return SUCCESS;
	}

	public String teamNewsDetail() {
		m_teamNews = m_teamNewsService.findTeamNews(m_teamNewsId);
		m_teamNews.setTeam(m_teamService.findTeam(m_teamNews.getTeamId()));
		return SUCCESS;
	}

	public int getTeamId() {
		return m_teamId;
	}

	public void setTeamId(int teamId) {
		m_teamId = teamId;
	}

	public List<Team> getTeams() {
		return m_teams;
	}

	public Team getTeam() {
		return m_team;
	}

	public void setTeamService(TeamService teamService) {
		m_teamService = teamService;
	}

	public void setTeamNewsService(TeamNewsService teamNewsService) {
		m_teamNewsService = teamNewsService;
	}

	public void setTeamMemberImageService(TeamMemberImageService teamMemberImageService) {
		m_teamMemberImageService = teamMemberImageService;
	}

	public void setType(int type) {
		m_type = type;
	}

	public List<TeamNews> getTeamNewss() {
		return m_teamNewss;
	}

	public List<TeamNews> getNews1() {
		return m_news1;
	}

	public List<TeamNews> getNews2() {
		return m_news2;
	}

	public List<TeamNews> getNews3() {
		return m_news3;
	}

	public List<TeamNews> getNews4() {
		return m_news4;
	}

	public void setTeamNewsId(int teamNewsId) {
		m_teamNewsId = teamNewsId;
	}

	public TeamNews getTeamNews() {
		return m_teamNews;
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public List<TeamMemberImage> getImages() {
		return m_images;
	}

	
}
