package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.NewsCommentsDao;
import com.golf.entity.NewsComments;
import com.golf.service.NewsCommentsService;
import com.golf.tools.PagedTool;

public class NewsCommentsServiceImpl implements InitializingBean, NewsCommentsService {

	private NewsCommentsDao m_newsCommentsDao;

	private Map<Integer, NewsComments> m_newsCommentss = new LinkedHashMap<Integer, NewsComments>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<NewsComments> categories = m_newsCommentsDao.findAllNewsComments();

		for (NewsComments newsComments : categories) {
			m_newsCommentss.put(newsComments.getId(), newsComments);
		}
	}

	@Override
	public int deleteNewsComments(int newsCommentsId) {
		int id = m_newsCommentsDao.delete(newsCommentsId);
		if (id > 0) {
			m_newsCommentss.remove(newsCommentsId);
		}
		return id;
	}

	@Override
	public NewsComments findNewsComments(int newsCommentsId) {
		NewsComments newsComments = m_newsCommentss.get(newsCommentsId);
		if (newsComments == null) {
			NewsComments temp = m_newsCommentsDao.findById(newsCommentsId);
			if (temp != null) {
				m_newsCommentss.put(newsCommentsId, temp);
			}
			return temp;
		}
		return newsComments;
	}

	@Override
	public int insertNewsComments(NewsComments newsComments) {
		int id = m_newsCommentsDao.insert(newsComments);
		if (id > 0) {
			m_newsCommentss.put(newsComments.getId(), newsComments);
		}
		return id;
	}

	@Override
	public List<NewsComments> queryAllNewsCommentss() {
		ArrayList<NewsComments> arrayList = new ArrayList<NewsComments>(m_newsCommentss.values());
		Collections.sort(arrayList, new NewsCommentsCompartor());
		return arrayList;
	}

	@Override
	public List<NewsComments> queryNewsCommentsByNewsId(int newsId) {
		ArrayList<NewsComments> arrayList = new ArrayList<NewsComments>(m_newsCommentss.values());
		List<NewsComments> result = new ArrayList<NewsComments>();

		for (NewsComments temp : arrayList) {
			if (temp.getNewsId() == newsId) {
				result.add(temp);
			}
		}

		Collections.sort(result, new NewsCommentsCompartor());
		return result;
	}

	@Override
   public List<NewsComments> queryPagedNewsCommentss(PagedTool pagedTool) {
		List<NewsComments> result = queryAllNewsCommentss();
		return result.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());

   }

	public void setNewsCommentsDao(NewsCommentsDao newsCommentsDao) {
		m_newsCommentsDao = newsCommentsDao;
	}

	@Override
	public int updateNewsComments(NewsComments newsComments) {
		int id = m_newsCommentsDao.update(newsComments);
		if (id > 0) {
			m_newsCommentss.put(newsComments.getId(), newsComments);
		}
		return id;
	}

	public static class NewsCommentsCompartor implements Comparator<NewsComments> {

		@Override
		public int compare(NewsComments o1, NewsComments o2) {
			return o2.getId() - o1.getId();
		}

	}

}
