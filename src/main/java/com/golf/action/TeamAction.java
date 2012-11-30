package com.golf.action;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.golf.Config;
import com.golf.entity.Image;
import com.golf.entity.Team;
import com.golf.entity.TeamMemberImage;
import com.golf.entity.UploadFile;
import com.golf.service.ImageService;
import com.golf.service.TeamService;
import com.golf.tools.ImageTools;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class TeamAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(TeamAction.class);

	private List<Team> m_teams;

	private int m_teamId;

	private TeamService m_teamService;

	private Team m_team = new Team();

	private TeamMemberImage m_teamMemberImage = new TeamMemberImage();

	private ImageService m_imageService;

	private UploadFile m_uploadFile = new UploadFile();

	private File m_upload;

	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public String teamList() {
		try {
			m_pagedTool.setTotalNumber(m_teamService.queryAllTeams().size());
			m_teams = m_teamService.queryPagedTeams(m_pagedTool);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String teamAddSubmit() {
		try {
			int id = m_teamService.insertTeam(m_team);
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

	public String teamUpdate() {
		try {
			m_team = m_teamService.findTeam(m_teamId);
			m_team.setLogo(m_imageService.findImage(m_team.getImageId()));
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String teamUpdateSubmit() {
		try {
			int count = m_teamService.updateTeam(m_team);
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

	public String teamDelete() {
		try {
			int count = m_teamService.deleteTeam(m_teamId);
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

	public String updateTeamLogo() {
		try {
			String relativePath = Config.IMAGE_PATH + ImageTools.getImageStorePath(m_uploadFile.getFilename(), Image.TEAM);
			String storePath = ServletActionContext.getServletContext().getRealPath("/") + "/" + relativePath;

			m_uploadFile.setPath(relativePath);
			m_uploadFile.setStorePath(storePath);

			int imageId = m_imageService.insert(m_upload, m_uploadFile, Image.TEAM);
			if (imageId > 0) {
				int count = m_teamService.updateTeamLogo(m_teamId, imageId);
				if (count < 0) {
					return ERROR;
				} else {
					m_teamService.findTeam(m_teamId).setImageId(imageId);
					return SUCCESS;
				}
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			addActionError(e.getMessage());
			return ERROR;
		}
	}

	public Team getTeam() {
		return m_team;
	}

	public void setTeam(Team team) {
		m_team = team;
	}

	public void setTeamService(TeamService teamService) {
		m_teamService = teamService;
	}

	public List<Team> getTeams() {
		return m_teams;
	}

	public void setTeamId(int teamId) {
		m_teamId = teamId;
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

	public void setTeamMemberImage(TeamMemberImage teamMemberImage) {
		m_teamMemberImage = teamMemberImage;
	}

	public TeamMemberImage getTeamMemberImage() {
		return m_teamMemberImage;
	}

	public int getTeamId() {
		return m_teamId;
	}

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}

	public void setIndex(int index) {
		m_pagedTool.setPageIndex(index);
	}
}