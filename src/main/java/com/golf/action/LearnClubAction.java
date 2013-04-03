package com.golf.action;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.golf.Config;
import com.golf.entity.LearnClub;
import com.golf.entity.Image;
import com.golf.entity.UploadFile;
import com.golf.service.LearnClubService;
import com.golf.service.ImageService;
import com.golf.tools.ImageTools;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class LearnClubAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(LearnClubAction.class);
	
	private static final String LIST="learnClubList.do";

	private List<LearnClub> m_learnClubs;

	private int m_learnClubId;

	private LearnClubService m_learnClubService;

	private LearnClub m_learnClub = new LearnClub();

	private ImageService m_imageService;

	private UploadFile m_uploadFile = new UploadFile();

	private File m_upload;

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public String getActionList(){
		return LIST;
	}

	public LearnClub getLearnClub() {
		return m_learnClub;
	}

	public List<LearnClub> getLearnClubs() {
		return m_learnClubs;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	private int insertLearnClubImage() {
		String fileName = m_uploadFile.getFilename();
		String relativePath = Config.IMAGE_PATH + ImageTools.getImageStorePath(fileName, "_normal", Image.COURT);
		String storePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + relativePath;

		String compressRelativePath = Config.IMAGE_PATH + ImageTools.getImageStorePath(fileName, "_small", Image.COURT);
		String compressStorePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + compressRelativePath;

		String originalPath = ImageTools.getOriginalPath(fileName, Image.LEARN);
		m_uploadFile.setOriginalPath(originalPath);

		m_uploadFile.setPath(relativePath);
		m_uploadFile.setStorePath(storePath);

		m_uploadFile.setCompressedPath(compressRelativePath);
		m_uploadFile.setCompressedStorePath(compressStorePath);

		return m_imageService.insert(m_upload, m_uploadFile, Image.LEARN, 500, 350, false, 0, 0);
	}

	public String learnClubAddSubmit() {
		try {
			if (m_upload != null) {
				int imageId = insertLearnClubImage();
				m_learnClub.setImageId(imageId);
			}
			int id = m_learnClubService.insertLearnClub(m_learnClub);
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

	public String learnClubDelete() {
		try {
			int count = m_learnClubService.deleteLearnClub(m_learnClubId);
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

	public String learnClubList() {
		try {
			// m_pagedTool.setTotalNumber(m_learnClubService.queryAllLearnClubs().size());
			// m_learnClubs = m_learnClubService.queryPagedLearnClubs(m_pagedTool);
			m_learnClubs = m_learnClubService.queryAllLearnClubs();
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String learnClubUpdate() {
		try {
			m_learnClub = m_learnClubService.findLearnClub(m_learnClubId);
			if(m_learnClub.getImageId()>0){
				m_learnClub.setImage(m_imageService.findImage(m_learnClub.getImageId()));
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String learnClubUpdateSubmit() {
		try {
			if (m_upload != null) {
				int imageId = insertLearnClubImage();
				m_learnClub.setImageId(imageId);
			} else {
				m_learnClub.setImageId(m_learnClubService.findLearnClub(m_learnClub.getId()).getImageId());
			}
			int count = m_learnClubService.updateLearnClub(m_learnClub);
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

	public void setId(int id){
		m_learnClubId = id;
	}

	public void setImageService(ImageService imageService) {
		m_imageService = imageService;
	}

	public void setLearnClub(LearnClub learnClub) {
		m_learnClub = learnClub;
	}

	public void setLearnClubId(int learnClubId) {
		m_learnClubId = learnClubId;
	}

	public void setLearnClubService(LearnClubService learnClubService) {
		m_learnClubService = learnClubService;
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