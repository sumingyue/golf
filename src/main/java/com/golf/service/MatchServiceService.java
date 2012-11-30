package com.golf.service;

import java.util.List;

import com.golf.entity.MatchService;
import com.golf.tools.PagedTool;

public interface MatchServiceService {

	public List<MatchService> queryAllMatchServices();

	public int insertMatchService(MatchService matchService);

	public int updateMatchService(MatchService matchService);

	public int deleteMatchService(int matchServiceId);

	public MatchService findMatchService(int matchServiceId);

	public List<MatchService> queryPagedMatchServices(PagedTool pagedTool);

}
