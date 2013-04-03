package com.golf.service;

import java.util.List;

import com.golf.entity.Media;
import com.golf.tools.PagedTool;

public interface MediaService {

	public int deleteMedia(int mediaId);

	public Media findMedia(int mediaId);

	public int insertMedia(Media media);

	public List<Media> queryAllMedias();

	public List<Media> queryPagedMedias(PagedTool pagedTool);

	public int updateMedia(Media media);

}
