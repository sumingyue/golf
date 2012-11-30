package com.golf.service;

import java.util.List;

import com.golf.entity.News;
import com.golf.tools.PagedTool;

public interface NewsService {

	public List<News> queryAllNews();

	public List<News> queryPagedNews(PagedTool tool, int categoryId, int smallCategoryId);

	public int queryTotalSize(int categoryId, int smallCategoryId);

	public int insertNews(News news);

	public int updateNews(News news);

	public int deleteNews(int newsId);

	public News findNews(int newsId);

	public List<News> queryHotNews(int size);
	
	public List<News> queryHotNewsByCategoryId(int m_size,int categoryId);

	public List<News> queryImageNewsByCategoryId( int size,int categoryId);

	public List<News> queryNewsBySmallCategoryId(int size, int smallCategoryId);

	public List<News> queryNewsByCategoryId(int size, int categoryId);
}
