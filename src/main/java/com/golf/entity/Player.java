package com.golf.entity;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Player {

	private int m_id;

	private String m_name;

	private double m_score;

	private double m_bonus;

	private Date m_creationDate;
	
	private Date m_modifyDate;
	
	private NumberFormat m_nf = new DecimalFormat("0.0");
	
	private SimpleDateFormat m_sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public String getModifyDateStr() {
		return m_sdf.format(m_modifyDate);
	}

	public Date getModifyDate() {
		return m_modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		m_modifyDate = modifyDate;
	}

	public int getId() {
		return m_id;
	}

	public void setId(int id) {
		m_id = id;
	}

	public String getName() {
		return m_name;
	}

	public void setName(String name) {
		m_name = name;
	}

	public double getScore() {
		return m_score;
	}
	
	public String getScoreStr() {
		return m_nf.format(m_score);
	}

	public void setScore(double score) {
		m_score = score;
	}

	public double getBonus() {
		return m_bonus;
	}
	
	public String getBonusStr() {
		return m_nf.format(m_bonus);
	}

	public void setBonus(double bonus) {
		m_bonus = bonus;
	}

	public Date getCreationDate() {
		return m_creationDate;
	}

	public void setCreationDate(Date creationDate) {
		m_creationDate = creationDate;
	}

}
