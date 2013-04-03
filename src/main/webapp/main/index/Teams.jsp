<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<s:iterator value="teams">
	<div class="span2">
		<a href="team.do?id=${id}">
		<img class="team-img" src="${logo.path}"/>
		<p class="text-center">${name}</p>
		</a>
	</div>
 </s:iterator>