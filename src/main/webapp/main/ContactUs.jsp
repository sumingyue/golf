<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html>
<html>
<head>
<title>苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站</title>
<meta name="Description" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<meta name="Keyword" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<meta name="360-site-verification" content="606256f97c999416d747cb9dc422d619" />
<meta name="baidu-site-verification" content="OYcFb2jSwyjNyEuL" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.override.css" rel="stylesheet">
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
	.company-img{
		width:500px;
		height: 700px;
	}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('#contact').addClass('active');
		$('#contactUs a').mouseenter(function (e) {
			  e.preventDefault();
			  $(this).tab('show');
		});
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
				<li class="active">关于我们</li>
			</ul>
		</div>
		
		<div class="tabbable tabs-left">
	<!-- Only required for left/right tabs -->
	<ul class="nav nav-tabs" id="contactUs">
		  <li id="tab1" class="active"><a class="text-success"  data-toggle="tab" href="#tab-content1"><i class="icon-chevron-right"></i>公司介绍</a></li>
          <li id="tab2"><a class="text-success"  data-toggle="tab" href="#tab-content2"><i class="icon-chevron-right"></i> 创业团队</a></li>
          <li id="tab4"><a class="text-success"  data-toggle="tab" href="#tab-content4"><i class="icon-chevron-right"></i>合作伙伴</a></li>
          <li id="tab5"><a class="text-success"  data-toggle="tab" href="#tab-content5"><i class="icon-chevron-right"></i>联系我们</a></li>
	</ul>
	<div class="tab-content">
			<div class="tab-pane active" id="tab-content1">
				<h3 class='text-center text-warning'>苏州金熊高尔夫管理有限公司</h3>
				<h4>公司致力于<span class='text-warning'>高尔夫运动推广和发展</span>，主要服务项目包括</h4>
					<table class="table table-striped table-bordered table-hover ">
					<tr><td><strong>高尔夫俱乐部以及球队管理规划</strong></td></tr>
					<tr><td><strong>高尔夫赛事承办和策划</strong></td></tr>
					<tr><td><strong>高尔夫球场预定和会籍管理</strong></td></tr>
					<tr><td><strong>高尔夫旅游、杂志、媒体</strong></td></tr>
				</table>
				<h4 class='text-center'><span class='text-warning'>世界第一罗里.麦克罗伊见面会</span></h4>
				<img class="full-img" src="company/001.jpg" />
			</div>
			<div class="tab-pane" id="tab-content2">
				<h3 class='text-center text-warning'>创业团队</h3>
				<div>
					<div class="span4">
						<table class="table table-striped table-bordered table-hover">
							<tr>
								<td width="50%" style='text-align:right'><span class="muted">执行董事</span></td>
								<td><strong>刘伟</strong></td>
							</tr>
							<tr>
								<td style='text-align:right'><span class="muted">总经理</span></td>
								<td><strong>谢庆余</strong></td>
							</tr>
							<tr>
								<td style='text-align:right'><span class="muted">助理经理</span></td>
								<td><strong>顾玲玲</strong></td>
							</tr>
							<tr>
								<td style='text-align:right'><span class="muted">技术工程师</span></td>
								<td><strong>尤勇</strong></td>
							</tr>
						</table>
						<table class="table table-striped table-bordered table-hover">
							<tr><td><span class="text-warning">每个人都是自己命运的建筑师！</span></td>
							</tr>		
							<tr><td><span class="text-warning">每天叫醒你的不是闹钟，而是梦想！</span></td><tr>
							<tr><td><span class="text-warning">无限的潜能源于痛苦的历练！</span></td></tr>
							<tr><td><span class="text-warning">学习是人生最重要的投资！</span></td></tr>
							<tr><td><span class="text-warning">一杆已上果岭，抓鸟还会远吗？</span></td></tr>
							<tr><td><span class="text-warning">只要有1％的希望，就要付出100％的努力！</span></td></tr>
							<tr><td><span class="text-warning">敢于梦想，勇于梦想，这个世界属于追梦的人！</span></td></tr>
							<tr><td><span class="text-warning">标准的挥杆，平和的心态，可以使人们产生捕鹰抓鸟的力量！</span></td></tr>
							<tr><td><span class="text-warning">一杆掉入沙坑并不是灾难。总是进沙坑，而救不上果岭，这才是灾难。！</span></td></tr>
							<tr><td><span class="text-warning">既异想天开，又踏实进取，这是高球手该有的风格，让我们在偌大的球场中去完成满意的挥杆吧！</span></td></tr>
							</tr>
						</table>	
					</div>
						<div class="span6">
							<div id="myCarousel" class="carousel slide">
								<ol class="carousel-indicators">
									<li data-target="#myCarousel" data-slide-to="1"></li>
									<li data-target="#myCarousel" data-slide-to="2"></li>
									<li data-target="#myCarousel" data-slide-to="3"></li>
									<li data-target="#myCarousel" data-slide-to="4"></li>
									<li data-target="#myCarousel" data-slide-to="5"></li>
									<li data-target="#myCarousel" data-slide-to="6"></li>
									<li data-target="#myCarousel" data-slide-to="7"></li>
								</ol>
								<!-- Carousel items -->
								<div class="carousel-inner">
									<div class="active item">
										<img class="company-img" src="company/002.jpg" />
										<div class="carousel-caption">
											<p class="text-center"><span class="text-warning">高尔夫世界第一麦克罗伊</span></p>
										</div>
									</div>
									<div class="item">
										<img class="company-img" src="company/004.jpg" />
										<div class="carousel-caption">
											<p class="text-center"><span class="text-warning">2012阿布扎比锦标赛冠军罗伯特.洛克</span></p>
										</div>
									</div>
									<div class="item">
										<img class="company-img" src="company/005.jpg" />
										<div class="carousel-caption">
											<p class="text-center"><span class="text-warning">韩国顶级选手梁容银</span></p>
										</div>
									</div>
									<div class="item">
										<img class="company-img" src="company/006.jpg" />
										<div class="carousel-caption">
											<p class="text-center"><span class="text-warning">著名高尔夫选手汤姆.路易斯</span></p>
										</div>
									</div>
									<div class="item">
										<img class="company-img" src="company/003.jpg" />
										<div class="carousel-caption">
											<p class="text-center"><span class="text-warning">中国一哥.张连伟</span></p>
										</div>
									</div>
								</div>
								<!-- Carousel nav -->
								<a class="carousel-control left" href="#myCarousel"
									data-slide="prev">&lsaquo;</a> <a
									class="carousel-control right" href="#myCarousel"
									data-slide="next">&rsaquo;</a>
							</div>
						</div>
					</div>
				
			</div>
			<div class="tab-pane" id="tab-content4">
				<h3 class='text-center text-warning'>合作伙伴</h3>
				<h4>公司致力于本地高端品牌推广与策划，以促进高端人群合作与共赢。</h4>
				<table class="table table-striped table-bordered table-hover ">
					<tr><td><strong>苏州红尊商贸有限公司</strong></td></tr>
					<tr><td><strong>苏州中兴高尔夫俱乐部</strong></td></tr>
					<tr><td><strong>苏州精英高尔夫俱乐部</strong></td></tr>
				</table>
				<h4 class='text-center'><span class='text-warning'>金熊高尔夫和红尊商贸战略合作</span></h4>
				<img class="full-img"  src="company/007.jpg" />
			</div>
			<div class="tab-pane" id="tab-content5">
				<h3 class='text-center text-warning'>联系我们</h3>
				<table class="table table-striped table-bordered table-hover ">
					<tr><td style='text-align:right'><span class="muted">联系电话</span></td><td><strong>0512-66180078</strong></td></tr>
					<tr><td style='text-align:right'><span class="muted">联系传真</span></td><td><strong>0512-66180079</strong></td></tr>
					<tr><td style='text-align:right'><span class="muted">投稿信箱</span></td><td><strong>szgolfer@163.com</strong></td></tr>
					<tr><td style='text-align:right'><span class="muted">联系地址</span></td><td><strong>苏州市相城区嘉元路悦豪大厦503室</strong></td></tr>
				</table>
				
			</div>
	</div>
	</br>
	<jsp:include page="./Foot.jsp"></jsp:include>
    </div>
</body>
</html>
