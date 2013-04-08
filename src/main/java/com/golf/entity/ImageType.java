package com.golf.entity;

public enum ImageType {

	NEWS(1, 350, 540, true, 150, 200, "news"),

	ADWORDS(2, 450, 300, false, 200, 150, "adwords"),

	PRODUCT(3, 500, 350, true, 200, 150, "product"),

	TEAM(4, 540, 350, true, 200, 150, "team"),

	COURT(5, 540, 350, true, 200, 150, "court"),

	DRIVINGRANGE(6, 540, 350, true, 200, 150, "drivingRange"),

	LEARN(7, 540, 350, true, 200, 150, "learn"),

	PIC(8, 340, 340, true, 150, 150, "pic"),

	HOTEL(8, 460, 320, false, 0, 0, "hotel"),

	DEFAULT(10, 540, 350, true, 200, 150, "default");

	private int m_type;

	private int m_width;

	private int m_height;

	private boolean m_compress;

	private int m_smallWidth;

	private int m_smallHeight;

	private String m_floder;

	private ImageType(int type, int width, int height, boolean compress, int smallWidth, int smallHeight, String floder) {
		m_type = type;
		m_width = width;
		m_height = height;
		m_compress = compress;
		m_smallWidth = smallWidth;
		m_smallHeight = smallHeight;
		m_floder = floder;
	}

	public int getType() {
		return m_type;
	}

	public int getWidth() {
		return m_width;
	}

	public int getHeight() {
		return m_height;
	}

	public boolean isCompress() {
		return m_compress;
	}

	public int getSmallWidth() {
		return m_smallWidth;
	}

	public int getSmallHeight() {
		return m_smallHeight;
	}

	public String getFloder() {
		return m_floder;
	}

}
