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
	
	var type = <s:property value='type'/>;
	$('#teamNews_type').attr("value",type);
	$('#teamNewsList').addClass("active");
});
	function teamChanged(){
		var teamId = $('#teamId').val();
		var type=$("#teamNews_type").val();
		window.location="?teamId="+teamId+"&type="+type;
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
       		<!--  <h4 style="text-align:center">球队新闻管理</h4> -->
			<div width="100%" style="text-align:center">
			<s:select name="teamId" id="teamId"
					onchange="teamChanged()"
					list="teams" listKey="id" listValue="name" 
					headerKey="0" headerValue="ALL"
					value="teamId" theme="simple" >
			</s:select></div>
			<table  align="center" cellpadding="2" cellspacing="1"  class="table" id="teamNewsList">
				<tr class="title">
					<th width="5%">序号</th>
					<th width="10%">分类
						<select name="teamNews.type" id="teamNews_type" onchange="teamChanged()">
							<option value="0">ALL</option>
							<option value="1">球队新闻</option>
							<option value="2">活动报道</option>
							<option value="3">月历成绩</option>
							<option value="4">精彩图文</option>
							<option value="5">规章制度</option>
						</select>
					</th>
					<th width="75%">新闻标题</th>
					<th width="10%">操作&nbsp;&nbsp;&nbsp;&nbsp;<a href="teamNewsAdd.do" >新增</a></th>
				</tr>
				<s:iterator value="teamNewss" status="vs">
					<tr>
					<td><s:property value='#vs.index+1'/></td>
					<td>
						<s:if test="type==1">球队新闻</s:if>
						<s:elseif test="type==2">活动报道</s:elseif>
						<s:elseif test="type==3">月历成绩</s:elseif>
						<s:elseif test="type==4">精彩图文</s:elseif>
					</td>
					<td><s:property value="title" /></td>
					<td>
					<a href="teamNewsUpdate.do?teamNewsId=<s:property value="id"/>">编辑</a> &nbsp;&nbsp;&nbsp;&nbsp;
					<a class="delete" href="teamNewsDelete.do?teamNewsId=<s:property value="id"/>">删除</a></td>
					</tr>
				</s:iterator>
			</table>
				</br>
				<table  align="center">
					<tr >
						<td>
							共&nbsp;<s:property value="pagedTool.totalNumber"/>&nbsp;条记录
							<a href="?index=0&teamId=<s:property value="teamId"/>">首页</a>&nbsp;&nbsp;
							<a href="?index=<s:property value="pagedTool.pageIndex-1"/>&teamId=<s:property value="teamId"/>&type=<s:property value="type"/>">上一页</a>&nbsp;&nbsp;
							<a href="?index=<s:property value="pagedTool.pageIndex+1"/>&teamId=<s:property value="teamId"/>&type=<s:property value="type"/>">下一页</a>&nbsp;&nbsp;
							<a href="?index=<s:property value="pagedTool.totalPage"/>&teamId=<s:property value="teamId"/>&type=<s:property value="type"/>">末页</a>&nbsp;&nbsp;
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

