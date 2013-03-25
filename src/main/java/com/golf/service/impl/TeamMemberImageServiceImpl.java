package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.TeamMemberImageDao;
import com.golf.entity.TeamMemberImage;
import com.golf.service.TeamMemberImageService;
import com.golf.tools.PagedTool;

public class TeamMemberImageServiceImpl implements InitializingBean, TeamMemberImageService {

	private TeamMemberImageDao m_teamMemberImageDao;

	private Map<Integer, TeamMemberImage> m_teamMemberImages = new LinkedHashMap<Integer, TeamMemberImage>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<TeamMemberImage> categories = m_teamMemberImageDao.findAllTeamMemberImage();

		for (TeamMemberImage teamMemberImage : categories) {
			m_teamMemberImages.put(teamMemberImage.getId(), teamMemberImage);
		}
	}

	@Override
	public int deleteTeamMemberImage(int teamMemberImageId) {
		int id = m_teamMemberImageDao.delete(teamMemberImageId);
		if (id > 0) {
			m_teamMemberImages.remove(teamMemberImageId);
		}
		return id;
	}

	@Override
	public TeamMemberImage findTeamMemberImage(int teamMemberImageId) {
		TeamMemberImage teamMemberImage = m_teamMemberImages.get(teamMemberImageId);
		if (teamMemberImage == null) {
			TeamMemberImage temp = m_teamMemberImageDao.findById(teamMemberImageId);
			if (temp != null) {
				m_teamMemberImages.put(teamMemberImageId, temp);
			}
			return temp;
		}
		return teamMemberImage;
	}

	@Override
	public int insertTeamMemberImage(TeamMemberImage teamMemberImage) {
		int id = m_teamMemberImageDao.insert(teamMemberImage);
		if (id > 0) {
			m_teamMemberImages.put(teamMemberImage.getId(), teamMemberImage);
		}
		return id;
	}

	@Override
	public List<TeamMemberImage> queryAllTeamMemberImages(int teamId) {
		ArrayList<TeamMemberImage> arrayList = new ArrayList<TeamMemberImage>(m_teamMemberImages.values());
		List<TeamMemberImage> result = new ArrayList<TeamMemberImage>();

		for (TeamMemberImage temp : arrayList) {
			if (temp.getTeamId() == teamId || teamId == 0) {
				result.add(temp);
			}
		}
		Collections.sort(result, new TeamMemberImageCompartor());
		return result;
	}

	@Override
   public List<TeamMemberImage> queryPagedTeamMemberImages(PagedTool pagedTool, int teamId) {
		List<TeamMemberImage> result = queryAllTeamMemberImages(teamId);
		return result.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());

   }

	public void setTeamMemberImageDao(TeamMemberImageDao teamMemberImageDao) {
		m_teamMemberImageDao = teamMemberImageDao;
	}

	@Override
	public int updateTeamMemberImage(TeamMemberImage teamMemberImage) {
		int id = m_teamMemberImageDao.update(teamMemberImage);
		if (id > 0) {
			m_teamMemberImages.put(teamMemberImage.getId(), teamMemberImage);
		}
		return id;
	}

	public static class TeamMemberImageCompartor implements Comparator<TeamMemberImage> {

		@Override
		public int compare(TeamMemberImage o1, TeamMemberImage o2) {
			return 0;
		}

	}

}
