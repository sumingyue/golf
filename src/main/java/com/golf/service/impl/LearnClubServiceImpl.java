package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.LearnClubDao;
import com.golf.entity.LearnClub;
import com.golf.service.LearnClubService;

public class LearnClubServiceImpl implements InitializingBean, LearnClubService {

	private LearnClubDao m_learnClubDao;

	private Map<Integer, LearnClub> m_learnClubs = new LinkedHashMap<Integer, LearnClub>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<LearnClub> categories = m_learnClubDao.findAllLearnClub();

		for (LearnClub learnClub : categories) {
			m_learnClubs.put(learnClub.getId(), learnClub);
		}
	}

	@Override
	public int deleteLearnClub(int learnClubId) {
		int id = m_learnClubDao.delete(learnClubId);
		if (id > 0) {
			m_learnClubs.remove(learnClubId);
		}
		return id;
	}

	@Override
	public LearnClub findLearnClub(int learnClubId) {
		LearnClub learnClub = m_learnClubs.get(learnClubId);
		if (learnClub == null) {
			learnClub = m_learnClubDao.findById(learnClubId);
			if (learnClub != null) {
				m_learnClubs.put(learnClubId, learnClub);
			}
		}
		return learnClub;
	}

	@Override
	public int insertLearnClub(LearnClub learnClub) {
		int id = m_learnClubDao.insert(learnClub);
		if (id > 0) {
			m_learnClubs.put(learnClub.getId(), learnClub);
		}
		return id;
	}

	@Override
	public List<LearnClub> queryAllLearnClubs() {
		ArrayList<LearnClub> arrayList = new ArrayList<LearnClub>(m_learnClubs.values());
		Collections.sort(arrayList, new LearnClubCompartor());
		return arrayList;
	}

	public void setLearnClubDao(LearnClubDao learnClubDao) {
		m_learnClubDao = learnClubDao;
	}

	@Override
	public int updateLearnClub(LearnClub learnClub) {
		int id = m_learnClubDao.update(learnClub);
		if (id > 0) {
			m_learnClubs.put(learnClub.getId(), learnClub);
		}
		return id;
	}

	public static class LearnClubCompartor implements Comparator<LearnClub> {

		@Override
		public int compare(LearnClub o1, LearnClub o2) {
			return o2.getId() - o1.getId();
		}
	}

}
