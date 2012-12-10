package com.golf.entity;

import java.util.Date;

public class Image {
	//正常尺寸550，350，小尺寸200，150
	public static final int NEWS = 1;
	
	public static final int NEWS_WIDTH=550;
	public static final int NEWS_HEIGHT=350;
	public static final int NEWS_SMALL_WIDTH=200;
	public static final int NEWS_SMALL_HEIGHT=150;
	//广告默认尺寸，不需要压缩
	public static final int ADWORDS = 2;

	//产品尺寸，大图和小图
	public static final int PRODUCT = 3;
	public static final int PRODUCT_WIDTH=430;
	public static final int PRODUCT_HEIGHT=325;
	public static final int PRODUCT_SMALL_WIDTH=133;
	public static final int PRODUCT_SMALL_HEIGHT=100;

	public static final int TEAM = 4;
	public static final int TEAM_WIDTH=630;
	public static final int TEAM_HEIGHT=315;
	public static final int TEAM_SMALL_WIDTH=220;
	public static final int TEAM_SMALL_HEIGHT=110;

	public static final int COURT = 5;
	public static final int COURT_MAP_WIDTH=377;
	public static final int COURT_MAP_HEIGHT=200;
	public static final int COURT_RAIDER_WIDTH=350;
	public static final int COURT_RAIDER_HEIGHT=350;
	public static final int COURT_WIDTH=500;
	public static final int COURT_HEIGHT=350;
	public static final int COURT_SMALL_WIDTH=150;
	public static final int COURT_SMALL_HEIGHT=100;

	public static final int PIC = 6;
	//图片专题内容
	public static final int PIC_WIDTH=950;
	public static final int PIC_HEIGHT=666;
	//图片专题封面
	public static final int PIC_MAIN_WIDTH=195;
	public static final int PIC_MAIN_HEIGHT=195;
	public static final int PIC_MAIN_SMALL_WIDTH=100;
	public static final int PIC_MAIN_SMALL_HEIGHT=100;
	
	
	public static final int OTHER = 7;
	
	public static final int OTHER_WIDTH=550;
	public static final int OTHER_HEIGHT=350;
	public static final int OTHER_SMALL_WIDTH=200;
	public static final int OTHER_SMALL_HEIGHT=150;

	private int m_id;

	private int m_type;

	private String m_name;

	private String m_path;

	private String m_smallPath;

	private String m_originalPath;

	private String m_netPath;

	private Date m_creationDate;

	public int getId() {
		return m_id;
	}

	public void setId(int id) {
		m_id = id;
	}

	public int getType() {
		return m_type;
	}

	public void setType(int type) {
		m_type = type;
	}

	public String getName() {
		return m_name;
	}

	public void setName(String name) {
		m_name = name;
	}

	public String getNetPath() {
		return m_netPath;
	}

	public void setNetPath(String netPath) {
		m_netPath = netPath;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

	public String getPath() {
		return m_path;
	}

	public void setPath(String path) {
		m_path = path;
	}

	public String getSmallPath() {
		return m_smallPath;
	}

	public void setSmallPath(String compressPath) {
		m_smallPath = compressPath;
	}

	public String getOriginalPath() {
		return m_originalPath;
	}

	public void setOriginalPath(String originalPath) {
		m_originalPath = originalPath;
	}

	
}
