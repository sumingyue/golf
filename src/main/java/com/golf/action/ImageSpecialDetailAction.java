package com.golf.action;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.golf.Config;
import com.golf.entity.ImageSpecial;
import com.golf.entity.ImageSpecialDetail;
import com.golf.entity.Image;
import com.golf.entity.UploadFile;
import com.golf.service.ImageSpecialDetailService;
import com.golf.service.ImageSpecialService;
import com.golf.service.ImageService;
import com.golf.tools.ImageTools;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class ImageSpecialDetailAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(ImageSpecialDetailAction.class);

	private List<ImageSpecialDetail> m_imageSpecialDetails;

	private int m_imageSpecialDetailId;

	private ImageSpecialService m_imageSpecialService;

	private List<ImageSpecial> m_imageSpecials;

	private int m_imageSpecialId;

	private ImageSpecialDetailService m_imageSpecialDetailService;

	private ImageSpecialDetail m_imageSpecialDetail = new ImageSpecialDetail();

	private ImageService m_imageService;

	private UploadFile m_uploadFile = new UploadFile();

	private File m_upload;
	
	private PagedTool m_pagedTool = new PagedTool(Config.NEWS_PAGED_NUMBER);

	private int insertImage() {
		String fileName = m_uploadFile.getFilename();
		String relativePath = Config.IMAGE_PATH + ImageTools.getImageStorePath(fileName, "_normal", Image.PIC);
		String storePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + relativePath;

		String compressRelativePath = Config.IMAGE_PATH + ImageTools.getImageStorePath(fileName, "_small", Image.PIC);
		String compressStorePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + compressRelativePath;

		String originalPath = ImageTools.getOriginalPath(fileName, Image.PIC);
		m_uploadFile.setOriginalPath(originalPath);

		m_uploadFile.setPath(relativePath);
		m_uploadFile.setStorePath(storePath);

		m_uploadFile.setCompressedPath(compressRelativePath);
		m_uploadFile.setCompressedStorePath(compressStorePath);

		return m_imageService.insert(m_upload, m_uploadFile, Image.PIC, Image.PIC_WIDTH, Image.PIC_HEIGHT, true,Image.PIC_WIDTH,Image.PIC_HEIGHT);

	}
	
	public String imageSpecialDetailList() {
		try {
			m_imageSpecials = m_imageSpecialService.queryAllImageSpecials();
			
			int totalSize = m_imageSpecialDetailService.queryAllImageSpecialDetails(m_imageSpecialId).size();

			m_pagedTool.setTotalNumber(totalSize);
			
			m_imageSpecialDetails = m_imageSpecialDetailService.queryPagedImageSpecialDetails(m_pagedTool,m_imageSpecialId);
			
			//m_imageSpecialDetails = m_imageSpecialDetailService.queryAllImageSpecialDetails(m_imageSpecialId);
			
			for(ImageSpecialDetail temp:m_imageSpecialDetails){
				temp.setImage(m_imageService.findImage(temp.getImageId()));
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String imageSpecialDetailAdd() {
		m_imageSpecials = m_imageSpecialService.queryAllImageSpecials();
		return SUCCESS;
	}

	public String imageSpecialDetailAddSubmit() {
		try {
			if (m_upload != null) {
				int imageId = insertImage();
				m_imageSpecialDetail.setImageId(imageId);
			}
			int id = m_imageSpecialDetailService.insertImageSpecialDetail(m_imageSpecialDetail);
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

	public String imageSpecialDetailUpdate() {
		m_imageSpecials = m_imageSpecialService.queryAllImageSpecials();
		try {
			m_imageSpecialDetail = m_imageSpecialDetailService.findImageSpecialDetail(m_imageSpecialDetailId);
			m_imageSpecialDetail.setImage(m_imageService.findImage(m_imageSpecialDetail.getImageId()));
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String imageSpecialDetailUpdateSubmit() {
		try {
			if (m_upload != null) {
				int imageId = insertImage();
				m_imageSpecialDetail.setImageId(imageId);
			} else {
				m_imageSpecialDetail.setImageId(m_imageSpecialDetailService.findImageSpecialDetail(m_imageSpecialDetail.getId()).getImageId());
			}
			int count = m_imageSpecialDetailService.updateImageSpecialDetail(m_imageSpecialDetail);
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

	public String imageSpecialDetailDelete() {
		try {
			int count = m_imageSpecialDetailService.deleteImageSpecialDetail(m_imageSpecialDetailId);
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

	public ImageSpecialDetail getImageSpecialDetail() {
		return m_imageSpecialDetail;
	}

	public void setImageSpecialDetail(ImageSpecialDetail imageSpecialDetail) {
		m_imageSpecialDetail = imageSpecialDetail;
	}

	public void setImageSpecialDetailService(ImageSpecialDetailService imageSpecialDetailService) {
		m_imageSpecialDetailService = imageSpecialDetailService;
	}

	public List<ImageSpecialDetail> getImageSpecialDetails() {
		return m_imageSpecialDetails;
	}

	public void setImageSpecialDetailId(int imageSpecialDetailId) {
		m_imageSpecialDetailId = imageSpecialDetailId;
	}

	public List<ImageSpecial> getImageSpecials() {
		return m_imageSpecials;
	}

	public void setImageSpecialService(ImageSpecialService imageSpecialService) {
		m_imageSpecialService = imageSpecialService;
	}

	public int getImageSpecialId() {
		return m_imageSpecialId;
	}

	public void setImageSpecialId(int imageSpecialId) {
		m_imageSpecialId = imageSpecialId;
	}

	public void setUpload(File file) {
		m_upload = file;
	}

	public void setUploadFileName(String filename) {
		m_uploadFile.setFilename(filename);
	}

	public void setUploadContentType(String contentType) {
		m_uploadFile.setContentType(contentType);
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}
	
}