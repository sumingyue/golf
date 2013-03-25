<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html>
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
		$('#newsList').addClass('active');
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
<!--         <h4 style="text-align:center">新闻内容管理</h4>
 -->			<table  align="center" cellpadding="2" cellspacing="1"  class="table" id="contents">
				<thead><tr class="title">
					<th width="4%">序号</th>
					<th width="8%">一级分类
							<%-- <s:select name="news.categoryId"
								onchange="categoryChanged()"
								list="categoryList" listKey="id" listValue="name" 
								headerKey="0" headerValue="ALL"
								value="categoryId" theme="simple" >
							</s:select> --%>
					</th>
					<th width="8%">二级分类<%-- 
						<s:select name="news.smallCategoryId"
								onchange="smallCategoryChanged()"
								list="smallCategoryList" listKey="id" listValue="name"
								headerKey="0" headerValue="ALL"
								value="smallCategoryId" theme="simple" >
							</s:select> --%>
						</th>
					<th width="40%">标题</th>
					<th width="5%">审核
						<%-- <select id="status" onchange="smallCategoryChanged()">
							<option value="0">_ALL</option>
							<option value="1">未审</option>
							<option value="2">已审</option>
						</select> --%>
					</th>
					<th width="5%">首页
						<%-- <select id="recommand" onchange="smallCategoryChanged()">
							<option value="0">_ALL</option>
							<option value="2">推荐首页</option>
							<option value="1">未推荐</option>
						</select> --%>
					</th>
					<th width="5%">级别</th>
					<th width="5%">图片</th>
					<th width="10%">操作&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn btn-small btn-primary" href="newsAdd.do?categoryId=${categoryId}&smallCategoryId=${smallCategoryId}"  target='_blank'>新增</a></th>
				</tr></thead><tbody>
				<s:iterator value="newsList" status="vs">
					<tr class="trDetail">
					<td title="<s:property value="creationDateStr" />"><s:property value='#vs.index+1'/></td>
					<td><s:property value="category.name" /></td>
					<td><s:property value="smallCategory.name" /></td>
					<td  title="<s:property value="creationDateStr" />"><a href="news.do?id=<s:property value="id"/>"><s:property value="title" /></a></td>
					<td>
						<s:if test="status==1"><span style="color:red;">未审</span></s:if>
					</td>
					<td>
						<s:if test="recommend==2"><span style="color:red;">首页</span></s:if>
					</td>
					<td><s:property value="priority" /></td>
					<td>
						<s:if test="imageId>0"><span style="color:red;">有图</span></s:if>
					</td>
					<td>
					<a href="newsUpdate.do?newsId=<s:property value="id"/>"  class="btn btn-primary  btn-small" target='_blank'>编辑</a> &nbsp;
					<a href="newsDelete.do?newsId=<s:property value="id"/>" class="btn btn-danger  btn-small delete" >删除</a></td>
					</tr>
				</s:iterator></tbody>
			</table>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>

