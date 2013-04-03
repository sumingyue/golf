package com.golf.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.Media;
import com.golf.service.MediaService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class MediaAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(MediaAction.class);

	private List<Media> m_medias;

	private int m_mediaId;

	private MediaService m_mediaService;

	private Media m_media = new Media();

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);
	
	public Media getMedia() {
		return m_media;
	}

	public List<Media> getMedias() {
		return m_medias;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public String mediaAddSubmit() {
		try {
			int id = m_mediaService.insertMedia(m_media);
			if (id > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}

		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public String mediaDelete() {
		try {
			int count = m_mediaService.deleteMedia(m_mediaId);
			if (count > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public String mediaList() {
		try {
			m_pagedTool.setTotalNumber(m_mediaService.queryAllMedias().size());
			m_medias = m_mediaService.queryPagedMedias(m_pagedTool);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String mediaUpdate() {
		try {
			m_media = m_mediaService.findMedia(m_mediaId);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String mediaUpdateSubmit() {
		try {
			int count = m_mediaService.updateMedia(m_media);
			if (count > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public void setIndex(int index){
		m_pagedTool.setPageIndex(index);
	}

	public void setMedia(Media media) {
		m_media = media;
	}
	public void setMediaId(int mediaId) {
		m_mediaId = mediaId;
	}

	public void setMediaService(MediaService mediaService) {
		m_mediaService = mediaService;
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}
}