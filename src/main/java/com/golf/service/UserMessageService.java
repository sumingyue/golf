package com.golf.service;

import java.util.List;

import com.golf.entity.UserMessage;

public interface UserMessageService {

	public List<UserMessage> queryAllUserMessages();

	public List<UserMessage> queryPagedUserMessages(int pageNumber, int pageSize);

	public int insertUserMessage(UserMessage userMessage);

	public int updateUserMessage(UserMessage userMessage);

	public int deleteUserMessage(int userMessageId);

	public UserMessage findUserMessage(int userMessageId);

}
