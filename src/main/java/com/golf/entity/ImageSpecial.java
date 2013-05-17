package com.golf.entity;

import java.util.Date;

import com.golf.Config;

public class ImageSpecial {

	private int m_id;

	private int m_categoryId;

	private int m_smallCategoryId;

	private Category m_category;

	private SmallCategory m_smallCategory;

	private String m_name;

	private String m_content;

	private int m_imageId;

	private Image m_image;

	private Date m_creationDate;

	public String getShowName() {
		return m_smallCategory.getName() + '-' + m_name;
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

	public Date getCreationDate() {
		return m_creationDate;
	}

	public int getId() {
		return m_id;
	}

	public Image getImage() {
		return m_image;
	}

	public int getImageId() {
		return m_imageId;
	}

	public String getName() {
		return m_name;
	}

	public String getShortName() {
		if (m_name != null) {
			if (m_name.length() > Config.DEFAULT_SMALL_TITLE_LENGTH) {
				return m_name.substring(0, Config.DEFAULT_SMALL_TITLE_LENGTH);
			}
		}
		return m_name;
	}

	public SmallCategory getSmallCategory() {
		return m_smallCategory;
	}

	public int getSmallCategoryId() {
		return m_smallCategoryId;
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

	public void setId(int id) {
		m_id = id;
	}

	public void setImage(Image image) {
		m_image = image;
	}

	public void setImageId(int imageId) {
		m_imageId = imageId;
	}

	public void setName(String name) {
		m_name = name;
	}

	public void setSmallCategory(SmallCategory smallCategory) {
		m_smallCategory = smallCategory;
	}

	public void setSmallCategoryId(int smallCategoryId) {
		m_smallCategoryId = smallCategoryId;
	}

}
