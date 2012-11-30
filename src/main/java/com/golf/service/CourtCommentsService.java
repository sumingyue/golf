package com.golf.service;

import java.util.List;

import com.golf.entity.CourtComments;
import com.golf.tools.PagedTool;

public interface CourtCommentsService {

	public List<CourtComments> queryAllCourtCommentss(int courtId);

	public int insertCourtComments(CourtComments courtComments);

	public int updateCourtComments(CourtComments courtComments);

	public int deleteCourtComments(int courtCommentsId);

	public CourtComments findCourtComments(int courtCommentsId);

	public List<CourtComments> queryPagedCourtCommentss(PagedTool pagedTool, int courtId);

}
