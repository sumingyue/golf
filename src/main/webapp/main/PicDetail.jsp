<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
<meta charset="UTF-8">
<title>苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站</title>
<meta name="Description" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<meta name="Keyword" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">

	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/gallery-detail.css">
	<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="js/base.js"></script>
	<style type="text/css">
	.bigpic-list{
		align:center;
	}
	.bigpic-list .big-pic img{
	width:960px;
	height:960px;
	}
	.smallpic-list .small-pic img{
	width:100px;
	height:100px;
	}
	.smallpic-list .smallpic img{
	width:100px;
	height:100px;
	}
	</style>
</head>
<body>
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>

		<div class="grid_24">
			<div id="gallery" align="center">

				<div id="pan-prev"></div>
				<div id="pan-next"></div>
				<ul class="bigpic-list">
					<s:iterator value="imageSpecialDetails" status="vs">
						<s:if test="#vs.first">
							<li class="big-pic active"><img
								src="<s:property value="image.path"/>" alt=""></li>
							<div>
								<s:property value="imageDes"/>
							</div>
						</s:if>
						<s:else>
							<li class="big-pic"><img
								src="<s:property value="image.path"/>" alt=""></li>

						</s:else>
					</s:iterator>
				</ul>
				<ul class="smallpic-list clear-fix">
					<s:iterator value="imageSpecialDetails">
						<s:if test="#vs.first">
							<li class="small-pic active"><img
								src="<s:property value="image.path"/>" alt=""></li>
						</s:if>
						<s:else>
							<li class="smallpic"><img
								src="<s:property value="image.path"/>" alt=""></li>
						</s:else>
					</s:iterator>
				</ul>
			</div>
			<div>
				<div class="paginate mod-hd">
				共&nbsp;<s:property value="pagedTool.totalNumber"/>&nbsp;条记录
				<a href="?id=<s:property value="id"/>&index=0">首页</a>&nbsp;&nbsp;
				<a href="?id=<s:property value="id"/>&index=<s:property value="pagedTool.pageIndex-1"/>">上一页</a>&nbsp;&nbsp;
				<a href="?id=<s:property value="id"/>&index=<s:property value="pagedTool.pageIndex+1"/>">下一页</a>&nbsp;&nbsp;
				<a href="?id=<s:property value="id"/>&index=<s:property value="pagedTool.totalPage"/>">末页</a>&nbsp;&nbsp;
				共&nbsp;<s:property value="pagedTool.totalPage"/>&nbsp;页,当前第&nbsp;<s:property value="pagedTool.pageIndex"/>页&nbsp;
				<s:property value="pagedTool.pageSize"/>条记录/页&nbsp;
			</div>
			</div>
		</div>
			<jsp:include page="./Foot.jsp"></jsp:include>
		<script type="text/javascript">
		var tabPannel = new TabPannel({
			container:$("#gallery"),
			triggerType:"click",
			headCS:".smallpic",
			itemCS:".big-pic",
			activeCls:"active"
		});

		$("#pan-prev").on("click",function(){
			tabPannel.prev();
		});
	
		$("#pan-next").on("click",function(){
			tabPannel.next();
		});
	</script>
</body>
</html>


