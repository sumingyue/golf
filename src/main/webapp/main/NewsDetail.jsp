<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
<meta charset="UTF-8">
<title>苏州高尔夫网</title>
<link rel="stylesheet" href="css/base.css">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<title></title>
<style type="text/css">
.arc-head {
	text-align: center;
	border-bottom: 1px solid #ccc;
	margin: 0;
}

.arc-title {
	font-size: 18px;
}

.arc-info {
	padding: 5px 0;
}

.arc-content {
	margin: 30px 0;
}
.arc-content img{
	margin:0 auto;
}

.arc-content p {
	margin-bottom: 15px;
	line-height: 22px;
}

.mod-bd {
	padding: 30px;
}

.mod-article-list {
	margin: 10px 0 30px 0;
}

.image-item {
	width: 140px;
}

.grid_6 .img-full{
	height:300px;
}

.comment-list{
	margin-bottom:30px;
}

.comment-list .article-item{
	padding:3px 5px;
	border-bottom:1px dashed #ccc;
}

.comment-list .article-item:after{
	content:"";
	clear:both;
	display:block;
}

.comment-list .article-item a{float:left;color:#930;}
.comment-list .article-item span{}

.hot-pic .gallery img{
	width:150px;
	height:90px;
}

.row{margin-bottom:5px;}
.row{margin-bottom:5px;}
.row .input{border:1px solid #999;width:295px;}
.row label{float:left;}
.row .btn{margin-left:300px;}
</style>
</head>
<body youdao="bind">
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

					<div class="hot-article">
						<h3>热门文章：</h3>
						<ul class="mod-article-list">
							<s:iterator value="hotNews" status="vs">
								<li class="article-item"><a href="#"><s:property
											value="title" /></a><span class="time"><s:property
											value="dateStr" /></span></li>
							</s:iterator>
						</ul>
					</div>

					<div class="hot-pic">
						<h3>精选图片：</h3>
						<ul class="gallery">
							<li class="image-item"><img src="" alt="图片"> <a
								href="">女明星结缘高尔夫走进美丽城堡</a></li>
							<li class="image-item"><img src="" alt="图片"> <a
								href="">胖人打球遭遇尴尬 9条建议5项提醒还您</a></li>
							<li class="image-item"><img src="" alt="图片"> <a
								href="">中信青少年赛 苏州太湖学院大获全胜</a></li>
							<li class="image-item"><img src="" alt="图片"> <a
								href="">旭宝高尔夫情系日本灾区 慈善赛筹款</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="mod-box-horizon">
				<div class="mod-hd">留言</div>
				<div class="mod-bd">
					<ul class="comment-list">
						<s:iterator value="newsComments" status="vs">
								<li class="article-item"><a href="#"><s:property
											value="userName" />：</a><span class="time"><s:property
											value="content" /></span></li>
							</s:iterator>
					</ul>
					<form action="da.do" class="from">
						<input type="hidden" size="30" name="comments.newsId" value="<s:property value="news.id" />"/>
						<div class="row">
							<label for="comments.userName">称呼：</label><input class="input" type="text" size="30" name="comments.userName" />
						</div>
						<div class="row">
							<label for="comments.content">内容：</label>
							<textarea  class="input" name="comments.content"  rows="3" cols="40"></textarea>
						</div>
						<div class="row">
							<input type="submit" value="提交" class="btn" />
						</div>
					</form>
				</div>
			</div>

		</div>
		<div class="grid_6">
			<img src="" alt="图片" class="img-full" />
			<img src="" alt="图片" class="img-full" />
			<img src="" alt="图片" class="img-full" />
		</div>
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
	<script type="text/javascript">
		new TabPannel({
			container : $("#slide"),
			triggerType : "hover",
			headCS : ".smallpic",
			itemCS : ".bigpic",
			activeCls : "active"
		});
	</script>
</body>
</html>


