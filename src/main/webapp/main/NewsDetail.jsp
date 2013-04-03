<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html>
<html>
<head>
<title>苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站</title>
<meta name="Description" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<meta name="Keyword" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.override.css" rel="stylesheet">
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<jsp:include page="./Head.jsp"></jsp:include>
	<div>
		<ul class="breadcrumb">
			<li>当前位置：</li>
			<li><a href="index.do">首页</a> <span class="divider">/</span></li>
			<li><a href="c.do?categoryId=${smallCategory.category.id}"><s:property value="smallCategory.category.name" /></a>
				<span class="divider">/</span></li>
			<li><a href="sc.do?id=${smallCategory.id}"><s:property value="smallCategory.name" /></a>
				<span class="divider">/</span></li>
			<li class="active">正文</li>
		</ul>
	</div>
	<div class="row">
	<div class="span8">
		<table class=" table-bordered"><tr><td>
			<h3 class="text-center">
				<s:property value="news.title" />
			</h3>
			<h5 class="text-center">
				来源：
				<s:property value="news.source" />
				发布时间：
				<s:property value="news.dateStr" />
				编辑：
				<s:property value="news.author" />
			</h5>
			<div class="text-center">
				<img src="<s:property value="news.image.path"/>" />
			</div>
			<div class="arc-content">
				<s:property value="news.content" escape="false" />
			</div></td></tr></table>
		</div>
		<div class="span4">
			<div class="tabbable">
				<!-- Only required for left/right tabs -->
				<ul class="nav nav-tabs">
					<li class="active"><a href="#tab1" data-toggle="tab">最新新闻</a></li>
					<li><a href="#tab2" data-toggle="tab">热门新闻</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="tab1">
					<table class="table table-striped table-bordered table-hover" width="100%">
						<s:iterator value="newsLatest" status="vs"><tr>
							<td><a href="news.do?id=${id}" target="_blank">${title}</a></td>
						</tr></s:iterator>
					</table>
					</div>
					<div class="tab-pane" id="tab2">
					<table class="table table-striped table-bordered  table-hover" width="100%">
						<s:iterator value="newsHot" status="vs"><tr>
							<td><a href="news.do?id=${id}" target="_blank">${title}</a></td>
						</tr></s:iterator>
					</table>
			</div>
		</div></div>
		</br>
		<div width="100%">
			<h4 class="breadcrumb title ">用户留言</h4>
			<table class="table table-striped table-bordered  table-hover" width="100%">
				<thead><tr><th width="20%">用户</th><th width="80%">留言</th></tr></thead>
				<tbody>
				<s:iterator value="newsComments" status="vs">
					<tr><td style="word-break:break-all">${userName}</td><td style="word-break:break-all">${content}</td></tr>
					</s:iterator></tbody>
			</table>
		</div>
		<div>
			<form action="comment.do" class="form-horizontal">
				<input type="hidden" size="20" name="comments.newsId" value="<s:property value="news.id" />"/>
				<div class="control-group comment">
					<label class="control-label" for="comments.userName">称呼</label>
					<div class="controls">
					<input type="text" size="20" placeholder="用户昵称" name="comments.userName" />
				</div></div>
				<div class="control-group comment">
					<label class="control-label" for="comments.content">内容</label>
					<div class="controls">
					<textarea  name="comments.content" placeholder="您的评论"  rows="3" cols="30"></textarea>
				</div></div>
				<div class="control-group comment">
			    <div class="controls">
			      <button type="submit" class="btn btn-primary">提交</button>
			    </div>
			  </div>
			</form>
		</div>
		<div>
		</div>
	</div></div>
	<jsp:include page="./Foot.jsp"></jsp:include>
    </div>
</body>
</html>




