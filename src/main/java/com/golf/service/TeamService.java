package com.golf.service;

import java.util.List;

import com.golf.entity.Image;
import com.golf.entity.Team;
import com.golf.tools.PagedTool;

public interface TeamService {

	public int deleteTeam(int teamId);

	public Image findLogo(int teamId);

	public Team findTeam(int teamId);

	public int insertTeam(Team team);

	public List<Team> queryAllTeams();
	
	public List<Team> queryPagedTeams(PagedTool tool);
	
	public int updateTeam(Team team);

	public int updateTeamLogo(int id,int imageId);

}
