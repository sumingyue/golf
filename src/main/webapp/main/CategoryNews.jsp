<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US"><head>
	<title>苏州高尔夫网</title>
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/news.css">
	<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="js/base.js"></script>
</head>
<body youdao="bind">
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>
		<div class="clear"></div>	
		<div class="grid_24">
			<div class="bread-crumbs">
					您当前所在位置：首页 -&gt;
					${category.name}
				</div>
		</div>	
		<div class="grid_24">
			<div id="slidearticles">
				<div class="news-slide">
					<div id="slide-container" class="gallery clear-fix">
						<ul class="bigpics clear-fix">
							<s:iterator value="imageNews" status="vs"> 
								<s:if test="#vs.index==0">
								<li class="bigpic active"></s:if>
								<s:else><li class="bigpic"></s:else>
								<h3><a href="news.do?id=${id}">${maxTitle}</a></h3>
								<p><img src="${image.path}" style="width:500px;height:300px;"></p>
							</li>
							</s:iterator>
						</ul>
						<ul class="smallpics">
							<s:iterator value="imageNews"> 
								<s:if test="#vs.index==0"><li class="smallpic active"></s:if>
								<s:else><li class="smallpic"  ></s:else>
								<a href="news.do?id=${id}"><img src="${image.path}" style="width:62px;height:62px;"></a></li>
							</li>
							</s:iterator>
						</ul>
					</div>
				</div>
				<ul class="news-article">
				
					<s:iterator value="newsGroup"> 
						<li class="headline">
							<h3 class="mod-hd"><a href="news.do?id=${first.id}" target="_blank">${first.maxTitle}</a></h3>
							<div class="mod-bd">
								<ul class="news-list clear-fix active tab-pannel-item">
										<s:iterator value="news"> 
										<li class="news-item"><a href="news.do?id=${id}" target="_blank">${smallTitle }</a></li>
										</s:iterator>
								</ul>
							</div>
						</li>
					</s:iterator>
				</ul>
			</div>
		</div><div class="clear"></div>		
		
		<div class="clear"></div>
		<s:iterator value="categoryNews" status="vs">
		<div class="grid_8">
			<div class="mod-box-horizon">
				<div class="mod-hd"><span class="more"><a href="sc.do?id=<s:property value="smallCategory.id"/>">更多</a></span> 
				<a href="sc.do?id=<s:property value="smallCategory.id"/>"><s:property value="smallCategory.name"/></a> </div>
				<div class="mod-bd"><ul class="mod-article-list">
						<s:iterator value="news" status="vs1">
							<li class="article-item"><a href="news.do?id=<s:property value="id"/>"><s:property value="normalTitle"/></a><span class="time"><s:property value="dateStr"/></span></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<s:if test="#vs.index==2">
		<div class="grid_24">
			<a href="${adwordsService.adwords[20].url}" target="_blank"><img
				class="img-full" src="${adwordsService.adwords[20].image.path}"
				height="90" border="0"></a>
		</div></s:if>
		</s:iterator>
		
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
	<script type="text/javascript">

	var tabPannel = new TabPannel({
		container:$("#slide-container"),
		triggerType:"hover",
		headCS:".smallpic",
		itemCS:".bigpic",
		activeCls:"active"
	});

	</script>
</body></html>
