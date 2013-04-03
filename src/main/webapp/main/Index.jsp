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
<style type="text/css">
	.news-img{
		width:300px;
		height:380px;
	}
	
	.small-img{
		width:150px;
		height:185px;
	}
	
	.span8 .tabs-left .nav{
		text-align:right;
	}
	
	.right-news  td{
		text-align:center
	}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('#news-tab0').addClass('active');
	});
</script>
</head>
<body>
	<div class="container">
	<jsp:include page="./Head.jsp"></jsp:include>
		<jsp:include page="./index/News.jsp"></jsp:include>
		<div class="row">
				<jsp:include page="./index/Teams.jsp"></jsp:include>
		</div>
		<div class="row">
			<div class="span4">
				<jsp:include page="./index/LocalCourt.jsp"></jsp:include>
			</div>
			<div class="span8">
				<jsp:include page="./index/LocalNews.jsp"></jsp:include>
			</div>
		</div>
	<jsp:include page="./Foot.jsp"></jsp:include>
    </div>
</body>
</html>
