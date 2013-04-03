package com.golf.entity;

import java.util.Date;
import java.util.List;

public class Team {

	private int m_id;

	private int m_imageId;

	private String m_name;

	private String m_announcement;

	private String m_introduction;

	private String m_setUpTime;

	private String m_founder;

	private String m_captain;

	private String m_members;

	private String m_slogan;

	private String m_achievement;

	private Date m_date;

	private Image m_logo;

	private List<Image> m_memberImages;

	public String getAchievement() {
		return m_achievement;
	}

	public String getAnnouncement() {
		return m_announcement;
	}

	public String getCaptain() {
		return m_captain;
	}

	public Date getDate() {
		return m_date;
	}

	public String getFounder() {
		return m_founder;
	}

	public int getId() {
		return m_id;
	}

	public int getImageId() {
		return m_imageId;
	}

	public String getIntroduction() {
		return m_introduction;
	}

	public Image getLogo() {
		return m_logo;
	}

	public List<Image> getMemberImages() {
		return m_memberImages;
	}

	public String getMembers() {
		return m_members;
	}

	public String getName() {
		return m_name;
	}

	public String getSetUpTime() {
		return m_setUpTime;
	}

	public String getSlogan() {
		return m_slogan;
	}

	public void setAchievement(String achievement) {
		m_achievement = achievement;
	}

	public void setAnnouncement(String announcement) {
		m_announcement = announcement;
	}

	public void setCaptain(String captain) {
		m_captain = captain;
	}

	public void setDate(Date date) {
		m_date = date;
	}

	public void setFounder(String founder) {
		m_founder = founder;
	}

	public void setId(int id) {
		m_id = id;
	}

	public void setImageId(int imageId) {
		m_imageId = imageId;
	}

	public void setIntroduction(String introduction) {
		m_introduction = introduction;
	}

	public void setLogo(Image logo) {
		m_logo = logo;
	}

	public void setMemberImages(List<Image> memberImages) {
		m_memberImages = memberImages;
	}

	public void setMembers(String members) {
		m_members = members;
	}

	public void setName(String name) {
		m_name = name;
	}

	public void setSetUpTime(String setUpTime) {
		m_setUpTime = setUpTime;
	}

	public void setSlogan(String slogan) {
		m_slogan = slogan;
	}

}
