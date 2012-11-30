package com.golf.service;

import java.util.List;

import com.golf.entity.Adwords;
import com.golf.tools.PagedTool;

public interface AdwordsService {

	public List<Adwords> queryAllAdwordss();
	
	public List<Adwords> queryPagedAdwordss(PagedTool tool);
	
	public int insertAdwords(Adwords adwords);

	public int updateAdwords(Adwords adwords);

	public int deleteAdwords(int adwordsId);

	public Adwords findAdwords(int adwordsId);

}
