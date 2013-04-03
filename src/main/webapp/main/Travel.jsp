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
<script type="text/javascript">
	$(document).ready(function() {
		$('#travel').addClass('active');
	});
</script>
</head>
<body>
	<div class="container">
	<jsp:include page="./Head.jsp"></jsp:include>
	<div>
			<ul class="breadcrumb">
				<li>当前位置：</li>
				<li><a href="index.do">首页</a> <span class="divider">/</span></li>
				<li><a href="travels.do">旅游</a> <span class="divider">/</span></li>
				<li class="active">${travel.name}</li>
			</ul>
	</div>	
	<div class="row">
		<div class="span6" style="height:330px">
			<div id="myCarousel" class="carousel slide">
					<ol class="carousel-indicators">
					    <s:iterator value="courtImages" status="vs">
							<s:if test="#vs.index==0">
							 <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							</s:if>
							<s:else>
								<li data-target="#myCarousel" data-slide-to="${vs.index}"></li>
							</s:else>
						</s:iterator>
					  </ol>
					<!-- Carousel items -->
					<div class="carousel-inner">
						<s:iterator value="courtImages" status="vs">
							<s:if test="#vs.index==0">
								<div class="active item">
									<img class="travel-img" src="<s:property value="image.path"/>"  />
									<div class="carousel-caption">
										<p class="text-center"><a href="court.do?id=${court.id}" target="blank">${court.name}</a></p>
									</div>
								</div>
							</s:if>
							<s:else>
								<div class="item">
									<img class="travel-img" src="<s:property value="image.path"/>"  />
									<div class="carousel-caption">
										<p  class="text-center"><a href="court.do?id=${court.id}"  target="blank">${court.name}</a></p>
									</div>
								</div>
							</s:else>
						</s:iterator>
					</div>
					<!-- Carousel nav -->
					<a class="carousel-control left" href="#myCarousel"
						data-slide="prev">&lsaquo;</a> <a class="carousel-control right"
						href="#myCarousel" data-slide="next">&rsaquo;</a>
				</div>
		</div>
		<div class="span6">
			<table class="table table-striped table-bordered table-hover">
					<thead><tr class="center"><td>旅游球场</td></tr>
					<tbody>
							<s:iterator value="courts" status="vs">
								<tr><td><a href="court.do?id=${id}">${name}</a></td></tr>
							</s:iterator>
							</tbody></table>
							
			<table class="table table-striped table-bordered table-hover">
					<thead><tr class="center"><td>最新游记</td></tr>
					<tbody>
							<s:iterator value="travelLogs" status="vs">
								<tr><td><a href="travelLog.do?id=${id}">${title}</a></td></tr>
							</s:iterator>
							</tbody></table>
		</div>
  	</div>
  	<div class="row">
  		<div class="span6">
  			<div id="myCarousel1" class="carousel slide"  style="height:330px">
					<ol class="carousel-indicators">
					    <s:iterator value="hotelImages" status="vs">
							<s:if test="#vs.index==0">
							 <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							</s:if>
							<s:else>
								<li data-target="#myCarousel" data-slide-to="${vs.index}"></li>
							</s:else>
						</s:iterator>
					  </ol>
					<!-- Carousel items -->
					<div class="carousel-inner">
						<s:iterator value="hotelImages" status="vs">
							<s:if test="#vs.index==0">
								<div class="active item">
									<img class="travel-img" src="<s:property value="image.path"/>"  />
									<div class="carousel-caption">
										<p  class="text-center">${travelHotel.name}</p>
									</div>
								</div>
							</s:if>
							<s:else>
								<div class="item">
									<img class="travel-img" src="<s:property value="image.path"/>"  />
									<div class="carousel-caption">
										<p class="text-center">${travelHotel.name}</p>
									</div>
								</div>
							</s:else>
						</s:iterator>
					</div>
					<!-- Carousel nav -->
					<a class="carousel-control left" href="#myCarousel1"
						data-slide="prev">&lsaquo;</a> <a class="carousel-control right"
						href="#myCarousel1" data-slide="next">&rsaquo;</a>
				</div>
  		</div>
  		<div class="span6">
  			<table class="table table-striped table-bordered table-hover" style="height:320px">
					<thead><tr class="center"><td>酒店介绍</td></tr>
					<tbody>
								<tr><td>${travel.travelHotel.des}</td></tr>
							</tbody></table>
  		</div>
  	</div>
  	<table class="table table-striped table-bordered" >
				<thead><tr>
					<th class="center" width="10%">日期</th>
					<th class="center" width="50%">行程介绍</th>
					<th class="center" width="40%">备注事项</th>
				</tr></thead><tbody>
				<s:iterator value="travelPlans" status="vs">
					<tr class="trDetail">
					<td><s:property value="name" /></td>
					<td><s:property value="content" /></td>
					<td><s:property value="des" /></td>
					</tr>
				</s:iterator></tbody>
			</table>
	<jsp:include page="./Foot.jsp"></jsp:include>
    </div>
</body>
</html>
