package com.golf.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.golf.Config;

public class News {

	public static final int DELETE = 2;

	public static final int NO = 0;

	public static final int NORMAL = 1;

	public static final int PREPARE = 0;

	public static final int YES = 1;

	private String m_author;

	private int m_bad;

	private Category m_category;

	private int m_categoryId;

	private String m_content;

	private Date m_creationDate;

	private int m_good;

	private int m_id;

	private int m_imageId;

	private Image m_image;

	private String m_keyword;

	private Date m_modifyDate;

	private int m_recommend;

	private SmallCategory m_smallCategory;

	private int m_smallCategoryId;

	private String m_source;

	private int m_status;

	private String m_title;

	private Date m_validateDate;

	private int m_viewNumber;

	private int priority;

	private SimpleDateFormat m_sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	private SimpleDateFormat m_validate = new SimpleDateFormat("yyyy-MM-dd");

	public String getAuthor() {
		if (m_author != null) {
			return m_author;
		}
		return "";
	}

	public int getBad() {
		return m_bad;
	}

	public Category getCategory() {
		return m_category;
	}

	public int getCategoryId() {
		return m_categoryId;
	}

	public String getContent() {
		return m_content;
	}

	public String getCreationDateStr() {
		if (m_creationDate != null) {
			return m_sdf.format(m_creationDate);
		}
		return "";
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public int getGood() {
		return m_good;
	}

	public int getId() {
		return m_id;
	}

	public String getKeyword() {
		if (m_keyword != null) {
			return m_keyword;
		}
		return "";
	}

	public Date getModifyDate() {
		return m_modifyDate;
	}

	public int getPriority() {
		return priority;
	}

	public int getRecommend() {
		return m_recommend;
	}

	public SmallCategory getSmallCategory() {
		return m_smallCategory;
	}

	public int getSmallCategoryId() {
		return m_smallCategoryId;
	}

	public String getSource() {
		return m_source;
	}

	public int getStatus() {
		return m_status;
	}

	public String getTitle() {
		return m_title;
	}

	public String getValidateDateStr() {
		if (m_validateDate != null) {
			return m_sdf.format(m_validateDate);
		}
		return "";
	}

	public Date getValidateDate() {
		return m_validateDate;
	}

	public int getViewNumber() {
		return m_viewNumber;
	}

	public void setAuthor(String author) {
		m_author = author;
	}

	public void setBad(int bad) {
		m_bad = bad;
	}

	public void setCategory(Category category) {
		m_category = category;
	}

	public void setCategoryId(int categoryId) {
		m_categoryId = categoryId;
	}

	public void setContent(String content) {
		m_content = content;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

	public void setGood(int good) {
		m_good = good;
	}

	public void setId(int id) {
		m_id = id;
	}

	public void setKeyword(String keyword) {
		m_keyword = keyword;
	}

	public void setModifyDate(Date modifyDate) {
		m_modifyDate = modifyDate;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setRecommend(int recommend) {
		m_recommend = recommend;
	}

	public void setSmallCategory(SmallCategory smallCategory) {
		m_smallCategory = smallCategory;
	}

	public void setSmallCategoryId(int smallCategoryId) {
		m_smallCategoryId = smallCategoryId;
	}

	public void setSource(String source) {
		m_source = source;
	}

	public void setStatus(int status) {
		m_status = status;
	}

	public void setTitle(String title) {
		m_title = title;
	}

	public String getDateStr() {
		if(m_validate!=null){
			return m_validate.format(m_validateDate);
		}
		return "";
	}

	public String getShortTitle() {
		int length = m_title.length();
		if (length > Config.TITLE_LENGTH) {
			return m_title.substring(0, Config.TITLE_LENGTH);
		}
		return m_title;
	}

	public void setValidateDate(String validateDate) {
		try {
			m_validateDate = m_sdf.parse(validateDate);
		} catch (ParseException e) {
			m_validateDate = new Date();
		}
	}

	public void setViewNumber(int viewNumber) {
		m_viewNumber = viewNumber;
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

}
