package com.golf.entity;

import java.util.Date;
import java.util.List;

public class Product {
	private int m_id;

	private int m_productCategoryId;

	private ProductCategory m_productCategory;

	private String m_name;

	private String m_unit;

	private String m_brand;

	private String m_crowd;

	private String m_material;

	private String m_introduction;

	private double m_price;

	private double m_memberPrice;

	private Date m_date;
	
	private Image m_image;

	private List<Image> m_images;
	
	public String getBrand() {
		return m_brand;
	}

	public String getCrowd() {
		return m_crowd;
	}

	public Date getDate() {
		return m_date;
	}

	public int getId() {
		return m_id;
	}

	public Image getImage() {
		return m_image;
	}

	public List<Image> getImages() {
		return m_images;
	}

	public String getIntroduction() {
		return m_introduction;
	}

	public String getMaterial() {
		return m_material;
	}

	public double getMemberPrice() {
		return m_memberPrice;
	}

	public String getName() {
		return m_name;
	}

	public double getPrice() {
		return m_price;
	}

	public ProductCategory getProductCategory() {
		return m_productCategory;
	}

	public int getProductCategoryId() {
		return m_productCategoryId;
	}

	public String getUnit() {
		return m_unit;
	}

	public void setBrand(String brand) {
		m_brand = brand;
	}

	public void setCrowd(String crowd) {
		m_crowd = crowd;
	}

	public void setDate(Date date) {
		m_date = date;
	}

	public void setId(int id) {
		m_id = id;
	}

	public void setImage(Image image) {
		m_image = image;
	}

	public void setImages(List<Image> images) {
		m_images = images;
	}

	public void setIntroduction(String introduction) {
		m_introduction = introduction;
	}

	public void setMaterial(String material) {
		m_material = material;
	}

	public void setMemberPrice(double memberPrice) {
		m_memberPrice = memberPrice;
	}

	public void setName(String name) {
		m_name = name;
	}

	public void setPrice(double price) {
		m_price = price;
	}

	public void setProductCategory(ProductCategory productCategory) {
		m_productCategory = productCategory;
	}

	public void setProductCategoryId(int productCategoryId) {
		m_productCategoryId = productCategoryId;
	}

	public void setUnit(String unit) {
		m_unit = unit;
	}
	
}
