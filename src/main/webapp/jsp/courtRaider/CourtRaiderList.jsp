<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" courtRaider="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
<link rel='stylesheet' type='text/css' href='css/table_jui.css' />
<script src="js/tableInit.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		init();
		$('#courtRaiderList').addClass('active');
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
      <div class="span10">
			<table  align="center" cellpadding="2" cellspacing="1"  class="table" id="contents">
			<thead>
				<tr class="title">
					<th width="5%">序号</th>
					<th width="15%">球场名称</th>
					<th width="35%">名称</th>
					<th width="35%">顺序</th>
					<th width="10%">操作&nbsp;&nbsp;&nbsp;&nbsp;<a href="courtRaiderAdd.do" >新增</a></th>
				</tr></thead><tbody>
				<s:iterator value="courtRaiders" status="vs">
					<tr class="trDetail">
					<td><s:property value='#vs.index+1'/></td>
					<td><s:property value="court.name" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="indexName" /></td>
					<td><a href="courtRaiderUpdate.do?courtRaiderId=<s:property value="id"/>">编辑</a> &nbsp;&nbsp;&nbsp;&nbsp;
					<a class="delete" href="courtRaiderDelete.do?courtRaiderId=<s:property value="id"/>">删除</a></td>
					</tr>
				</s:iterator></tbody>
			</table>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>
