package com.golf.action;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.DrivingRange;
import com.golf.entity.ImageType;
import com.golf.entity.UploadFile;
import com.golf.service.DrivingRangeService;
import com.golf.service.ImageService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class DrivingRangeAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(DrivingRangeAction.class);
	
	private static final String LIST="drivingRangeList.do";

	private List<DrivingRange> m_drivingRanges;

	private int m_drivingRangeId;

	private DrivingRangeService m_drivingRangeService;

	private DrivingRange m_drivingRange = new DrivingRange();

	private ImageService m_imageService;

	private UploadFile m_uploadFile = new UploadFile();

	private File m_upload;

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public String drivingRangeAddSubmit() {
		try {
			if (m_upload != null) {
				int imageId = insertDrivingRangeImage();
				m_drivingRange.setImageId(imageId);
			}
			int id = m_drivingRangeService.insertDrivingRange(m_drivingRange);
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

	public String drivingRangeDelete() {
		try {
			int count = m_drivingRangeService.deleteDrivingRange(m_drivingRangeId);
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

	public String drivingRangeList() {
		try {
			// m_pagedTool.setTotalNumber(m_drivingRangeService.queryAllDrivingRanges().size());
			// m_drivingRanges = m_drivingRangeService.queryPagedDrivingRanges(m_pagedTool);
			m_drivingRanges = m_drivingRangeService.queryAllDrivingRanges();
			
			if(m_drivingRanges!=null){
				for(DrivingRange temp:m_drivingRanges){
					temp.setImage(m_imageService.findImage(temp.getImageId()));
				}
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String drivingRangeUpdate() {
		try {
			m_drivingRange = m_drivingRangeService.findDrivingRange(m_drivingRangeId);
			if(m_drivingRange.getImageId()>0){
				m_drivingRange.setImage(m_imageService.findImage(m_drivingRange.getImageId()));
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String drivingRangeUpdateSubmit() {
		try {
			if (m_upload != null) {
				int imageId = insertDrivingRangeImage();
				m_drivingRange.setImageId(imageId);
			} else {
				m_drivingRange.setImageId(m_drivingRangeService.findDrivingRange(m_drivingRange.getId()).getImageId());
			}
			int count = m_drivingRangeService.updateDrivingRange(m_drivingRange);
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

	public String getActionList(){
		return LIST;
	}

	public DrivingRange getDrivingRange() {
		return m_drivingRange;
	}

	public List<DrivingRange> getDrivingRanges() {
		return m_drivingRanges;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	private int insertDrivingRangeImage() {
		return m_imageService.insert(m_upload, m_uploadFile, ImageType.DRIVINGRANGE);
	}

	public void setDrivingRange(DrivingRange drivingRange) {
		m_drivingRange = drivingRange;
	}

	public void setDrivingRangeId(int drivingRangeId) {
		m_drivingRangeId = drivingRangeId;
	}

	public void setDrivingRangeService(DrivingRangeService drivingRangeService) {
		m_drivingRangeService = drivingRangeService;
	}

	public void setId(int id){
		m_drivingRangeId = id;
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
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
}