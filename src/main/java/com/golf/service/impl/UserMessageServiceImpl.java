package com.golf.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.golf.dao.UserMessageDao;
import com.golf.entity.UserMessage;
import com.golf.service.UserMessageService;

public class UserMessageServiceImpl implements InitializingBean, UserMessageService {

	private UserMessageDao m_userMessageDao;

	private Map<Integer, UserMessage> m_userMessages = new LinkedHashMap<Integer, UserMessage>();

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {
		List<UserMessage> categories = m_userMessageDao.findAllUserMessage();

		for (UserMessage userMessage : categories) {
			m_userMessages.put(userMessage.getId(), userMessage);
		}
	}

	@Override
	public List<UserMessage> queryAllUserMessages() {
		ArrayList<UserMessage> arrayList = new ArrayList<UserMessage>(m_userMessages.values());
		Collections.sort(arrayList, new UserMessageCompartor());
		return arrayList;
	}

	@Override
	public int insertUserMessage(UserMessage userMessage) {
		int id = m_userMessageDao.insert(userMessage);
		if (id > 0) {
			m_userMessages.put(userMessage.getId(), userMessage);
		}
		return id;
	}

	@Override
	public int updateUserMessage(UserMessage userMessage) {
		int id = m_userMessageDao.update(userMessage);
		if (id > 0) {
			m_userMessages.put(userMessage.getId(), userMessage);
		}
		return id;
	}

	@Override
	public int deleteUserMessage(int userMessageId) {
		int id = m_userMessageDao.delete(userMessageId);
		if (id > 0) {
			m_userMessages.remove(userMessageId);
		}
		return id;
	}

	@Override
	public UserMessage findUserMessage(int userMessageId) {
		UserMessage userMessage = m_userMessages.get(userMessageId);
		if (userMessage == null) {
			UserMessage temp = m_userMessageDao.findById(userMessageId);
			if (temp != null) {
				m_userMessages.put(userMessageId, temp);
			}
			return temp;
		}
		return userMessage;
	}

	public void setUserMessageDao(UserMessageDao userMessageDao) {
		m_userMessageDao = userMessageDao;
	}

	public static class UserMessageCompartor implements Comparator<UserMessage> {

		@Override
		public int compare(UserMessage o1, UserMessage o2) {
			return o2.getId() - o1.getId();
		}
	}

	@Override
   public List<UserMessage> queryPagedUserMessages(int pageNumber, int pageSize) {
		List<UserMessage> result = queryAllUserMessages();
		
		int fromIndex = (pageNumber - 1) * pageSize;
		int toIndex = fromIndex + pageSize;

		int total = result.size();
		if (fromIndex > total) {
			fromIndex = 0;
			toIndex = pageSize;
		}
		if (toIndex > total) {
			toIndex = total;
		}
		return result.subList(fromIndex, toIndex);
   }

}
