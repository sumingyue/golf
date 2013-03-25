package com.golf.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.TeamDao;
import com.golf.entity.Image;
import com.golf.entity.Team;
import com.golf.service.ImageService;
import com.golf.service.TeamService;
import com.golf.tools.PagedTool;

public class TeamServiceImpl implements InitializingBean, TeamService {

	private TeamDao m_teamDao;

	private ImageService m_imageService;

	private Map<Integer, Team> m_teams = new LinkedHashMap<Integer, Team>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<Team> categories = m_teamDao.findAllTeam();

		for (Team team : categories) {
			m_teams.put(team.getId(), team);
		}
	}

	@Override
	public int deleteTeam(int teamId) {
		int id = m_teamDao.delete(teamId);
		if (id > 0) {
			m_teams.remove(teamId);
		}
		return id;
	}

	@Override
	public Image findLogo(int teamId) {
		Team team = findTeam(teamId);
		return m_imageService.findImage(team.getImageId());
	}

	@Override
	public Team findTeam(int teamId) {
		Team team = m_teams.get(teamId);
		if (team == null) {
			Team temp = m_teamDao.findById(teamId);
			if (temp != null) {
				m_teams.put(teamId, temp);
			}
			return temp;
		}
		return team;
	}

	@Override
	public int insertTeam(Team team) {
		int id = m_teamDao.insert(team);
		if (id > 0) {
			team.setImageId(findTeam(team.getId()).getImageId());
			m_teams.put(team.getId(), team);
		}
		return id;
	}

	@Override
	public List<Team> queryAllTeams() {
		return new ArrayList<Team>(m_teams.values());
	}

	@Override
	public List<Team> queryPagedTeams(PagedTool pagedTool) {
		List<Team> result = queryAllTeams();
		return result.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());

	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public void setTeamDao(TeamDao teamDao) {
		m_teamDao = teamDao;
	}

	@Override
	public int updateTeam(Team team) {
		int id = m_teamDao.update(team);
		if (id > 0) {
			team.setImageId(findTeam(team.getId()).getImageId());
			m_teams.put(team.getId(), team);
		}
		return id;
	}

	@Override
	public int updateTeamLogo(int id, int imageId) {
		return m_teamDao.updateLogo(id, imageId);
	}

}
