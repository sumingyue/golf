package com.golf.service;

import java.util.List;

import com.golf.entity.TeamMemberImage;
import com.golf.tools.PagedTool;

public interface TeamMemberImageService {

	public List<TeamMemberImage> queryAllTeamMemberImages(int teamId);

	public int insertTeamMemberImage(TeamMemberImage teamImage);

	public int updateTeamMemberImage(TeamMemberImage teamImage);

	public int deleteTeamMemberImage(int teamImageId);

	public TeamMemberImage findTeamMemberImage(int teamImageId);

	public List<TeamMemberImage> queryPagedTeamMemberImages(PagedTool pagedTool, int teamId);

}
