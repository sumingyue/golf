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
	$('#courtOrderList').addClass("active");
});
	var calendar = null;
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
<!--         <h4 style="text-align:center">顾客球场预定管理</h4>
 -->			
			<table  align="center" cellpadding="2" cellspacing="1"  class="table" id="courtOrderList">
				<tr class="title">
					<th width="5%">序号</th>
					<th width="8%">类型</th>
					<th width="10%">名称</th>
					<th width="10%">状态</th>
					<th width="10%">时间</th>
					<th width="10%">用户</th>
					<th width="20%">电话</th>
					<th width="10%">操作&nbsp;&nbsp;&nbsp;&nbsp;<a href="courtOrderAdd.do" >新增</a></th>
				</tr>
				<s:iterator value="courtOrders" status="vs">
					<tr>
					<td><s:property value='#vs.index+1'/></td>
					<td><s:if test="type==0">练习场</s:if>
					<s:elseif test="type==1">球场</s:elseif></td>
					<td><s:property value="courtName" /></td>
					<td><s:if test="status==0"><span style="color:red;">未处理</span></s:if>
					<s:elseif test="status==1"><span style="color:red;">待处理</span></s:elseif></td>
					<td><s:property value="date" /></td>
					<td><s:property value="userName" /></td>
					<td><s:property value="userPhone" /></td>
					<td><a href="courtOrderUpdate.do?courtOrderId=<s:property value="id"/>">编辑</a> &nbsp;&nbsp;&nbsp;&nbsp;
					<a class="delete" href="courtOrderDelete.do?courtOrderId=<s:property value="id"/>">删除</a></td>
					</tr>
				</s:iterator>
			</table>
				</br>
				<table  align="center">
					<tr >
						<td>
							共&nbsp;<s:property value="pagedTool.totalNumber"/>&nbsp;条记录
							<a href="?index=0&courtId=<s:property value="courtId"/>">首页</a>&nbsp;&nbsp;
							<a href="?index=<s:property value="pagedTool.pageIndex-1"/>">上一页</a>&nbsp;&nbsp;
							<a href="?index=<s:property value="pagedTool.pageIndex+1"/>">下一页</a>&nbsp;&nbsp;
							<a href="?index=<s:property value="pagedTool.totalPage"/>">末页</a>&nbsp;&nbsp;
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
