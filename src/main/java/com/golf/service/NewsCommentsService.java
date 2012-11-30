package com.golf.service;

import java.util.List;

import com.golf.entity.NewsComments;
import com.golf.tools.PagedTool;

public interface NewsCommentsService {

	public List<NewsComments> queryAllNewsCommentss();
	
	public List<NewsComments> queryNewsCommentsByNewsId(int newsId);

	public int insertNewsComments(NewsComments newsComment);

	public int updateNewsComments(NewsComments newsComment);

	public int deleteNewsComments(int newsCommentId);

	public NewsComments findNewsComments(int newsCommentId);

	public List<NewsComments> queryPagedNewsCommentss(PagedTool pagedTool);

}
