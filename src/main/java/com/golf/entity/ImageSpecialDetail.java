package com.golf.entity;

import java.util.Date;


public class ImageSpecialDetail {

	private int m_id;

	private int m_imageSpecialId;

	private ImageSpecial m_imageSpecial;

	private int m_imageId;
	
	private Image m_image;

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

	public ImageSpecial getImageSpecial() {
		return m_imageSpecial;
	}

	public int getImageSpecialId() {
		return m_imageSpecialId;
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

	public void setImageSpecial(ImageSpecial imageSpecial) {
		m_imageSpecial = imageSpecial;
	}

	public void setImageSpecialId(int imageSpecialId) {
		m_imageSpecialId = imageSpecialId;
	}

}
