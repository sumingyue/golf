<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html>
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
	$('#newsList').addClass("active");
	
	var status = ${status};
	var recommand = ${recommand};
	$('#status').attr("value",status);
	$('#recommand').attr("value",recommand);
});

function categoryChanged(){
	var categoryId = $('#news_categoryId').val();
	var status=$('#status').val();
	var recommand=$('#recommand').val();
	window.location="?categoryId="+categoryId+"&status="+status+"&recommand="+recommand;
}

function smallCategoryChanged(){
	var categoryId = $('#news_categoryId').val();
	var smallCategoryId = $('#news_smallCategoryId').val();
	var status=$('#status').val();
	var recommand=$('#recommand').val();
	window.location="?categoryId="+categoryId+"&smallCategoryId="+smallCategoryId+"&status="+status+"&recommand="+recommand;
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
<!--         <h4 style="text-align:center">新闻内容管理</h4>
 -->			<table  align="center" cellpadding="2" cellspacing="1"  class="table">
				<tr class="title">
					<th width="4%">序号</th>
					<th width="8%">
							<s:select name="news.categoryId"
								onchange="categoryChanged()"
								list="categoryList" listKey="id" listValue="name" 
								headerKey="0" headerValue="ALL"
								value="categoryId" theme="simple" >
							</s:select>
					</th>
					<th width="8%">
						<s:select name="news.smallCategoryId"
								onchange="smallCategoryChanged()"
								list="smallCategoryList" listKey="id" listValue="name"
								headerKey="0" headerValue="ALL"
								value="smallCategoryId" theme="simple" >
							</s:select>
						</th>
					<th width="42%">标题</th>
					<th width="8%">
						<select id="status" onchange="smallCategoryChanged()">
							<option value="0">_ALL</option>
							<option value="1">未审</option>
							<option value="2">已审</option>
						</select>
					</th>
					<th width="8%">
						<select id="recommand" onchange="smallCategoryChanged()">
							<option value="0">_ALL</option>
							<option value="2">推荐首页</option>
							<option value="1">未推荐</option>
						</select>
					</th>
					<th width="4%">级别</th>
					<th width="8%">操作&nbsp;&nbsp;&nbsp;&nbsp;<a href="newsAdd.do?categoryId=${categoryId}&smallCategoryId=${smallCategoryId}" >新增</a></th>
				</tr>
				<s:iterator value="newsList" status="vs">
					<tr>
					<td title="<s:property value="creationDateStr" />"><s:property value='#vs.index+1'/></td>
					<td><s:property value="category.name" /></td>
					<td><s:property value="smallCategory.name" /></td>
					<td  title="<s:property value="creationDateStr" />"><a href="news.do?id=<s:property value="id"/>"><s:property value="title" /></a></td>
					<td>
						<s:if test="status==1"><span style="color:red;">未审</span></s:if>
					</td>
					<td>
						<s:if test="recommend==2"><span style="color:red;">是</span></s:if>
					</td>
					<td><s:property value="priority" /></td>
					<td>
					<a href="newsUpdate.do?newsId=<s:property value="id"/>">编辑</a> &nbsp;
					<a href="newsDelete.do?newsId=<s:property value="id"/>" class="delete">删除</a></td>
					</tr>
				</s:iterator>
			</table>
			<br>
			<table align="center" class="paged">
				<tr>
					<td style="color:#060;">
						共&nbsp;<s:property value="pagedTool.totalNumber"/>&nbsp;条记录
						<a href="?index=0&categoryId=<s:property value="categoryId"/>&smallCategoryId=<s:property value="smallCategoryId"/>&status=${status}&recommand=${recommand}">首页</a>&nbsp;&nbsp;
						<a href="?index=<s:property value="pagedTool.pageIndex-1"/>&categoryId=<s:property value="categoryId"/>&smallCategoryId=<s:property value="smallCategoryId"/>&status=${status}&recommand=${recommand}">上一页</a>&nbsp;&nbsp;
						<a href="?index=<s:property value="pagedTool.pageIndex+1"/>&categoryId=<s:property value="categoryId"/>&smallCategoryId=<s:property value="smallCategoryId"/>&status=${status}&recommand=${recommand}">下一页</a>&nbsp;&nbsp;
						<a href="?index=<s:property value="pagedTool.totalPage"/>&categoryId=<s:property value="categoryId"/>&smallCategoryId=<s:property value="smallCategoryId"/>&status=${status}&recommand=${recommand}">末页</a>&nbsp;&nbsp;
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

