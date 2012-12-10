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

	//获取一个大分类下访问量最大的新闻
	public List<News> queryHotNewsByCategoryId(int size,int categoryId);
	//获取图片新闻，带有图片的新闻、排序按照是否首页推荐，优先级、时间
	public List<News> queryFixedImageNewsByCategoryId( int size,int categoryId);
	//获取小分类的新闻
	public List<News> queryFixedNewsBySmallCategoryId(int size, int smallCategoryId);
	//获取大分类的新闻
	public List<News> queryFixedNewsByCategoryId(int size, int categoryId);
	//获取大分类的最新新闻
	public List<News> queryFixedLatestNewsByCategoryId(int i, int categoryId);
	//查询新闻
	public List<News> queryNewsByKeyWord(String keyword);

	public int increaseVisiteNumber(int id,int type);

	public int queryTotalSize(int categoryId, int smallCategoryId, int status, int recommand);

	public List<News> queryPagedNews(PagedTool pagedTool, int categoryId, int smallCategoryId, int status, int recommand);
	
}
