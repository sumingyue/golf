<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US"><head>
	<meta charset="UTF-8">
		<title>苏州高尔夫网</title>
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/news.css">
	<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="js/base.js"></script>
	<style>
		#main-img{
			width:630px;
			height:300px;
		}
		#qiuduigonggao .mod-bd{
			height:263px;
			padding:3px;
			line-height:22px;
		}
		.grid_8 .mod-box-horizon .mod-bd{
			height:200px;
		}
.slide-list .slide-list-item{
	overflow:hidden;
	display:none;
}

.slide-list .active{
	display:block;
}
		.slide-list-container{overflow:hidden;}
#slide-team-home .slide-list-item{
	width:220px;
}

#slide .slide-list-img{
	height: 200px;
	width: 310px;
}
		
	</style>
</head>
<body youdao="bind">
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>
		<div class="clear"></div>
		<div class="grid_16">
			<img id="main-img" src="<s:property value="team.logo.path"/>"/>
		</div>
		<div class="grid_8">
			<div class="mod-box-horizon mod-box-horizon-last" id="qiuduigonggao">
				<div class="mod-hd">球队公告</div>
				<div class="mod-bd">
					<s:property value="team.announcement"/>
				</div>
			</div>
		</div>
		<div class="clear"></div>
		<div class="grid_8 mod-box-horizon-last">
			<div class="mod-box-horizon">
				<div class="mod-hd"><span class="more"><a href="teamNewss.do?teamId=<s:property value="team.id"/>&type=1">更多</a></span>球队新闻</div>
				<div class="mod-bd"><ul class="mod-article-list">
						<s:iterator value="news1" status="vs">
							<li class="article-item"><a href="teamNews.do?teamNewsId=<s:property value="id"/>"><s:property value="title"/></a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div class="grid_8">
			<div class="mod-box-horizon mod-box-horizon-last">
				<div class="mod-hd"><span class="more"><a href="teamNewss.do?teamId=<s:property value="team.id"/>&type=2">更多</a></span>活动报道</div>
				<div class="mod-bd"><ul class="mod-article-list">
						<s:iterator value="news2" status="vs">
							<li class="article-item"><a href="teamNews.do?teamNewsId=<s:property value="id"/>"><s:property value="title"/></a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		
		<div class="grid_8">
			<div class="mod-box-horizon mod-box-horizon-last">
				<div class="mod-hd">球队档案</div>
				<div class="mod-bd">
					<table>
						<tr>
							<td width="40%">建队时间:</td>
							<td><s:property value="team.setUpTime"/></td>
						</tr>
						<tr>
							<td>首任会长:</td>
							<td><s:property value="team.founder"/></td>
						</tr>
						<tr>
							<td>现任会长:</td>
							<td><s:property value="team.captain"/></td>
						</tr>
						<tr>
							<td>成员组成:</td>
							<td><s:property value="team.members"/></td>
						</tr>
						<tr>
							<td>球队口号:</td>
							<td><s:property value="team.slogan"/></td>
						</tr>
						<tr>
							<td>球队战绩</td>
							<td><s:property value="team.achievement"/></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		
		<div class="clear"></div>
		<div class="grid_8">
			<div class="mod-box-horizon mod-box-horizon-last">
				<div class="mod-hd"><span class="more"><a href="teamNewss.do?teamId=<s:property value="team.id"/>&type=3">更多</a></span>月历成绩</div>
				<div class="mod-bd"><ul class="mod-article-list">
						<s:iterator value="news3" status="vs">
							<li class="article-item"><a href="teamNews.do?teamNewsId=<s:property value="id"/>"><s:property value="title"/></a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div class="grid_8">
			<div class="mod-box-horizon mod-box-horizon-last">
				<div class="mod-hd"><span class="more"><a href="teamNewss.do?teamId=<s:property value="team.id"/>&type=4">更多</a></span>精彩图文</div>
				<div class="mod-bd"><ul class="mod-article-list">
						<s:iterator value="news4" status="vs">
							<li class="article-item"><a href="teamNews.do?teamNewsId=<s:property value="id"/>"><s:property value="title"/></a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		
		<div class="grid_8">
			<div class="mod-box-horizon mod-box-horizon-last">
				<div class="mod-hd"><span class="more"><a href="">更多</a></span>球员风采</div>
				<div class="mod-bd slide-list-container" id="slide">
					<ul class="slide-list">
						<li class="active slide-list-item">
							<img class="slide-list-img" src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" alt="">
							<a class="slide-list-tit" href="">title 1</a>
						</li>
						<li class="slide-list-item">
							<img class="slide-list-img" src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" alt="">
							<a class="slide-list-tit" href="">title 2</a>
						</li>
						<li class="slide-list-item">
							<img class="slide-list-img" src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" alt="">
							<a class="slide-list-tit" href="">title 3</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
	<script type="text/javascript">
	$(function(){
		
		var pannel = new TabPannel({
			container:$("#slide"),
			triggerType:"hover",
			itemCS:".slide-list-item",
			activeCls:"active"
		});
		
		var count = 0;
		var total = 3;
		setInterval(function(){
			count++;
			pannel.select(count%total);
		},2000);		
	});
	</script>
</body></html>
