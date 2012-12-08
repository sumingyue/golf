<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" courtRaider="screen">
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
	$('#courtRaiderList').addClass("active");
});

function courtChanged(){
	var courtId = $('#courtId').val();
	window.location="?courtId="+courtId;
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
 <!--        	<h4 style="text-align:center">
			高尔夫俱乐部球道攻略管理</h4>
 -->			<div width="100%" style="text-align:center"><s:select name="courtId" id="courtId"
					onchange="courtChanged()"
					list="courts" listKey="id" listValue="name" 
					headerKey="0" headerValue="ALL"
					value="courtId" theme="simple" >
			</s:select></div>
			<table  align="center" cellpadding="2" cellspacing="1"  class="table" id="courtRaiderList">
				<tr class="title">
					<th width="5%">序号</th>
					<th width="45%">名称</th>
					<th width="40%">顺序</th>
					<th width="10%">操作&nbsp;&nbsp;&nbsp;&nbsp;<a href="courtRaiderAdd.do" >新增</a></th>
				</tr>
				<s:iterator value="courtRaiders" status="vs">
					<tr>
					<td><s:property value='#vs.index+1'/></td>
					<td><s:property value="name" /></td>
					<td><s:property value="indexName" /></td>
					<td><a href="courtRaiderUpdate.do?courtRaiderId=<s:property value="id"/>">编辑</a> &nbsp;&nbsp;&nbsp;&nbsp;
					<a class="delete" href="courtRaiderDelete.do?courtRaiderId=<s:property value="id"/>">删除</a></td>
					</tr>
				</s:iterator>
			</table>
				</br>
				<table  align="center">
					<tr >
						<td>
							共&nbsp;<s:property value="pagedTool.totalNumber"/>&nbsp;条记录
							<a href="?index=0&courtId=<s:property value="courtId"/>">首页</a>&nbsp;&nbsp;
							<a href="?index=<s:property value="pagedTool.pageIndex-1"/>&courtId=<s:property value="courtId"/>">上一页</a>&nbsp;&nbsp;
							<a href="?index=<s:property value="pagedTool.pageIndex+1"/>&courtId=<s:property value="courtId"/>">下一页</a>&nbsp;&nbsp;
							<a href="?index=<s:property value="pagedTool.totalPage"/>&courtId=<s:property value="courtId"/>">末页</a>&nbsp;&nbsp;
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
