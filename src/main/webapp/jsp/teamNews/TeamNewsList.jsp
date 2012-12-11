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
		init();
		$('#teamNewsList').addClass('active');
		var type = <s:property value='type'/>;
		$('#teamNews_type').attr("value",type);
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
       		<!--  <h4 style="text-align:center">球队新闻管理</h4> -->
			<table  align="center" cellpadding="2" cellspacing="1"  class="table" id="contents">
			<thead>
				<tr class="title">
					<th width="5%">序号</th>
					<th width="15%">球队</th>
					<th width="10%">分类
					</th>
					<th width="60%">新闻标题</th>
					<th width="10%">操作&nbsp;&nbsp;&nbsp;&nbsp;<a href="teamNewsAdd.do" >新增</a></th>
				</tr></thead><tbody>
				<s:iterator value="teamNewss" status="vs">
					<tr class="trDetail">
					<td><s:property value='#vs.index+1'/></td>
					<td><s:property value='team.name'/></td>
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
				</s:iterator></tbody>
			</table>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>

