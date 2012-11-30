package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.MediaDao;
import com.golf.entity.Media;
import com.golf.service.MediaService;
import com.golf.tools.PagedTool;

public class MediaServiceImpl implements InitializingBean, MediaService {

	private MediaDao m_mediaDao;

	private Map<Integer, Media> m_medias = new LinkedHashMap<Integer, Media>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<Media> categories = m_mediaDao.findAllMedia();

		for (Media media : categories) {
			m_medias.put(media.getId(), media);
		}
	}

	@Override
	public List<Media> queryAllMedias() {
		ArrayList<Media> arrayList = new ArrayList<Media>(m_medias.values());
		Collections.sort(arrayList, new MediaCompartor());
		return arrayList;
	}

	@Override
	public int insertMedia(Media media) {
		int id = m_mediaDao.insert(media);
		if (id > 0) {
			m_medias.put(media.getId(), media);
		}
		return id;
	}

	@Override
	public int updateMedia(Media media) {
		int id = m_mediaDao.update(media);
		if (id > 0) {
			m_medias.put(media.getId(), media);
		}
		return id;
	}

	@Override
	public int deleteMedia(int mediaId) {
		int id = m_mediaDao.delete(mediaId);
		if (id > 0) {
			m_medias.remove(mediaId);
		}
		return id;
	}

	@Override
	public Media findMedia(int mediaId) {
		Media media = m_medias.get(mediaId);
		if (media == null) {
			media = m_mediaDao.findById(mediaId);
			if (media != null) {
				m_medias.put(mediaId, media);
			}
		}
		return media;
	}

	public void setMediaDao(MediaDao mediaDao) {
		m_mediaDao = mediaDao;
	}

	public static class MediaCompartor implements Comparator<Media> {

		@Override
		public int compare(Media o1, Media o2) {
			return o2.getId() - o1.getId();
		}

	}

	@Override
	public List<Media> queryPagedMedias(PagedTool pagedTool) {
		List<Media> result = queryAllMedias();
		return result.subList(pagedTool.getFromIndex(), pagedTool.getToIndex());

	}

}
