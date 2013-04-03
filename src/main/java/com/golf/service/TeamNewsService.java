package com.golf.service;

import java.util.List;

import com.golf.entity.TeamNews;
import com.golf.tools.PagedTool;

public interface TeamNewsService {

	public int deleteTeamNews(int teamNewsId);

	public TeamNews findTeamNews(int teamNewsId);

	public int insertTeamNews(TeamNews teamNews);

	public List<TeamNews> queryAllTeamNewss();

	public List<TeamNews> queryFixedTeamNewss(int size);

	public List<TeamNews> queryNewByTeamAndType(int teamId, int type);
	
	public List<TeamNews> queryNewByTeamAndType(int size,int teamId, int type);

	public List<TeamNews> queryPagedNewByTeamAndType(PagedTool pagedTool, int teamId, int type);

	public int updateTeamNews(TeamNews teamNews);

}
