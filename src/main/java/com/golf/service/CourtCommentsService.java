package com.golf.service;

import java.util.List;

import com.golf.entity.CourtComments;
import com.golf.tools.PagedTool;

public interface CourtCommentsService {

	public int deleteCourtComments(int courtCommentsId);

	public CourtComments findCourtComments(int courtCommentsId);

	public int insertCourtComments(CourtComments courtComments);

	public List<CourtComments> queryAllCourtCommentss(int courtId);

	public List<CourtComments> queryPagedCourtCommentss(PagedTool pagedTool, int courtId);

	public int updateCourtComments(CourtComments courtComments);

}
