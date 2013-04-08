package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.NewsDao;
import com.golf.entity.Category;
import com.golf.entity.News;
import com.golf.entity.SmallCategory;
import com.golf.service.CategoryService;
import com.golf.service.NewsService;
import com.golf.tools.PagedTool;

public class NewsServiceImpl implements NewsService, InitializingBean {

	private NewsDao m_newsDao;

	private CategoryService m_categoryService;

	private Map<Integer, News> m_news = new LinkedHashMap<Integer, News>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<News> all = m_newsDao.findAllNews();

		for (News temp : all) {
			cacheNews(temp);
		}

	}

	private void cacheNews(News temp) {
		Category category = m_categoryService.findCategory(temp.getCategoryId());
		SmallCategory smallCategory = m_categoryService.findSmallCategory(temp.getSmallCategoryId());
		temp.setCategory(category);
		temp.setSmallCategory(smallCategory);
		m_news.put(temp.getId(), temp);
	}

	@Override
	public int deleteNews(int newsId) {
		int count = m_newsDao.delete(newsId);
		if (count > 0) {
			m_news.remove(newsId);
		}
		return count;
	}

	@Override
	public News findNews(int newsId) {
		News temp = m_news.get(newsId);
		if (temp == null) {
			temp = m_newsDao.findById(newsId);
		}
		if (temp != null) {
			m_news.put(temp.getId(), temp);
		}
		return temp;
	}

	@Override
	public int increaseVisiteNumber(int id, int type) {
		return m_newsDao.update(id, type);
	}

	@Override
	public int insertNews(News news) {
		int id = m_newsDao.insert(news);
		if (id > 0) {
			cacheNews(news);
		}
		return id;
	}

	private List<News> queryAll(int categoryId, int smallCategoryId, int status, int recommand) {
		List<News> result = new ArrayList<News>();
		List<News> all = queryAllNews();
		for (News news : all) {
			if (status > 0) {
				if (news.getStatus() != status) {
					continue;
				}
			}
			if (recommand > 0) {
				if (news.getRecommend() != recommand) {
					continue;
				}
			}
			if (smallCategoryId > 0) {
				if (news.getSmallCategoryId() == smallCategoryId) {
					result.add(news);
				}
			} else if (categoryId > 0) {
				if (news.getCategoryId() == categoryId) {
					result.add(news);
				}
			} else {
				result.add(news);
			}
		}
		return result;
	}

	@Override
	public List<News> queryAllNews() {
		List<News> all = new ArrayList<News>(m_news.values());

		Collections.sort(all, new DefaultNewsCompartor());
		return all;
	}

	private List<News> queryAllShowNews(int categoryId, int smallCategoryId) {
		List<News> all = new ArrayList<News>(m_news.values());
		List<News> result = new ArrayList<News>();
		long current = System.currentTimeMillis();

		for (News temp : all) {
			if (temp.getStatus() > 0 && current > temp.getValidateDate().getTime()) {
				if (smallCategoryId > 0) {
					if (temp.getSmallCategoryId() == smallCategoryId) {
						result.add(temp);
					}
				} else if (categoryId > 0) {
					if (temp.getCategoryId() == categoryId) {
						result.add(temp);
					}
				} else {
					result.add(temp);
				}
			}
		}
		return result;
	}

	@Override
	public List<News> queryFixedImageNews(int size, int categoryId, int smallCategoryId) {
		List<News> all = queryAllShowNews(categoryId, smallCategoryId);
		List<News> result = new ArrayList<News>();

		for (News temp : all) {
			if (temp.getImageId() > 0) {
				result.add(temp);
			}
		}
		Collections.sort(result, new IndexNewsCompartor());

		return resizeList(result, size);
	}

	@Override
	public List<News> queryFixedImageNews(int size, int categoryId) {
		return queryFixedImageNews(size, categoryId, 0);
	}

	@Override
	public List<News> queryFixedLatestNewsByCategoryId(int size, int categoryId) {
		List<News> all = queryAllShowNews(categoryId, 0);
		Collections.sort(all, new DefaultNewsCompartor());

		return resizeList(all, size);

	}

	@Override
	public List<News> queryFixedNewsByCategoryId(int size, int categoryId) {
		List<News> all = queryAllShowNews(categoryId, 0);
		Collections.sort(all, new IndexNewsCompartor());

		return resizeList(all, size);
	}

	@Override
	public List<News> queryFixedNewsBySmallCategoryId(int size, int smallCategoryId) {
		List<News> all = queryAllShowNews(0, smallCategoryId);
		Collections.sort(all, new IndexNewsCompartor());

		return resizeList(all, size);
	}

	@Override
	public List<News> queryHotNewsByCategoryId(int size, int categoryId) {
		List<News> all = queryAllShowNews(categoryId, 0);
		Collections.sort(all, new HotNewsCompartor());

		return resizeList(all, size);
	}

	@Override
	public List<News> queryNewsByKeyWord(String keyword) {
		List<News> all = queryAllShowNews(0, 0);
		List<News> result = new ArrayList<News>();
		for (News temp : all) {
			if (temp.getTitle().indexOf(keyword) > -1 || temp.getKeyword().indexOf(keyword) > -1) {
				result.add(temp);
			}
		}
		Collections.sort(result, new DefaultNewsCompartor());
		return result;
	}

	@Override
	public List<News> queryPagedNews(PagedTool pagedTool, int categoryId, int smallCategoryId) {
		List<News> result = new ArrayList<News>();
		List<News> all = queryAllNews();
		for (News news : all) {
			if (smallCategoryId > 0) {
				if (news.getSmallCategoryId() == smallCategoryId) {
					result.add(news);
				}
			} else if (categoryId > 0) {
				if (news.getCategoryId() == categoryId) {
					result.add(news);
				}
			} else {
				result.add(news);
			}
		}

		return result.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());

	}

	@Override
	public List<News> queryPagedNews(PagedTool pagedTool, int categoryId, int smallCategoryId, int status, int recommand) {
		List<News> result = queryAll(categoryId, smallCategoryId, status, recommand);
		return result.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());
	}

	@Override
	public int queryTotalSize(int categoryId, int smallCategoryId) {
		List<News> result = new ArrayList<News>();
		List<News> all = queryAllNews();
		for (News news : all) {
			if (smallCategoryId > 0) {
				if (news.getSmallCategoryId() == smallCategoryId) {
					result.add(news);
				}
			} else if (categoryId > 0) {
				if (news.getCategoryId() == categoryId) {
					result.add(news);
				}
			} else {
				result.add(news);
			}
		}
		return result.size();
	}

	@Override
	public int queryTotalSize(int categoryId, int smallCategoryId, int status, int recommand) {
		List<News> result = queryAll(categoryId, smallCategoryId, status, recommand);
		return result.size();
	}

	private List<News> resizeList(List<News> all, int size) {
		int totalSize = all.size();
		if (size > totalSize) {
			int duration = size - totalSize;
			for (int i = 0; i < duration; i++) {
				all.add(buildFaultNews());
			}
		} else {
			all = all.subList(0, size);
		}
		return all;
	}

	public void setCategoryService(CategoryService categoryService) {
		m_categoryService = categoryService;
	}

	public void setNewsDao(NewsDao newsDao) {
		m_newsDao = newsDao;
	}

	@Override
	public int updateNews(News news) {
		int count = m_newsDao.update(news);
		if (count > 0) {
			cacheNews(news);
		}
		return count;
	}

	public static class DefaultNewsCompartor implements Comparator<News> {

		@Override
		public int compare(News o1, News o2) {
			return o2.getValidateDate().compareTo(o1.getValidateDate());
		}
	}

	public static class HotNewsCompartor implements Comparator<News> {

		@Override
		public int compare(News o1, News o2) {
			return o2.getViewNumber() - o1.getViewNumber();
		}
	}

	public static class IndexNewsCompartor implements Comparator<News> {
		@Override
		public int compare(News o1, News o2) {
			if (o1.getRecommend() != o2.getRecommend()) {
				return o2.getRecommend() - o1.getRecommend();
			} else {
				if (o1.getPriority() != o2.getPriority()) {
					return o2.getPriority() - o1.getPriority();
				} else {
					return o2.getValidateDate().compareTo(o1.getValidateDate());
				}
			}
		}
	}

	private News buildFaultNews() {
		News result = findNews(16);

		if (result == null) {
			result = new News();
			result.setTitle("this is a default news,please add news in admin console!");
			result.setCreationDate(new Date());
		}
		return result;
	}

}
