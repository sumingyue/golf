<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html><html>
<head>
<title>图片列表</title>
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript">
	function setValue(img){
		if(confirm('确定选择这张图片吗?')){
			console.log(img.src);
			var input = $('#cke_104_textInput', window.opener.document);
			input.val(img.src);
			window.close();
		}
	}
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
				onclick="setValue(this)"></td>
			<s:if test="#status.index%3==2||#status.last">
				</tr>
			</s:if>
		</s:iterator>
	</table>
</body>
</html>