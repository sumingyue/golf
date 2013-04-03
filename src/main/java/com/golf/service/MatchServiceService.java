package com.golf.service;

import java.util.List;

import com.golf.entity.MatchService;
import com.golf.tools.PagedTool;

public interface MatchServiceService {

	public int deleteMatchService(int matchServiceId);

	public MatchService findMatchService(int matchServiceId);

	public int insertMatchService(MatchService matchService);

	public List<MatchService> queryAllMatchServices();

	public List<MatchService> queryPagedMatchServices(PagedTool pagedTool);

	public int updateMatchService(MatchService matchService);

}
