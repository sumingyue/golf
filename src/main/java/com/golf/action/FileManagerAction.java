package com.golf.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.golf.Config;
import com.opensymphony.xwork2.ActionSupport;

public class FileManagerAction extends ActionSupport {

	private static final long serialVersionUID = 2811256589554299998L;

	private String m_parent;

	private String m_fileName;

	private List<String> m_pics = new ArrayList<String>();

	private List<String> m_dirs = new ArrayList<String>();

	@Override
	public String execute() throws Exception {
		m_fileName = ServletActionContext.getServletContext().getRealPath("/") + "/" + Config.IMAGE_PATH+"/";

		if (m_parent != null && m_parent.length() > 0) {
			m_fileName = m_fileName + m_parent;
		}
		File file = new File(m_fileName);

		File[] files = file.listFiles();

		if (files != null) {
			for (File temp : files) {
				String name = temp.getName();
				if (m_parent != null) {
					name = m_parent + "/" + name;
				}
				if (temp.isDirectory()) {
					m_dirs.add(name);
				} else {
					if(name.indexOf("_normal")>-1){
						m_pics.add(Config.IMAGE_PATH+"/"+name);
					}
				}
			}
		}
		return SUCCESS;
	}

	public List<String> getPics() {
		return m_pics;
	}

	public String getParent() {
		return m_parent;
	}

	public void setParent(String parent) {
		m_parent = parent;
	}

	public List<String> getDirs() {
		return m_dirs;
	}

}