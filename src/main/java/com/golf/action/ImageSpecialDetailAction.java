package com.golf.action;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.ImageSpecial;
import com.golf.entity.ImageSpecialDetail;
import com.golf.entity.ImageType;
import com.golf.entity.UploadFile;
import com.golf.service.ImageService;
import com.golf.service.ImageSpecialDetailService;
import com.golf.service.ImageSpecialService;
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
	
	private int m_size = 10;
	
	private UploadFile[] m_uploadFiles = new UploadFile[m_size];

	private File[] m_uploads = new File[m_size];

	private String[] m_des = new String[m_size];
	
	private PagedTool m_pagedTool = new PagedTool(Config.NEWS_PAGED_NUMBER);

	public ImageSpecialDetail getImageSpecialDetail() {
		return m_imageSpecialDetail;
	}
	
	public List<ImageSpecialDetail> getImageSpecialDetails() {
		return m_imageSpecialDetails;
	}

	public int getImageSpecialId() {
		return m_imageSpecialId;
	}

	public List<ImageSpecial> getImageSpecials() {
		return m_imageSpecials;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public String imageSpecialDetailAdd() {
		m_imageSpecials = m_imageSpecialService.queryAllImageSpecials();
		return SUCCESS;
	}

	public String imageSpecialDetailAddSubmit() {
		int size = m_uploads.length;

		String result = SUCCESS;

		for (int i = 0; i < size; i++) {
			try {
				ImageSpecialDetail temp = new ImageSpecialDetail();
				File file = m_uploads[i];

				if (file != null) {
					String des = "";
					if (m_des.length < i) {
						des = "";
					} else {
						des = m_des[i];
					}
					int imageId = insertImage(file,m_uploadFiles[i]);
					temp.setImageSpecialId(m_imageSpecialDetail.getImageSpecialId());
					temp.setImageDes(des);
					temp.setImageId(imageId);
					
					int id =m_imageSpecialDetailService.insertImageSpecialDetail(temp);
					
					if (id <= 0) {
						result = ERROR;
					}
				}
			} catch (Exception e) {
				m_logger.error(e);
				result = ERROR;
			}
		}
		return result;
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

	public String imageSpecialDetailList() {
		try {
//			m_imageSpecials = m_imageSpecialService.queryAllImageSpecials();
//			
//			int totalSize = m_imageSpecialDetailService.queryAllImageSpecialDetails(m_imageSpecialId).size();
//
//			m_pagedTool.setTotalNumber(totalSize);
//			
//			m_imageSpecialDetails = m_imageSpecialDetailService.queryPagedImageSpecialDetails(m_pagedTool,m_imageSpecialId);
			
			m_imageSpecialDetails = m_imageSpecialDetailService.queryAllImageSpecialDetails(0);
			
			for(ImageSpecialDetail temp:m_imageSpecialDetails){
				temp.setImage(m_imageService.findImage(temp.getImageId()));
				temp.setImageSpecial(m_imageSpecialService.findImageSpecial(temp.getImageSpecialId()));
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
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
				int imageId = insertImage(m_upload,m_uploadFile);
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

	private int insertImage(File m_upload,UploadFile m_uploadFile) {
		return m_imageService.insert(m_upload, m_uploadFile, ImageType.PIC);
	}

	public void setDes(String[] des) {
		m_des = des;
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public void setImageSpecialDetail(ImageSpecialDetail imageSpecialDetail) {
		m_imageSpecialDetail = imageSpecialDetail;
	}

	public void setImageSpecialDetailId(int imageSpecialDetailId) {
		m_imageSpecialDetailId = imageSpecialDetailId;
	}

	public void setImageSpecialDetailService(ImageSpecialDetailService imageSpecialDetailService) {
		m_imageSpecialDetailService = imageSpecialDetailService;
	}

	public void setImageSpecialId(int imageSpecialId) {
		m_imageSpecialId = imageSpecialId;
	}

	public void setImageSpecialService(ImageSpecialService imageSpecialService) {
		m_imageSpecialService = imageSpecialService;
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}

	public void setUpload(File file) {
		m_upload = file;
	}

	public void setUploadContentType(String contentType) {
		m_uploadFile.setContentType(contentType);
	}
	
	public void setUploadFileName(String filename) {
		m_uploadFile.setFilename(filename);
	}

	public void setUploads(File[] uploads) {
		m_uploads = uploads;
	}
	
	public void setUploadsContentType(String contentType) {
		String[] contentTypes = contentType.split(",");
		for(int i=0;i<contentTypes.length;i++){
			UploadFile upload = m_uploadFiles[i];
			if(upload==null){
				upload =new UploadFile();
				m_uploadFiles[i]= upload;
			}
			m_uploadFiles[i].setContentType(contentTypes[i]);
		}
	}

	public void setUploadsFileName(String filename) {
		String[] fileNames = filename.split(",");
		for(int i=0;i<fileNames.length;i++){
			UploadFile upload = m_uploadFiles[i];
			if(upload==null){
				upload =new UploadFile();
				m_uploadFiles[i]= upload;
			}
			m_uploadFiles[i].setFilename(fileNames[i]);
		}
	}

}