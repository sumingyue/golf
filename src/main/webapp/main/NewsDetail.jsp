<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
<meta charset="UTF-8">
<title>苏州高尔夫网</title>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/newsDetail.css">
</head>
<body>
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>

		<div class="grid_18">

			<div class="mod-box-horizon">
				<div class="mod-hd">
					您当前所在位置：首页 ->
					<s:property value="smallCategory.category.name" />
					->
					<s:property value="smallCategory.name" />
					-> 正文
				</div>
				<div class="mod-bd">
					<div class="article">
						<div class="arc-head">
							<div class="arc-title">
								<s:property value="news.title" />
							</div>
							<div class="arc-info">
								来源：
								<s:property value="news.source" />
								发布时间：
								<s:property value="news.dateStr" />
								编辑：
								<s:property value="news.author" />
							</div>
						</div>
						<div class="arc-content">
							<img src="<s:property value="news.image.path"/>" />
						</div>
						<div class="arc-content">
							<s:property value="news.content" escape="false" />
						</div>
					</div>

					<div class="hot-pic">
						<h3>精选专题</h3>
						<ul class="gallery">
								<s:iterator value="imageSpecials" status="vs">
										<li class="image-item"><img src="${image.path}" alt="图片"> <a
								href="pics.do?id=${id}">${name}</a></li>
								</s:iterator>
						</ul>
					</div>
				</div>
			</div>
			<div class="mod-box-horizon">
				<div class="mod-hd">留言</div>
				<div class="mod-bd">
					<ul class="comment-list">
						<s:iterator value="newsComments" status="vs">
								<li class="article-item"><span class="time"><s:property
											value="content" /></span><a href="#"><s:property
											value="userName" />：</a></li>
							</s:iterator>
					</ul>
					<form action="comment.do" class="form">
						<input type="hidden" size="30" name="comments.newsId" value="<s:property value="news.id" />"/>
						<div class="row">
							<label for="comments.userName">称呼：</label>
							<input class="input l-input" type="text" size="30" name="comments.userName" />
						</div>
						<div class="row">
							<label for="comments.content">内容：</label>
							<textarea  class="input l-input" name="comments.content"  rows="3" cols="40"></textarea>
						</div>
						<div class="row">
							<input type="submit" value="提交" class="btn" />
						</div>
					</form>
				</div>
			</div>

		</div>
		<div class="grid_6">
			<div class="mod-box-horizon">
				<div class="mod-hd">
					热门新闻
				</div>
				<div class="mod-bd">
					<ul class="mod-article-list">
						<s:iterator value="newsHot" status="vs">
							<li class="article-item"><a
								href="news.do?id=${id}" target="_blank">${smallTitle}</a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
			
			<div class="mod-box-horizon">
				<div class="mod-hd">
					最新新闻
				</div>
				<div class="mod-bd">
					<ul class="mod-article-list">
						<s:iterator value="newsLatest" status="vs">
							<li class="article-item"><a
								href="news.do?id=${id}" target="_blank">${smallTitle}</a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
			
			<a href="${adwordsService.adwords[21].url}" target="_blank"><img
				class="adwords-full" src="${adwordsService.adwords[21].image.path}"
				 border="0"></a>
			<a href="${adwordsService.adwords[22].url}" target="_blank"><img
				class="adwords-full" src="${adwordsService.adwords[22].image.path}"
				border="0"></a>
		</div>
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
</body>
</html>


