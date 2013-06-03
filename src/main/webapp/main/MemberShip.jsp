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
		$('#memberShip').addClass('active');
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
			<li class="active">会籍</li>
		</ul>
		<div class="tabbable tabs-left">
	<!-- Only required for left/right tabs -->
	<ul class="nav nav-tabs" id="contactUs">
		  <li id="tab1" class="active"><a class="text-success"  data-toggle="tab" href="#tab-content1"><i class="icon-chevron-right"></i>FGT高尔夫旅游会籍</a></li>
          <li id="tab2"><a class="text-success"  data-toggle="tab" href="#tab-content2"><i class="icon-chevron-right"></i>长江南通高尔夫会籍</a></li>
	</ul>
	<div class="tab-content">
			<div class="tab-pane active" id="tab-content1">
				<h3 class='text-center text-warning'>FGT高尔夫旅游会籍</h3>
				<h4 class='text-success'>产品介绍</h4>
				<ol>
					<li>FGT是Forward Golf Tour Schedule的缩写，是一项旨在推动高尔夫运动健康发展的高尔夫旅游计划。</li>
					<li>朝向高尔夫运动服务有限公司（以下简称“FGT服务公司”），是FGT的创始人和运营服务商。</li>
					<li>FGT加盟球会（以下简称“FGT球会”），拥有18洞或以上球道，是经工商部门正式登记注册的企业法人。所有FGT球会均认可并遵守《FGT章程》。随着FGT的发展，FGT球会的数目和分布或有变化。</li>
					<li>FGT旅游会籍（以下简称“会籍”）是由各FGT球会根据《FGT章程》，合成FGT服务公司提供的全方位的FGT综合服务，限额发行的高尔夫旅游会籍。FGT球会全权委托FGT服务公司对会籍统一包装、整体推广，并按标准化模式集合招募会员。</li>
					<li>FGT服务公司宗旨：为会员搭建高尔夫运动、旅游度假、高端商务及其他休闲康乐活动的平台，并为会员提供包括FGT加盟拓展、FGT订场与交换、FGT会籍销售与管理、FGT旅游度假、FGT赛事、FGT高尔夫用品等服务。</li>
					<li>FGT旅游会籍章程（以下简称“章程”）旨在阐明FGT运营的基本要点，及FGT服务公司和FGT会员各自的基本权益和义务。</li>
				</ol>
				
				<h4 class='text-success'>会籍价值</h4>
				<ol>
					<li>引领高球旅游新生活：FGT旅游会籍成功地将国际上流行的分时度假概念移植到国内的高尔夫市场运作中，通过加盟拓展及组织各种会员活动，带领会员畅享高球旅游新生活. </li>
					<li>高品质一站式会员服务：为会员提供FGT球场加盟、FGT赛事、FGT旅游度假、FGT商城等多项服务，满足会员多样化的需求，为会员旅游打球提供全程管家式服务、提供超值的商务交流和旅游服务.</li>
					<li>升值前景可观：FGT服务公司成立以来，FGT加盟球会的数目呈加速发展的趋势，当FGT经过三到五年时间实现发展至30家以上加盟球会的目标后，FGT旅游会籍的内涵价值将翻倍成长.</li>
					<li>性价比超值：FGT旅游会籍创始入会金额为人民币68000元，会籍四十年有效，每年三十天会员权益，按照一天会员权益只打一场（18洞）计算，平均每场（18洞）果岭费仅为人民币48元，相当超值.</li>
				</ol>
				<h4 class='text-success'>会籍介绍</h4>
				<ol>
					<li>FGT旅游会籍为个人记名会籍，会员每年可在发售会籍的球会享有总共30天（同一天内不计洞数）的会员待遇，不分平假日、不跨年度使用。</li>
					<li>FGT会员可将自己所拥有的每年30天会员权益全部或部分交换到其他FGT加盟球会使用，外出交换到同一异地球会（非本会籍所在球会）的会员权益天数每年不超过8天。</li>
					<li>会员无须为今后FGT球会的增加而追加任何入会费用。</li>
					<li>会员在享用FGT权益时，可偕同三位嘉宾，偕同之嘉宾享有会员嘉宾待遇。</li>
					<li>会员享有参加由FGT服务公司主办的各项联谊活动和赛事的权利，如FGT巡回赛、高尔夫旅游等。</li>
					<li>会籍可转让、继承。</li>
					<li>会籍年限与球会经营年限同期。</li>
				</ol>
				<h4 class='text-success'>会籍价格</h4>
				<p>FGT旅游会籍现阶段的指导价格为6.8万元人民币。</p>
			</div>
			<div class="tab-pane" id="tab-content2">
				<h3 class='text-center text-warning'>南通长江高尔夫会籍</h3>
			</div>
	</div>
	</div>
	<jsp:include page="./Foot.jsp"></jsp:include>
    </div>
</body>
</html>
