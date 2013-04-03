package com.golf.service;

import java.util.List;

import com.golf.entity.SpecialNews;
import com.golf.tools.PagedTool;

public interface SpecialNewsService {

	public int deleteSpecialNews(int specialNewsId);

	public SpecialNews findSpecialNews(int specialNewsId);

	public int insertSpecialNews(SpecialNews specialNews);

	public List<SpecialNews> queryAllSpecialNewss();

	public List<SpecialNews> queryLastestSpecialNews(int size);

	public List<SpecialNews> queryPagedSpecialNewss(PagedTool pagedTool);

	public int updateSpecialNews(SpecialNews specialNews);

}
