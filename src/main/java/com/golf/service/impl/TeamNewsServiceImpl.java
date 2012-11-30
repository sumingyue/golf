package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.TeamNewsDao;
import com.golf.entity.TeamNews;
import com.golf.service.TeamNewsService;
import com.golf.tools.PagedTool;

public class TeamNewsServiceImpl implements InitializingBean, TeamNewsService {

	private TeamNewsDao m_teamNewsDao;

	private Map<Integer, TeamNews> m_teamNewss = new LinkedHashMap<Integer, TeamNews>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<TeamNews> categories = m_teamNewsDao.findAllTeamNews();

		for (TeamNews teamNews : categories) {
			m_teamNewss.put(teamNews.getId(), teamNews);
		}
	}

	@Override
	public List<TeamNews> queryAllTeamNewss() {
		ArrayList<TeamNews> arrayList = new ArrayList<TeamNews>(m_teamNewss.values());

		Collections.sort(arrayList, new TeamNewsCompartor());
		return arrayList;
	}

	@Override
	public int insertTeamNews(TeamNews teamNews) {
		int id = m_teamNewsDao.insert(teamNews);
		if (id > 0) {
			m_teamNewss.put(teamNews.getId(), teamNews);
		}
		return id;
	}

	@Override
	public int updateTeamNews(TeamNews teamNews) {
		int id = m_teamNewsDao.update(teamNews);
		if (id > 0) {
			m_teamNewss.put(teamNews.getId(), teamNews);
		}
		return id;
	}

	@Override
	public int deleteTeamNews(int teamNewsId) {
		int id = m_teamNewsDao.delete(teamNewsId);
		if (id > 0) {
			m_teamNewss.remove(teamNewsId);
		}
		return id;
	}

	@Override
	public TeamNews findTeamNews(int teamNewsId) {
		TeamNews teamNews = m_teamNewss.get(teamNewsId);
		if (teamNews == null) {
			TeamNews temp = m_teamNewsDao.findById(teamNewsId);
			if (temp != null) {
				m_teamNewss.put(teamNewsId, temp);
			}
			return temp;
		}
		return teamNews;
	}

	public void setTeamNewsDao(TeamNewsDao teamNewsDao) {
		m_teamNewsDao = teamNewsDao;
	}

	@Override
	public List<TeamNews> queryNewByTeamAndType(int teamId, int type) {
		List<TeamNews> result = new ArrayList<TeamNews>();
		List<TeamNews> all = queryAllTeamNewss();

		if (teamId == 0) {
			for (TeamNews temp : all) {
				if (temp.getType() == type || type == 0) {
					result.add(temp);
				}
			}
		} else {
			for (TeamNews temp : all) {
				if (temp.getTeamId() == teamId) {
					if (temp.getType() == type || type == 0) {
						result.add(temp);
					}
				}
			}
		}
		return result;
	}

	@Override
	public List<TeamNews> queryNewByTeamAndType(int size, int teamId, int type) {
		List<TeamNews> all = queryNewByTeamAndType(teamId, type);
		int totalSize = all.size();

		if (size < totalSize) {
			return all.subList(0, size);
		}
		return all;
	}

	public static class TeamNewsCompartor implements Comparator<TeamNews> {

		@Override
		public int compare(TeamNews o1, TeamNews o2) {
			return o2.getId() - o1.getId();
		}
	}

	@Override
	public List<TeamNews> queryPagedNewByTeamAndType(PagedTool pagedTool, int teamId, int type) {
		List<TeamNews> result = queryNewByTeamAndType(teamId, type);
		return result.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());

	}
}
