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

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

	public int getId() {
		return m_id;
	}

	public void setId(int id) {
		m_id = id;
	}

	public int getTeamId() {
		return m_teamId;
	}

	public void setTeamId(int teamId) {
		m_teamId = teamId;
	}

	public int getImageId() {
		return m_imageId;
	}

	public void setImageId(int imageId) {
		m_imageId = imageId;
	}

	public String getMemberName() {
		return m_memberName;
	}

	public void setMemberName(String memberName) {
		m_memberName = memberName;
	}

	public String getImageDes() {
		return m_imageDes;
	}

	public void setImageDes(String imageDes) {
		m_imageDes = imageDes;
	}

	public Image getImage() {
		return m_image;
	}

	public void setImage(Image image) {
		m_image = image;
	}

}
