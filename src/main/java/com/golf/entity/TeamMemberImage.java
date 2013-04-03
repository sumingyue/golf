package com.golf.entity;

import java.util.Date;

public class TeamMemberImage {

	private int m_id;

	private int m_teamId;

	private int m_imageId;
	
	private Image m_image;

	private String m_memberName;

	private String m_imageDes;
	
	private Date m_creationDate;
	
	public Date getCreationDate() {
		return m_creationDate;
	}

	public int getId() {
		return m_id;
	}

	public Image getImage() {
		return m_image;
	}

	public String getImageDes() {
		return m_imageDes;
	}

	public int getImageId() {
		return m_imageId;
	}

	public String getMemberName() {
		return m_memberName;
	}

	public int getTeamId() {
		return m_teamId;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

	public void setId(int id) {
		m_id = id;
	}

	public void setImage(Image image) {
		m_image = image;
	}

	public void setImageDes(String imageDes) {
		m_imageDes = imageDes;
	}

	public void setImageId(int imageId) {
		m_imageId = imageId;
	}

	public void setMemberName(String memberName) {
		m_memberName = memberName;
	}

	public void setTeamId(int teamId) {
		m_teamId = teamId;
	}

}
