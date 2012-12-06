package com.golf.service;

import java.util.List;

import com.golf.entity.SpecialNews;
import com.golf.tools.PagedTool;

public interface SpecialNewsService {

	public List<SpecialNews> queryAllSpecialNewss();

	public int insertSpecialNews(SpecialNews specialNews);

	public int updateSpecialNews(SpecialNews specialNews);

	public int deleteSpecialNews(int specialNewsId);

	public SpecialNews findSpecialNews(int specialNewsId);

	public List<SpecialNews> queryPagedSpecialNewss(PagedTool pagedTool);

	public List<SpecialNews> queryLastestSpecialNews(int size);

}
