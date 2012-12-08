<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/news.css">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<style>
.mod-inner {
	margin: 10px;
}

.paginate {
	margin-top: 5px;
}

.image-item {
	width: 100px;
}

.image-item img {
	width: 100%;
}

.filter {
	margin-bottom: 8px;
}

.filter .tag {
	padding: 3px;
	background-color: #F0F7E7;
	margin-right: 5px;
}

.filter .active {
	background-color: #C2D39F;
	color: #fff;
}

.menu {
	background-color: #3A5832;
	padding: 10px 0;
}

.menu .menu-item {
	margin: 5px 10px;
}

.menu .menu-item h3 {
	font-size: 16px;
}

.menu .menu-item h3 a {
	color: #E4CD24;
}

.menu .menu-item a {
	color: #fff;
}

.menu .submenu li {
	float: left;
	margin-right: 10px;
	margin-bottom: 5px;
}

#slide {
	
}

#slide .bigpic-list {
	height: 300px;
	width: 550px;
}

#slide .bigpic {
	display: none;
	overflow: hidden;
	height: 300px;
	overflow: hidden;
}

#slide .bigpic img {
	height: 300px;
	width: 550px;
}

#slide .bigpic .img-full {
	width: 750px;
}

#slide .active {
	display: block;
}

#slide .smallpic-list {
	height: 90px;
	overflow: hidden;
}

#slide .smallpic {
	float: left;
	cursor: pointer;
	overflow: hidden;
}

#slide .smallpic img {
	width: 127px;
	height: 75px;
	padding: 5px;
}

#slide .smallpic-list .active {
	background-color: #C2D39F;
}

#pinjiajieshao .mod-bd {
	padding: 4px;
	line-height: 22px;
	height: 190px;
}

#qiuchangjieshao .mod-bd {
	padding: 7px;
	line-height: 22px;
	height: 100px;
	overflow: hidden;
}

.content {
	border: 1px solid #aaa;
	padding: 15px;
	margin-bottom: 10px;
}

.comment-list {
	margin-bottom: 30px;
	padding: 10px;
}

.form {
	padding: 10px;
}

.comment-list .article-item {
	padding: 3px 5px;
	border-bottom: 1px dashed #ccc;
}

.comment-list .article-item:after {
	content: "";
	clear: both;
	display: block;
}

.comment-list .article-item a {
	float: left;
	color: #930;
}

.comment-list .article-item span {
	
}

#xincheluxian {
	
}

#xincheluxian .table {
	border: none;
	margin: 5px;
}

#xincheluxian .table td {
	border: none;
	padding: 5px;
}

#xincheluxian tr {
	margin-bottom: 5px;
}

#xincheluxian table .item {
	border: 1px solid #ccc;
	background-color:#f5f5f5;
	padding: 1px;
}

#xincheluxian .maps {
	border-top:1px dashed #ccc;
	padding: 6px;
}


#xincheluxian .maps img{
	float:left;
	margin-right:10px;
}

#xincheluxian .maps .map {
	display: none;
	height: 200px;
}

#xincheluxian .maps .active {
	display: block;
}

#qiuchangluxian {
	
}

#qiuchangluxian img{
	width:377px;
	margin-bottom:5px;
}

#qiuchangluxian .mod-bd {
	padding: 5px;
	line-height: 22px;
}

.row label {
	float: left;
}
</style>

