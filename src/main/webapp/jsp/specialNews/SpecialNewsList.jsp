<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
<link rel='stylesheet' type='text/css' href='css/table_jui.css' />
<script src="js/tableInit.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#specialNewsList').addClass('active');
		$(".delete").bind("click", function() {
			return confirm("确定要删除此分类吗(不可恢复)？");
		});
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
			<table class="table table-striped table-bordered table-hover">
				<thead>
				<tr class="title">
					<th width="5%">序号</th>
					<th width="78%">标题</th>
					<th width="5%">级别</th>
					<th width="12%">操作&nbsp;&nbsp;&nbsp;&nbsp;<a href="specialNewsAdd.do" class="btn btn-primary  btn-small" >新增</a></th>
				</tr></thead><tbody>
				<s:iterator value="specialNewss" status="vs">
					<tr class="trDetail">
					<td><s:property value='#vs.index+1'/></td>
					<td><s:property value="title" /></td>
					<td><s:property value="priority" /></td>
					<td>
					<a href="specialNewsUpdate.do?specialNewsId=<s:property value="id"/>" class="btn btn-primary  btn-small" >编辑</a> &nbsp;
					<a href="specialNewsDelete.do?specialNewsId=<s:property value="id"/>" class="btn btn-danger  btn-small delete">删除</a></td>
					</tr>
				</s:iterator></tbody>
			</table>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>

