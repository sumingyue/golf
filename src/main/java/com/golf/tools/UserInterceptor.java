package com.golf.tools;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 用户拦截器 author zxg version 1.0
 */

public class UserInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	public void destroy() {

	}

	public void init() {
	}

	public String intercept(ActionInvocation actionInvocation) throws Exception {
		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		// sessionStudent
		if (session.get("user") == null) {
			return Action.LOGIN;
		}
		String result = actionInvocation.invoke();
		return result;
	}
}
