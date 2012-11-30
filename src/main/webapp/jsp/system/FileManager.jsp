<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<html>
<head>
<title>图片列表</title>
<script type="text/javascript">
</script>
</head>
<body>
	<table>
		<s:iterator value="dirs" status="vs">
			<tr>
				<td><a href="fileManager.do?parent=<s:property/>">+<s:property /></a>
				</td>
			</tr>
		</s:iterator>
	</table>
	<table>
		<s:iterator value="pics" status="status">
			<s:if test="#status.index%3==0">
				<tr>
			</s:if>
				<td><img src="<s:property/>"
				onclick="" width="200" height="200"></td>
			<s:if test="#status.index%3==2||#status.last">
				</tr>
			</s:if>
		</s:iterator>
	</table>
</body>
</html>