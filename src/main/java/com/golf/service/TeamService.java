package com.golf.service;

import java.util.List;

import com.golf.entity.Image;
import com.golf.entity.Team;
import com.golf.tools.PagedTool;

public interface TeamService {

	public List<Team> queryAllTeams();

	public int insertTeam(Team team);

	public int updateTeam(Team team);

	public int deleteTeam(int teamId);

	public Team findTeam(int teamId);
	
	public Image findLogo(int teamId);
	
	public int updateTeamLogo(int id,int imageId);

	public List<Team> queryPagedTeams(PagedTool tool);

}
