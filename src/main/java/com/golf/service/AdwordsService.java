package com.golf.service;

import java.util.List;

import com.golf.entity.Adwords;
import com.golf.tools.PagedTool;

public interface AdwordsService {

	public int deleteAdwords(int adwordsId);
	
	public Adwords findAdwords(int adwordsId);
	
	public Adwords[] getAdwords();

	public int insertAdwords(Adwords adwords);

	public List<Adwords> queryAllAdwordss();

	public List<Adwords> queryPagedAdwordss(PagedTool tool);

	public int updateAdwords(Adwords adwords);
}
