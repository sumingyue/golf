package com.golf.tools;


public class PagedTool {
	
	private int m_totalPage;// 总共页码

	private int m_pageSize;// 页码大小

	private int m_pageIndex;// 当前页码大小

	private int m_totalNumber;// 记录总条数

	private String m_method;// 具体操作方法

	private String m_sql;// 查询出分页SQL

	private static final int DEFAULTSIZE = 25;

	private static final String LAST = "last";

	private static final String NEXT = "next";

	public PagedTool(int pageSize) {
		m_pageSize = pageSize;
	}

	public int getPageSize() {
		return m_pageSize;
	}

	public int getTotalPage() {
		return m_totalPage;
	}

	public int getPageIndex() {
		if (m_method != null && m_method.equals(NEXT))
			m_pageIndex++;
		else if (m_method != null && m_method.equals(LAST))
			m_pageIndex--;
		
		if (m_pageIndex < 1)
			m_pageIndex = 1;
		if (m_totalPage > 0) {
			if (m_pageIndex > m_totalPage)
				m_pageIndex--;
		} else {
			m_pageIndex = 1;
		}
		return m_pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		if (pageIndex < 1) {
			pageIndex = 1;
		}
		m_pageIndex = pageIndex;
	}

	public void setMethod(String method) {
		m_method = method;
	}

	public String getSql() {
		if (m_method != null && m_method.equals(NEXT))
			m_pageIndex++;
		else if (m_method != null && m_method.equals(LAST))
			m_pageIndex--;
		if (m_pageIndex < 1)
			m_pageIndex = 1;
		if (m_totalPage > 0) {
			if (m_pageIndex > m_totalPage)
				m_pageIndex--;
		}
		if (m_pageSize == 0)
			m_pageSize = DEFAULTSIZE;
		int start = m_pageSize * (m_pageIndex - 1);
		m_sql = " limit " + start + "," + m_pageSize;
		return m_sql;
	}

	public void setTotalNumber(int totalNumber) {
		m_totalNumber = totalNumber;
		if (m_pageSize == 0) {
			m_pageSize = DEFAULTSIZE;
		}
		double result = (double) totalNumber / (double) m_pageSize;
		m_totalPage = (int) Math.ceil(result);
	}

	public int getTotalNumber() {
		return m_totalNumber;
	}

	public int getFromIndex() {
		int fromIndex = (getPageIndex() - 1) * m_pageSize;

		if (fromIndex > m_totalNumber) {
			fromIndex = 0;
		}
		return fromIndex;
	}

	public int getToIndex() {
		int fromIndex = getFromIndex();
		int toIndex = fromIndex + m_pageSize;

		if (fromIndex > m_totalNumber) {
			fromIndex = 0;
			toIndex = m_totalNumber;
		}
		if (toIndex > m_totalNumber) {
			toIndex = m_totalNumber;
		}
		return toIndex;
	}
}