</head>
<body youdao="bind">
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>
		<div class="clear"></div>
		<div class="grid_14">
			<div id="slide">
				<ul class="bigpic-list">
					<s:iterator value="courtImages" status="vs">
						<s:if test="#vs.index==0">
						<li class="bigpic active"><img class="img-full"
							src="<s:property value="image.path"/>" /></li>
							</s:if>
						<s:else>
						<li class="bigpic"><img class="img-full"
							src="<s:property value="image.path"/>" /></li>
							</s:else>
					</s:iterator>
				</ul>
				<ul class="smallpic-list clear-fix">
				<s:iterator value="courtImages" status="vs">
						<s:if test="#vs.index==0">
						<li class="smallpic active"><img class="img-full"
							src="<s:property value="image.path"/>" /></li>
							</s:if>
						<s:else>
						<li class="smallpic"><img class="img-full"
							src="<s:property value="image.path"/>" /></li>
							</s:else>
					</s:iterator>		
				</ul>
			</div>
		</div>
		<div class="grid_10">
			<div class="mod-box-horizon" id="qiuchangjieshao">
				<div class="mod-hd">球场介绍</div>
				<div class="mod-bd">
					<s:property value="court.introduction" escape="false" />
				</div>
			</div>
			
			<div class="mod-box-horizon mod-box-horizon-last" id="pinjiajieshao">
				<div class="mod-hd">评价介绍</div>
				<div class="mod-bd">
					<s:property value="court.awards" escape="false" />
				</div>
			</div>
		</div>
		<div class="clear"></div>
		<div class="grid_14">
			<div class="mod-box-horizon" id="xincheluxian">
				<div class="mod-hd">球道路线</div>
				<div class="mod-bd">
					<table class="table">
						<s:iterator value="groups" status="vs">
							<tr>
								<td style="width: 10%"><s:property value="name" /></td>
								<td><s:iterator value="index" status="vs">
										<a href="#" class="item"><s:property /></a>
									</s:iterator></td>
							</tr>
						</s:iterator>
					</table>
					<ul class="maps">
						<s:iterator value="all" status="vs">
							<s:if test="#vs.index==0">
							<li class="active map">
								<img src="<s:property value="image.path"/>" style="width:200px;height:200px;"/>
								<p>内容内容</p>
							</li></s:if>
							<s:else>
							<li class="map">
								<img src="<s:property value="image.path"/>" style="width:200px;height:200px;"/>
								<p>内容内容</p>
							</li>
							</s:else>
						</s:iterator>
					</ul>
				</div>
			</div>
			
			
			<div class="mod-box-horizon">
				<div class="mod-hd">最新评论</div>
				<div class="mod-bd">
					<ul class="comment-list">
						<s:iterator value="courtComments" status="vs">
							<li class="article-item"><a href="#"><s:property
											value="userName" />：</a><span class="time"><s:property
											value="content" /></span></li>
						</s:iterator>
					</ul>
					<form action="courtComment.do" class="form">
						<input type="hidden" size="30" name="comments.courtId"
							value="<s:property value="court.id" />" />
						<div class="row">
							<label for="comments.userName">称呼：</label><input class="input l-input"
								type="text" size="30" name="comments.userName" />
						</div>
						<div class="row">
							<label for="comments.content">内容：</label>
							<textarea class="input l-input" name="comments.content" rows="3"
								cols="40"></textarea>
						</div>
						<div class="row">
							<input type="submit" value="提交" class="btn" style="margin-left:250px;" />
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="grid_10">
			<div class="mod-box-horizon">
				<div class="mod-hd">详细介绍</div>
				<div class="mod-bd">
					<s:property value="court.customIntro" escape="false" />
				</div>
			</div>
			<div class="mod-box-horizon mod-box-horizon-last" id="qiuchangluxian">
				<div class="mod-hd">球场路线</div>
				<div class="mod-bd">
					<img src="<s:property value="court.mapImage.path"/>" />
					<s:property value="court.mapIntroduction" />
				</div>
			</div>
		</div>
		<jsp:include page="./Foot.jsp"></jsp:include>

		<script type="text/javascript">
		new TabPannel({
			container : $("#slide"),
			triggerType : "hover",
			headCS : ".smallpic",
			itemCS : ".bigpic",
			activeCls : "active"
		});
		
		new TabPannel({
			container : $("#xincheluxian"),
			triggerType : "hover",
			headCS : "table .item",
			itemCS : ".map",
			activeCls : "active"
		});
	</script>
</body>
</html>
