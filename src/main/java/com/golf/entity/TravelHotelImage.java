package com.golf.entity;

import java.util.Date;

public class TravelHotelImage {

	private int m_id;

	private int m_travelHotelId;

	private int m_imageId;

	private String m_ImageDes;

	private Date m_creationDate;

	private Image m_image;
	
	private TravelHotel m_travelHotel;
	
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
		return m_ImageDes;
	}

	public int getImageId() {
		return m_imageId;
	}

	public TravelHotel getTravelHotel() {
		return m_travelHotel;
	}

	public int getTravelHotelId() {
		return m_travelHotelId;
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
		m_ImageDes = imageDes;
	}

	public void setImageId(int imageId) {
		m_imageId = imageId;
	}

	public void setTravelHotel(TravelHotel travelHotel) {
		m_travelHotel = travelHotel;
	}

	public void setTravelHotelId(int travelHotelId) {
		m_travelHotelId = travelHotelId;
	}

}
