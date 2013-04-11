<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<table class='table table-striped table-bordered right-news'>
	<tr><td colspan='4'><h3 style="line-height:15px" class='text-center text-success'>${matchCategory.name}圆满结束！！！</h3></td></tr>
	<s:iterator value="imageSpecials">
		<td>
			<div>
			<a href="pic.do?id=${id}" target="blank"><img class="index-pic-img img-rounded" src="${image.path}"></a>
			<p class="text-center"><a href="pic.do?id=${id}" target="blank"><strong>${name}</strong></a></p>
		</div>
		</td>
	</s:iterator>
</table>
	