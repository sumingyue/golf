<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/court.css">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/base.js"></script>

</head>
<body>
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>
		<div class="clear"></div>
		<div class="grid_14">
			<div id="slide" class="slide-list-container">
				<ul class="slide-list">
					<s:iterator value="courtImages" status="vs">
						<s:if test="#vs.index==0">
						<li class="slide-list-item active"><img class="img-full" style="height:350px;"
							src="<s:property value="image.path"/>" /></li>
							</s:if>
						<s:else>
						<li class="slide-list-item"><img class="img-full" style="height:350px;"
							src="<s:property value="image.path"/>" /></li>
							</s:else>
					</s:iterator>
				</ul>
				<ul class="slide-nums">
				<s:iterator value="courtImages" status="vs">
					<s:if test="#vs.index==0">
						<li class="active"><a href="#">${vs.index+1}</a></li>
					</s:if>
					<s:else>
						<li><a href="#">${vs.index+1}</a></li>
					</s:else>
				</s:iterator>		
				</ul>
			</div>
			
			
				<div class="mod-box-horizon" id="xiangxijieshao">
				<div class="mod-hd">详细介绍</div>
				<div class="mod-bd">
					<s:property value="court.customIntro" escape="false" />
				</div>
				</div>
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
								<img src="<s:property value="image.path"/>" style="width:350px;height:350px;"/>
								<p><s:property value="des"/></p>
							</li></s:if>
							<s:else>
							<li class="map">
								<img src="<s:property value="image.path"/>" style="width:350px;height:350px;"/>
								<p><s:property value="des"/></p>
							</li>
							</s:else>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		
		
		<div class="grid_10">
			<div class="mod-box-horizon" id="qiuchangjieshao">
				<div class="mod-hd">球场介绍</div>
				<div class="mod-bd">
					<s:property value="court.introduction" escape="false" />
				</div>
			</div>
			
			<div class="mod-box-horizon" id="pinjiajieshao">
				<div class="mod-hd">评价介绍</div>
				<div class="mod-bd">
					<s:property value="court.awards" escape="false" />
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
		var pannel = new TabPannel({
			container:$("#slide"),
			triggerType:"click",
			headCS:".slide-nums li",
			itemCS:".slide-list-item",
			activeCls:"active"
		});
		
		setInterval(function(){
			var next = pannel.getCurrent()+1;
			if(next==pannel.getTotal()){next = 0}
			pannel.select(next);
		},5000);
		
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
