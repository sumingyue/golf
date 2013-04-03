package com.golf.entity;

import java.util.Date;

public class ProductCategory {

	private int m_id;

	private int m_type;

	private String m_name;

	private Date m_date;

	public Date getDate() {
		return m_date;
	}

	public int getId() {
		return m_id;
	}

	public String getName() {
		return m_name;
	}

	public String getShowName(){
		StringBuilder sb = new StringBuilder();
		if(m_type==1){
			sb.append("球具-");
		}else if(m_type==2){
			sb.append("服饰-");
		}else if(m_type==3){
			sb.append("用品-");
		}else if(m_type==4){
			sb.append("附件-");
		}
		sb.append(m_name);
		return sb.toString();
	}
	
	public int getType() {
		return m_type;
	}

	public void setDate(Date date) {
		m_date = date;
	}

	public void setId(int id) {
		m_id = id;
	}

	public void setName(String name) {
		m_name = name;
	}

	public void setType(int type) {
		m_type = type;
	}

}
