package com.golf.entity;

import java.util.Date;

public class CourtRaider {

	private int m_id;

	private int m_courtId;

	private Court m_court;

	private String m_type;
	
	private String m_name;

	private int m_imageId;

	private Image m_image;

	private String m_typeIndex;
	
	private int m_indicator1;

	private int m_indicator2;

	private int m_indicator3;

	private int m_indicator4;

	private int m_indicator5;

	private String m_des;

	private Date m_creationDate;

	public int getId() {
		return m_id;
	}

	public void setId(int id) {
		m_id = id;
	}

	public int getCourtId() {
		return m_courtId;
	}

	public void setCourtId(int courtId) {
		m_courtId = courtId;
	}

	public Court getCourt() {
		return m_court;
	}

	public void setCourt(Court court) {
		m_court = court;
	}

	public String getType() {
		return m_type;
	}

	public void setType(String type) {
		m_type = type;
	}

	public String getName() {
		return m_name;
	}

	public void setName(String name) {
		m_name = name;
	}

	public int getImageId() {
		return m_imageId;
	}

	public void setImageId(int imageId) {
		m_imageId = imageId;
	}

	public Image getImage() {
		return m_image;
	}

	public void setImage(Image image) {
		m_image = image;
	}

	public String getTypeIndex() {
		return m_typeIndex;
	}

	public void setTypeIndex(String typeIndex) {
		m_typeIndex = typeIndex;
	}

	public int getIndicator1() {
		return m_indicator1;
	}

	public void setIndicator1(int indicator1) {
		m_indicator1 = indicator1;
	}

	public int getIndicator2() {
		return m_indicator2;
	}

	public void setIndicator2(int indicator2) {
		m_indicator2 = indicator2;
	}

	public int getIndicator3() {
		return m_indicator3;
	}

	public void setIndicator3(int indicator3) {
		m_indicator3 = indicator3;
	}

	public int getIndicator4() {
		return m_indicator4;
	}

	public void setIndicator4(int indicator4) {
		m_indicator4 = indicator4;
	}

	public int getIndicator5() {
		return m_indicator5;
	}

	public void setIndicator5(int indicator5) {
		m_indicator5 = indicator5;
	}

	public String getDes() {
		return m_des;
	}

	public void setDes(String des) {
		m_des = des;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}
	
}
