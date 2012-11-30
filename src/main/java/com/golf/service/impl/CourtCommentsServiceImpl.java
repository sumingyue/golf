package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.CourtCommentsDao;
import com.golf.entity.CourtComments;
import com.golf.service.CourtCommentsService;
import com.golf.tools.PagedTool;

public class CourtCommentsServiceImpl implements InitializingBean, CourtCommentsService {

	private CourtCommentsDao m_courtCommentsDao;

	private Map<Integer, CourtComments> m_courtCommentss = new LinkedHashMap<Integer, CourtComments>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<CourtComments> categories = m_courtCommentsDao.findAllCourtComments();

		for (CourtComments courtComments : categories) {
			m_courtCommentss.put(courtComments.getId(), courtComments);
		}
	}

	@Override
	public List<CourtComments> queryAllCourtCommentss(int courtId) {
		ArrayList<CourtComments> arrayList = new ArrayList<CourtComments>(m_courtCommentss.values());
		List<CourtComments> result = new ArrayList<CourtComments>();

		for (CourtComments temp : arrayList) {
			if (temp.getCourtId() == courtId || courtId == 0) {
				result.add(temp);
			}
		}
		Collections.sort(result, new CourtCommentsCompartor());
		return result;
	}

	@Override
	public int insertCourtComments(CourtComments courtComments) {
		int id = m_courtCommentsDao.insert(courtComments);
		if (id > 0) {
			m_courtCommentss.put(courtComments.getId(), courtComments);
		}
		return id;
	}

	@Override
	public int updateCourtComments(CourtComments courtComments) {
		int id = m_courtCommentsDao.update(courtComments);
		if (id > 0) {
			m_courtCommentss.put(courtComments.getId(), courtComments);
		}
		return id;
	}

	@Override
	public int deleteCourtComments(int courtCommentsId) {
		int id = m_courtCommentsDao.delete(courtCommentsId);
		if (id > 0) {
			m_courtCommentss.remove(courtCommentsId);
		}
		return id;
	}

	@Override
	public CourtComments findCourtComments(int courtCommentsId) {
		CourtComments courtComments = m_courtCommentss.get(courtCommentsId);
		if (courtComments == null) {
			CourtComments temp = m_courtCommentsDao.findById(courtCommentsId);
			if (temp != null) {
				m_courtCommentss.put(courtCommentsId, temp);
			}
			return temp;
		}
		return courtComments;
	}

	public void setCourtCommentsDao(CourtCommentsDao courtCommentsDao) {
		m_courtCommentsDao = courtCommentsDao;
	}

	public static class CourtCommentsCompartor implements Comparator<CourtComments> {

		@Override
		public int compare(CourtComments o1, CourtComments o2) {
			return o2.getId() - o1.getId();
		}

	}

	@Override
	public List<CourtComments> queryPagedCourtCommentss(PagedTool pagedTool, int courtId) {
		List<CourtComments> result = queryAllCourtCommentss(courtId);
		return result.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());
	}

}
