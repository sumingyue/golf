package com.golf.service;

import java.util.List;

import com.golf.entity.TeamNews;
import com.golf.tools.PagedTool;

public interface TeamNewsService {

	public List<TeamNews> queryAllTeamNewss();

	public int insertTeamNews(TeamNews teamNews);

	public int updateTeamNews(TeamNews teamNews);

	public int deleteTeamNews(int teamNewsId);

	public TeamNews findTeamNews(int teamNewsId);

	public List<TeamNews> queryNewByTeamAndType(int teamId, int type);
	
	public List<TeamNews> queryNewByTeamAndType(int size,int teamId, int type);

	public List<TeamNews> queryPagedNewByTeamAndType(PagedTool pagedTool, int teamId, int type);

}
