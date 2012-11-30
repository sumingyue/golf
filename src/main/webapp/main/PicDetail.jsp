<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
<meta charset="UTF-8">
	<title>苏州高尔夫网</title>
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

			<jsp:include page="./Foot.jsp"></jsp:include>
		</div>
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


