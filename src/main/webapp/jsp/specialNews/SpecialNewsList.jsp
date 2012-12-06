<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<html>
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
	$('#specialNewsList').addClass("active");
});

function categoryChanged(){
	var categoryId = $('#specialNews_categoryId').val();
	window.location="?categoryId="+categoryId;
}

function smallCategoryChanged(){
	var categoryId = $('#specialNews_categoryId').val();
	var smallCategoryId = $('#specialNews_smallCategoryId').val();
	window.location="?categoryId="+categoryId+"&smallCategoryId="+smallCategoryId;
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
			<table  align="center" cellpadding="2" cellspacing="1"  class="table">
				<tr class="title">
					<th width="5%">序号</th>
					<th width="82%">标题</th>
					<th width="5%">级别</th>
					<th width="8%">操作&nbsp;&nbsp;&nbsp;&nbsp;<a href="specialNewsAdd.do" >新增</a></th>
				</tr>
				<s:iterator value="specialNewss" status="vs">
					<tr>
					<td><s:property value='#vs.index+1'/></td>
					<td><s:property value="title" /></td>
					<td><s:property value="priority" /></td>
					<td>
					<a href="specialNewsUpdate.do?specialNewsId=<s:property value="id"/>">编辑</a> &nbsp;
					<a href="specialNewsDelete.do?specialNewsId=<s:property value="id"/>" class="delete">删除</a></td>
					</tr>
				</s:iterator>
			</table>
			<br>
			<table align="center" class="paged">
				<tr>
					<td style="color:#060;">
						共&nbsp;<s:property value="pagedTool.totalNumber"/>&nbsp;条记录
						<a href="specialNewsList.do?pagedTool.pageIndex=0">首页</a>&nbsp;&nbsp;
						<a href="specialNewsList.do?pagedTool.pageIndex=<s:property value="pagedTool.pageIndex-1"/>&categoryId=<s:property value="categoryId"/>&smallCategoryId=<s:property value="smallCategoryId"/>">上一页</a>&nbsp;&nbsp;
						<a href="specialNewsList.do?pagedTool.pageIndex=<s:property value="pagedTool.pageIndex+1"/>&categoryId=<s:property value="categoryId"/>&smallCategoryId=<s:property value="smallCategoryId"/>">下一页</a>&nbsp;&nbsp;
						<a href="specialNewsList.do?pagedTool.pageIndex=<s:property value="pagedTool.totalPage"/>&categoryId=<s:property value="categoryId"/>&smallCategoryId=<s:property value="smallCategoryId"/>">末页</a>&nbsp;&nbsp;
						共&nbsp;<s:property value="pagedTool.totalPage"/>&nbsp;页,当前第&nbsp;<s:property value="pagedTool.pageIndex"/>页&nbsp;
						<s:property value="pagedTool.pageSize"/>条记录/页&nbsp;
					</td>
				</tr>
			</table>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>

