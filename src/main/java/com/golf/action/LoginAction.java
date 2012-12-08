package com.golf.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.golf.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 2801256599554299998L;

	private Map<String, Object> m_session;

	private User m_user;

	@Override
	public String execute() throws Exception {
		String userName = m_user.getUserName();
		String password = m_user.getPassword();

		if ("admin".equals(userName) && "admin123456".equals(password)) {
			m_session.put("user", m_user);
			return SUCCESS;
		}
		return ERROR;
	}

	public String logout() throws Exception {
		m_session.remove("user");
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		m_session = arg0;
	}

	public void setUser(User user) {
		m_user = user;
	}

	public User getUser() {
		return m_user;
	}

}