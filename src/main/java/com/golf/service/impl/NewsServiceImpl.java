package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.Config;
import com.golf.dao.NewsDao;
import com.golf.entity.Category;
import com.golf.entity.News;
import com.golf.entity.SmallCategory;
import com.golf.service.CategoryService;
import com.golf.service.ImageService;
import com.golf.service.NewsService;
import com.golf.tools.PagedTool;

public class NewsServiceImpl implements NewsService, InitializingBean {

	private NewsDao m_newsDao;

	private CategoryService m_categoryService;

	private Map<Integer, News> m_news = new LinkedHashMap<Integer, News>();

	private ImageService m_imageService;

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<News> all = m_newsDao.findAllNews();

		for (News temp : all) {
			cacheNews(temp);
		}
		
		if (Config.DUBUG) {
			int size = all.size();
			if (size > 1) {
				News temp = all.get(0);
				String name = temp.getTitle();
				int total = Config.DEBUG_TOTAL - size;
				if (total > 0) {
					for (int i = 0; i < total; i++) {
						temp.setTitle(name+i);
						m_news.put(size + i, findNews(27));
					}
				}
			}
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
	public List<News> queryAllNews() {
		List<News> all = new ArrayList<News>(m_news.values());

		for (News temp : all) {
			temp.setImage(m_imageService.findImage(temp.getImageId()));
		}
		Collections.sort(all, new NewsCompartor());
		return all;
	}

	@Override
	public int insertNews(News news) {
		int id = m_newsDao.insert(news);
		if (id > 0) {
			cacheNews(news);
		}
		return id;
	}

	@Override
	public int updateNews(News news) {
		int count = m_newsDao.update(news);
		if (count > 0) {
			cacheNews(news);
		}
		return count;
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
			temp.setImage(m_imageService.findImage(temp.getImageId()));
		}
		return temp;
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

	public void setCategoryService(CategoryService categoryService) {
		m_categoryService = categoryService;
	}

	public void setNewsDao(NewsDao newsDao) {
		m_newsDao = newsDao;
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	@Override
	public List<News> queryNewsBySmallCategoryId(int size, int smallCategoryId) {
		List<News> result = new ArrayList<News>();
		for (int i = 0; i < size; i++) {
			result.add(findNews(27));
		}
		// List<News> all = queryAllNews();
		// for (News temp : all) {
		// if (temp.getSmallCategoryId() == smallCategoryId) {
		// result.add(temp);
		// }
		// }
		// // hack
		// int temp = result.size();
		// if (temp < size) {
		// for (int i = 0; i < size - temp; i++) {
		// result.add(findNews(27));
		// }
		// }
		return result;
	}

	@Override
	public List<News> queryNewsByCategoryId(int size, int categoryId) {

		List<News> result = new ArrayList<News>();
		for (int i = 0; i < size; i++) {
			result.add(findNews(27));
		}
		// List<News> result = new ArrayList<News>();
		// List<News> all = queryAllNews();
		//
		// for (News temp : all) {
		// if (temp.getCategoryId() == categoryId) {
		// result.add(temp);
		// }
		// }
		// // TODO for index page
		// int temp = result.size();
		// if (temp < size) {
		// for (int i = 0; i < size - temp; i++) {
		// result.add(findNews(27));
		// }
		// }
		return result;
	}

	public static class NewsCompartor implements Comparator<News> {

		@Override
		public int compare(News o1, News o2) {
			if (o1.getPriority() != o2.getPriority()) {
				return o2.getId() - o1.getId();
			} else {
				return o2.getPriority() - o1.getPriority();
			}
		}

	}

	@Override
	public List<News> queryHotNews(int size) {
		List<News> result = new ArrayList<News>(size);
		for (int i = 0; i < size; i++) {
			result.add(findNews(27));
		}
		return result;
	}

	@Override
	public List<News> queryImageNewsByCategoryId(int size, int categoryId) {
		List<News> result = new ArrayList<News>(size);
		for (int i = 0; i < size; i++) {
			result.add(findNews(27));
		}
		return result;
	}

	@Override
   public List<News> queryHotNewsByCategoryId(int size, int categoryId) {
		List<News> result = new ArrayList<News>(size);
		for (int i = 0; i < size; i++) {
			result.add(findNews(27));
		}
		return result;
   }
}
