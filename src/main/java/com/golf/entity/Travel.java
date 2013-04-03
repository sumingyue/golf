package com.golf.entity;

import java.util.Date;

public class Travel {
	private int m_id;

	private String m_name;

	private int m_type;

	private int m_price;

	private int m_prePrice;

	private int m_cashPrice;

	private int m_travelHotelId;

	private TravelHotel m_travelHotel;

	private String m_introduction;

	private String m_des;

	private Date m_creationDate;

	public int getCashPrice() {
		return m_cashPrice;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public String getDes() {
		return m_des;
	}

	public int getId() {
		return m_id;
	}

	public String getIntroduction() {
		return m_introduction;
	}

	public String getName() {
		return m_name;
	}

	public int getPrePrice() {
		return m_prePrice;
	}

	public int getPrice() {
		return m_price;
	}

	public TravelHotel getTravelHotel() {
		return m_travelHotel;
	}

	public int getTravelHotelId() {
		return m_travelHotelId;
	}

	public int getType() {
		return m_type;
	}

	public void setCashPrice(int cashPrice) {
		m_cashPrice = cashPrice;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

	public void setDes(String des) {
		m_des = des;
	}

	public void setId(int id) {
		m_id = id;
	}

	public void setIntroduction(String introduction) {
		m_introduction = introduction;
	}

	public void setName(String name) {
		m_name = name;
	}

	public void setPrePrice(int prePrice) {
		m_prePrice = prePrice;
	}

	public void setPrice(int price) {
		m_price = price;
	}

	public void setTravelHotel(TravelHotel travelHotel) {
		m_travelHotel = travelHotel;
	}

	public void setTravelHotelId(int travelHotelId) {
		m_travelHotelId = travelHotelId;
	}

	public void setType(int type) {
		m_type = type;
	}

}
