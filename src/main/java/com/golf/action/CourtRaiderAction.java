package com.golf.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.Court;
import com.golf.entity.CourtRaider;
import com.golf.entity.ImageType;
import com.golf.entity.UploadFile;
import com.golf.service.CourtRaiderService;
import com.golf.service.CourtService;
import com.golf.service.ImageService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class CourtRaiderAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(CourtRaiderAction.class);

	private List<CourtRaider> m_courtRaiders;

	private int m_courtRaiderId;

	private int m_courtId;

	private CourtService m_courtService;

	private List<Court> m_courts;

	private CourtRaiderService m_courtRaiderService;

	private CourtRaider m_courtRaider = new CourtRaider();

	private ImageService m_imageService;

	private UploadFile m_uploadFile = new UploadFile();

	private File m_upload;

	private File[] m_uploads = new File[10];

	private UploadFile[] m_uploadFiles = new UploadFile[10];

	private String[] m_des = new String[10];

	private String[] m_indicator1 = new String[10];

	private String[] m_indicator2 = new String[10];

	private String[] m_indicator3 = new String[10];

	private String[] m_indicator4 = new String[10];

	private String[] m_indicator5 = new String[10];

	private String[] m_typeIndex = new String[10];

	private String[] m_name = new String[10];

	private List<String> m_flags = new ArrayList<String>();

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public String courtRaiderAdd() {
		for (int i = 0; i < 10; i++) {
			m_flags.add("");
		}
		m_courts = m_courtService.queryAllCourts();
		return SUCCESS;
	}

	public String courtRaiderAddSubmit() {
		int size = m_uploads.length;

		System.out.println(size+"#######");
		String result = SUCCESS;

		for (int i = 0; i < size; i++) {
			try {
				CourtRaider temp = new CourtRaider();
				File file = m_uploads[i];

				if (file != null) {
					String des = "";
					String index = "";
					if (m_des.length < i) {
						des = "";
					} else {
						des = m_des[i];
					}
					if (m_typeIndex.length < i) {
						index = "";
					} else {
						index = m_typeIndex[i];
					}
					System.out.println(m_typeIndex);
					int imageId = insertImage(file, m_uploadFiles[i]);
					temp.setCourtId(m_courtRaider.getCourtId());
					temp.setType(m_courtRaider.getType());
					temp.setDes(des);
					temp.setImageId(imageId);
					temp.setName(m_name[i]);
					temp.setTypeIndex(index);
					temp.setIndicator1(Integer.parseInt(m_indicator1[i]));
					temp.setIndicator2(Integer.parseInt(m_indicator2[i]));
					temp.setIndicator3(Integer.parseInt(m_indicator3[i]));
					temp.setIndicator4(Integer.parseInt(m_indicator4[i]));
					temp.setIndicator5(Integer.parseInt(m_indicator5[i]));

					int id = m_courtRaiderService.insertCourtRaider(temp);

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

	public String courtRaiderDelete() {
		try {
			int count = m_courtRaiderService.deleteCourtRaider(m_courtRaiderId);
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

	public String courtRaiderList() {
		try {
			m_courts = m_courtService.queryAllCourts();
			// m_pagedTool.setTotalNumber(m_courtRaiderService.queryAllCourtRaiders(m_courtId).size());
			// m_courtRaiders = m_courtRaiderService.queryPagedCourtRaiders(m_pagedTool, m_courtId);
			m_courtRaiders = m_courtRaiderService.queryAllCourtRaiders(0);
			for (CourtRaider temp : m_courtRaiders) {
				temp.setCourt(m_courtService.findCourt(temp.getCourtId()));
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String courtRaiderUpdate() {
		try {
			m_courts = m_courtService.queryAllCourts();
			m_courtRaider = m_courtRaiderService.findCourtRaider(m_courtRaiderId);
			if (m_courtRaider != null) {
				m_courtRaider.setImage(m_imageService.findImage(m_courtRaider.getImageId()));
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String courtRaiderUpdateSubmit() {
		try {
			if (m_upload != null) {
				int imageId = insertImage(m_upload, m_uploadFile);
				m_courtRaider.setImageId(imageId);
			} else {
				m_courtRaider.setImageId(m_courtRaiderService.findCourtRaider(m_courtRaider.getId()).getImageId());
			}
			int count = m_courtRaiderService.updateCourtRaider(m_courtRaider);
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

	public int getCourtId() {
		return m_courtId;
	}

	public CourtRaider getCourtRaider() {
		return m_courtRaider;
	}

	public List<CourtRaider> getCourtRaiders() {
		return m_courtRaiders;
	}

	public List<Court> getCourts() {
		return m_courts;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	private int insertImage(File m_upload, UploadFile m_uploadFile) {
		return m_imageService.insert(m_upload, m_uploadFile, ImageType.COURT);
	}

	public void setCourtId(int courtId) {
		m_courtId = courtId;
	}

	public void setCourtRaider(CourtRaider courtRaider) {
		m_courtRaider = courtRaider;
	}

	public void setCourtRaiderId(int courtRaiderId) {
		m_courtRaiderId = courtRaiderId;
	}

	public void setCourtRaiderService(CourtRaiderService courtRaiderService) {
		m_courtRaiderService = courtRaiderService;
	}

	public void setCourtService(CourtService courtService) {
		m_courtService = courtService;
	}

	public void setDes(String[] des) {
		m_des = des;
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public void setIndex(int index) {
		m_pagedTool.setPageIndex(index);
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

	public void setUploadFiles(UploadFile[] uploadFiles) {
		m_uploadFiles = uploadFiles;
	}

	public void setUploads(File[] uploads) {
		m_uploads = uploads;
	}

	public void setUploadsContentType(String contentType) {
		String[] contentTypes = contentType.split(",");
		for (int i = 0; i < contentTypes.length; i++) {
			UploadFile upload = m_uploadFiles[i];
			if (upload == null) {
				upload = new UploadFile();
				m_uploadFiles[i] = upload;
			}
			m_uploadFiles[i].setContentType(contentTypes[i]);
		}
	}

	public void setUploadsFileName(String filename) {
		String[] fileNames = filename.split(",");
		for (int i = 0; i < fileNames.length; i++) {
			UploadFile upload = m_uploadFiles[i];
			if (upload == null) {
				upload = new UploadFile();
				m_uploadFiles[i] = upload;
			}
			m_uploadFiles[i].setFilename(fileNames[i]);
		}
	}

	public void setIndicator1(String[] indicator1) {
		m_indicator1 = indicator1;
	}

	public void setIndicator2(String[] indicator2) {
		m_indicator2 = indicator2;
	}

	public void setIndicator3(String[] indicator3) {
		m_indicator3 = indicator3;
	}

	public void setIndicator4(String[] indicator4) {
		m_indicator4 = indicator4;
	}

	public void setIndicator5(String[] indicator5) {
		m_indicator5 = indicator5;
	}

	public void setName(String[] name) {
		m_name = name;
	}

	public List<String> getFlags() {
		return m_flags;
	}

	public void setFlags(List<String> flags) {
		m_flags = flags;
	}

	public void setTypeIndex(String[] typeIndex) {
		m_typeIndex = typeIndex;
	}

}