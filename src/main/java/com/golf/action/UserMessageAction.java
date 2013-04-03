package com.golf.action;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.golf.Config;
import com.golf.entity.UserMessage;
import com.golf.service.UserMessageService;
import com.golf.tools.PagedTool;
import com.opensymphony.xwork2.ActionSupport;

public class UserMessageAction extends ActionSupport {

	private static final long serialVersionUID = 2801256599554299998L;

	private Logger m_logger = Logger.getLogger(UserMessageAction.class);

	private List<UserMessage> m_userMessages;

	private int m_userMessageId;

	private UserMessageService m_userMessageService;

	private UserMessage m_userMessage = new UserMessage();
	
	private PagedTool m_pagedTool = new PagedTool(Config.DEFAULT_PAGE_NUMBER);

	public PagedTool getPagedTool() {
		return m_pagedTool;
	}

	public UserMessage getUserMessage() {
		return m_userMessage;
	}

	public List<UserMessage> getUserMessages() {
		return m_userMessages;
	}

	public void setIndex(int index){
		m_pagedTool.setPageIndex(index);
	}

	public void setPagedTool(PagedTool pagedTool) {
		m_pagedTool = pagedTool;
	}

	public void setUserMessage(UserMessage userMessage) {
		m_userMessage = userMessage;
	}

	public void setUserMessageId(int userMessageId) {
		m_userMessageId = userMessageId;
	}

	public void setUserMessageService(UserMessageService userMessageService) {
		m_userMessageService = userMessageService;
	}

	public String userMessageAddSubmit() {
		try {
			m_userMessage.setReply("");
			m_userMessage.setCreationDate(new Date());
			int id = m_userMessageService.insertUserMessage(m_userMessage);
			if (id > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}

		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public String userMessageDelete() {
		try {
			int count = m_userMessageService.deleteUserMessage(m_userMessageId);
			if (count > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	public String userMessageList() {
		try {
			//	m_pagedTool.setTotalNumber(m_userMessageService.queryAllUserMessages().size());
			//m_userMessages = m_userMessageService.queryPagedUserMessages(m_pagedTool.getPageIndex(), Config.DEFAULT_PAGE_NUMBER);
			m_userMessages = m_userMessageService.queryAllUserMessages();
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String userMessageUpdate() {
		try {
			m_userMessage = m_userMessageService.findUserMessage(m_userMessageId);
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String userMessageUpdateSubmit() {
		try {
			m_userMessage.setCreationDate(m_userMessageService.findUserMessage(m_userMessage.getId()).getCreationDate());
			int count = m_userMessageService.updateUserMessage(m_userMessage);
			if (count > 0) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			m_logger.error(e.getMessage(), e);
			return ERROR;
		}
	}
	
}