<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" matchService="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
<link rel='stylesheet' type='text/css' href='css/table_jui.css' />
<script src="js/tableInit.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		init();
		$('#matchServiceList').addClass('active');
	});
</script>
</head>
<body>
  <%@include file="./../Head.jsp"%>
  </br>
  </br>
  <div class="container-fluid">
    <div class="row-fluid">
      <%@include file="./../Menu.jsp"%>
      <div class="span10"><!-- 
        	<h4 style="text-align:center">赛事服务信息管理</h4> -->
			<table  align="center" cellpadding="2" cellspacing="1"  class="table" id="contents">
				<thead><tr class="title">
					<th width="5%">序号</th>
					<th width="25%">时间</th>
					<th width="20%">客户姓名</th>
					<th width="20%">客户电话</th>
					<th width="20%">订单状态</th>
					<th width="10%">操作&nbsp;&nbsp;&nbsp;&nbsp;<a href="matchServiceAdd.do" >新增</a></th>
				</tr></thead><tbody>
				<s:iterator value="matchServices" status="vs">
					<tr class="trDetail">
					<td><s:property value='#vs.index+1'/></td>
					<td><s:property value="dateStr" /></td>
					<td><s:property value="userName" /></td>
					<td><s:property value="userPhone" /></td><td><s:if test="status==0"><span style="color:red;">未处理</span></s:if>
					<s:elseif test="status==1"><span style="color:red;">待处理</span></s:elseif></td>
					<td><a href="matchServiceUpdate.do?matchServiceId=<s:property value="id"/>">编辑</a> &nbsp;&nbsp;&nbsp;&nbsp;
					<a class="delete" href="matchServiceDelete.do?matchServiceId=<s:property value="id"/>">删除</a></td>
					</tr>
				</s:iterator></tbody>
			</table>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>
