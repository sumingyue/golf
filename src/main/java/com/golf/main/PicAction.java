package com.golf.main;

import java.util.List;

import org.apache.log4j.Logger;

import com.golf.entity.ImageSpecial;
import com.golf.entity.ImageSpecialDetail;
import com.golf.service.ImageService;
import com.golf.service.ImageSpecialDetailService;
import com.golf.service.ImageSpecialService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class PicAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(PicAction.class);

	private List<ImageSpecial> m_imageSpecials;

	private List<ImageSpecialDetail> m_imageSpecialDetails;

	private int m_imageSpecialId;

	private ImageSpecialService m_imageSpecialService;

	private ImageSpecialDetailService m_imageSpecialDetailService;

	private ImageSpecial m_imageSpecial = new ImageSpecial();

	private ImageService m_imageService;
	
	private PagedTool m_pagedTool = new PagedTool(10);

	public String imageSpecialList() {
		try {
			m_imageSpecials = m_imageSpecialService.queryAllImageSpecials();

			for (ImageSpecial temp : m_imageSpecials) {
				temp.setImage(m_imageService.findImage(temp.getImageId()));
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String imageSpecialDetail() {
		m_imageSpecial = m_imageSpecialService.findImageSpecial(m_imageSpecialId);
		m_imageSpecialDetails = m_imageSpecialDetailService.queryPagedImageSpecialDetails(m_pagedTool, m_imageSpecialId);
		
		for(ImageSpecialDetail detail : m_imageSpecialDetails){
			detail.setImage(m_imageService.findImage(detail.getImageId()));
		}
		return SUCCESS;
	}

	public ImageSpecial getImageSpecial() {
		return m_imageSpecial;
	}

	public void setImageSpecial(ImageSpecial imageSpecial) {
		m_imageSpecial = imageSpecial;
	}

	public void setImageSpecialService(ImageSpecialService imageSpecialService) {
		m_imageSpecialService = imageSpecialService;
	}

	public List<ImageSpecial> getImageSpecials() {
		return m_imageSpecials;
	}

	public void setImageSpecialId(int imageSpecialId) {
		m_imageSpecialId = imageSpecialId;
	}

	public void setId(int imageSpecialId) {
		m_imageSpecialId = imageSpecialId;
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public List<ImageSpecialDetail> getImageSpecialDetails() {
		return m_imageSpecialDetails;
	}

	public void setImageSpecialDetailService(ImageSpecialDetailService imageSpecialDetailService) {
		m_imageSpecialDetailService = imageSpecialDetailService;
	}

}