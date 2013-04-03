package com.golf.service;

import java.util.List;

import com.golf.entity.TeamMemberImage;
import com.golf.tools.PagedTool;

public interface TeamMemberImageService {

	public int deleteTeamMemberImage(int teamImageId);

	public TeamMemberImage findTeamMemberImage(int teamImageId);

	public int insertTeamMemberImage(TeamMemberImage teamImage);

	public List<TeamMemberImage> queryAllTeamMemberImages(int teamId);

	public List<TeamMemberImage> queryPagedTeamMemberImages(PagedTool pagedTool, int teamId);

	public int updateTeamMemberImage(TeamMemberImage teamImage);

}
