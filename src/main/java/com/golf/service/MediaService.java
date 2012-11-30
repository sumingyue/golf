package com.golf.service;

import java.util.List;

import com.golf.entity.Media;
import com.golf.tools.PagedTool;

public interface MediaService {

	public List<Media> queryAllMedias();

	public int insertMedia(Media media);

	public int updateMedia(Media media);

	public int deleteMedia(int mediaId);

	public Media findMedia(int mediaId);

	public List<Media> queryPagedMedias(PagedTool pagedTool);

}
