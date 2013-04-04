package com.golf.action;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.ImageType;
import com.golf.entity.Team;
import com.golf.entity.TeamMemberImage;
import com.golf.entity.UploadFile;
import com.golf.service.ImageService;
import com.golf.service.TeamMemberImageService;
import com.golf.service.TeamService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class TeamMemberImageAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(TeamMemberImageAction.class);

	private List<TeamMemberImage> m_teamMemberImages;

	private int m_teamMemberImageId;

	private TeamService m_teamService;

	private List<Team> m_teams;

	private int m_teamId;

	private TeamMemberImageService m_teamMemberImageService;

	private TeamMemberImage m_teamMemberImage = new TeamMemberImage();

	private ImageService m_imageService;

	private UploadFile m_uploadFile = new UploadFile();

	private File m_upload;

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public int getTeamId() {
		return m_teamId;
	}

	public TeamMemberImage getTeamMemberImage() {
		return m_teamMemberImage;
	}

	public List<TeamMemberImage> getTeamMemberImages() {
		return m_teamMemberImages;
	}

	public List<Team> getTeams() {
		return m_teams;
	}

	private int insertImage() {
		return m_imageService.insert(m_upload, m_uploadFile, ImageType.TEAM);
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

	public void setTeamId(int teamId) {
		m_teamId = teamId;
	}

	public void setTeamMemberImage(TeamMemberImage teamMemberImage) {
		m_teamMemberImage = teamMemberImage;
	}

	public void setTeamMemberImageId(int teamMemberImageId) {
		m_teamMemberImageId = teamMemberImageId;
	}

	public void setTeamMemberImageService(TeamMemberImageService teamMemberImageService) {
		m_teamMemberImageService = teamMemberImageService;
	}

	public void setTeamService(TeamService teamService) {
		m_teamService = teamService;
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

	public String teamMemberImageAdd() {
		m_teams = m_teamService.queryAllTeams();
		return SUCCESS;
	}

	public String teamMemberImageAddSubmit() {
		try {
			if (m_upload != null) {
				int imageId = insertImage();
				m_teamMemberImage.setImageId(imageId);
			}
			int id = m_teamMemberImageService.insertTeamMemberImage(m_teamMemberImage);
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

	public String teamMemberImageDelete() {
		try {
			int count = m_teamMemberImageService.deleteTeamMemberImage(m_teamMemberImageId);
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

	public String teamMemberImageList() {
		try {
			// m_teams = m_teamService.queryAllTeams();
			// m_pagedTool.setTotalNumber(m_teamMemberImageService.queryAllTeamMemberImages(m_teamId).size());
			//
			// m_teamMemberImages = m_teamMemberImageService.queryPagedTeamMemberImages(m_pagedTool, m_teamId);
			m_teamMemberImages = m_teamMemberImageService.queryAllTeamMemberImages(0);

			for (TeamMemberImage temp : m_teamMemberImages) {
				temp.setImage(m_imageService.findImage(temp.getImageId()));
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String teamMemberImageUpdate() {
		m_teams = m_teamService.queryAllTeams();
		try {
			m_teamMemberImage = m_teamMemberImageService.findTeamMemberImage(m_teamMemberImageId);
			m_teamMemberImage.setImage(m_imageService.findImage(m_teamMemberImage.getImageId()));
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String teamMemberImageUpdateSubmit() {
		try {
			if (m_upload != null) {
				int imageId = insertImage();
				m_teamMemberImage.setImageId(imageId);
			} else {
				m_teamMemberImage.setImageId(m_teamMemberImageService.findTeamMemberImage(m_teamMemberImage.getId())
				      .getImageId());
			}
			int count = m_teamMemberImageService.updateTeamMemberImage(m_teamMemberImage);
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
}