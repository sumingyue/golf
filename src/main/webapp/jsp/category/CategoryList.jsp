<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("tr:even").addClass("even");
	$("tr:odd").addClass("odd");
	$("tr").bind("mouseout",function(){
		this.style.backgroundColor='';
	});
	$("tr").bind("mouseover",function(){
		this.style.backgroundColor='#BFDFFF'
	});
	$(".delete").bind("click",function(){
		return confirm("确定要删除此分类吗(不可恢复)？");
	});
	$('#categoryList').addClass("active");
	
	var type=<s:property value="type"/>;
	$('#category_type').val(type);
});

function typeChanged(){
	var type = $('#category_type').val();
	var href = '?type='+type;
	window.location.href = href;
}
</script>
</head>
<body>
  <%@include file="./../Head.jsp"%>
  </br>
  </br>
  <div class="container-fluid">
    <div class="row-fluid">
      <%@include file="./../Menu.jsp"%>
      <div class="span10">
         <h4 style="text-align:center">分类类型
 			<select id="category_type" onchange="typeChanged()">
					<option value="1">新闻分类</option>
					<option value="2">图片专题</option>
			</select></h4>
			<table  align="center" cellpadding="2" cellspacing="1"  class="table">
				<tr class="title">
					<th width="5%">序号</th>
					<th width="75%">名称</th>
					<th width="10%">管理</th>
					<th width="10%">操作&nbsp;&nbsp;&nbsp;&nbsp;<a href="categoryAdd.do?type=<s:property value="type"/>">新增</a></th>
				</tr>
				<s:iterator value="categories" status="vs">
					<tr>
					<td><s:property value='#vs.index+1'/></td>
					<td><s:property value="name" /></td>
					<td><a href="smallCategoryList.do?categoryId=<s:property value="id"/>&type=<s:property value="type"/>">管理子类</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td><a href="categoryUpdate.do?type=<s:property value="type"/>&categoryId=<s:property value="id"/>">编辑</a> &nbsp;&nbsp;&nbsp;&nbsp;
					<a href="categoryDelete.do?type=<s:property value="type"/>&categoryId=<s:property value="id"/>" class="delete">删除</a></td>
					</tr>
				</s:iterator>
			</table>
				</br>
				<table  align="center">
					<tr >
						<td>
							共&nbsp;<s:property value="pagedTool.totalNumber"/>&nbsp;条记录
							<a href="?index=0&type=<s:property value="type"/>">首页</a>&nbsp;&nbsp;
							<a href="?index=<s:property value="pagedTool.pageIndex-1"/>&type=<s:property value="type"/>">上一页</a>&nbsp;&nbsp;
							<a href="?index=<s:property value="pagedTool.pageIndex+1"/>&type=<s:property value="type"/>">下一页</a>&nbsp;&nbsp;
							<a href="?index=<s:property value="pagedTool.totalPage"/>&type=<s:property value="type"/>">末页</a>&nbsp;&nbsp;
							共&nbsp;<s:property value="pagedTool.totalPage"/>&nbsp;页,当前第&nbsp;<s:property value="pagedTool.pageIndex"/>页&nbsp;
							<s:property value="pagedTool.pageSize"/>条记录/页&nbsp;
						</td>
					</tr>
				</table>
			<br>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>

