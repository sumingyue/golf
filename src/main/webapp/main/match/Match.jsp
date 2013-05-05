<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站</title>
<meta name="Description" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<meta name="Keyword" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.override.css" rel="stylesheet">
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#match').addClass('active');

		$('#matchContent a').mouseenter(function (e) {
		  e.preventDefault();
		  $(this).tab('show');
		});
	});
</script>
</head>
<body>
	<div class="container">
		<jsp:include page="./../Head.jsp"></jsp:include>
		<div>
			<ul class="breadcrumb">
				<tr><td>当前位置：</td></tr>
				<tr><td><a href="index.do">首页</a> <span class="divider">/</span></td></tr>
				<li class="active">金熊高尔夫邀请赛</td></tr>
			</ul>
		</div>
		<div class="tabbable tabs-left" id="matchContent">
			<!-- Only required for left/right tabs -->
			<ul class="nav nav-tabs ">
				<li id="tab1" class="active"><a class="text-success"
					data-toggle="tab" href="#tab-content1"><i
						class="icon-chevron-right"></i>赛事概况</a></li>
				<li id="tab2"><a class="text-success" data-toggle="tab"
					href="#tab-content2"><i class="icon-chevron-right"></i>赛事流程</a></li>
				<li id="tab3"><a class="text-success" data-toggle="tab"
					href="#tab-content3"><i class="icon-chevron-right"></i>赞助合作</a></li>
				<li id="tab4"><a class="text-success" data-toggle="tab"
					href="#tab-content4"><i class="icon-chevron-right"></i>合作价值</a></li>
				<li id="tab5"><a class="text-success" data-toggle="tab"
					href="#tab-content5"><i class="icon-chevron-right"></i>联系我们</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="tab-content1">
							<h2 class='text-error text-center'>2013年XXX杯金熊高尔夫邀请赛</h2>
					<table class="table table-striped table-bordered table-hover">
						<tr>
							<td class="muted">赛事主办</td>
							<td>苏州金熊高尔夫管理有限公司</td>
						</tr>
						<tr>
							<td class="muted">赛事协办</td>
							<td>苏州太阳岛高尔夫俱乐部</td>
						</tr>
						<tr>
							<td class="muted">赛事时间</td>
							<td>2013年05月09日 星期四</td>
						</tr>
						<tr>
							<td class="muted">赛事地点</td>
							<td>苏州阳澄湖大道太阳岛高尔夫俱乐部</td>
						</tr>
						<tr>
							<td class="muted">赛事人数</td>
							<td>50 人左右</td>
						</tr>
						<tr>
							<td class="muted">比赛规则</td>
							<td>新新贝利亚</td>
						</tr>
						<tr>
							<td class="muted">开球方式</td>
							<td>18洞同时开球</td>
						</tr>
					</table>
				</div>
				<div class="tab-pane" id="tab-content2">		
					<h2 class='text-error text-center'>2013年XXX杯金熊高尔夫邀请赛</h2>
					<table class="table table-striped table-bordered table-hover ">
					<tr>
						<td class="muted">10：00 </td>
						<td>球员签到</td>
					</tr><tr>
						<td class="muted">11：00</td>
						<td>球场用中餐</td>
					</tr><tr>
						<td class="muted">12：00</td>
						<td>出发台宣布比赛规则、赛前合影、比赛开始</td>
					</tr><tr>
						<td class="muted">17：00</td>
						<td>比赛结束</td>
					</tr><tr>
						<td class="muted">17：30</td>
						<td>收记分卡计算比赛成绩、参赛人员洗漱更衣</td>
					</tr><tr>
						<td class="muted">18：00</td>
						<td>晚宴-太阳岛国际高尔夫俱乐部餐厅</td>
					</tr><tr>
						<td class="muted">18：30</td>
						<td>宴会开始、主办单位、赞助单位致词、抽奖、表演等互动环节，颁奖</td>
					</tr><tr>
						<td class="muted">20：30</td>
						<td>宴会结束</td>
					</tr>
				</table>
				</div>
				<div class="tab-pane" id="tab-content3">
				<h2 class='text-error text-center'>2013年XXX杯金熊高尔夫邀请赛</h2>
				<h4 class='text-warning'>冠名赞助：赞助金额RMB5万元(尊贵一位)</h4>
				<table class="table table-striped table-bordered table-hover  table-condensed">
					<tr><td>1、企业获得活动唯一冠名身份，名称表述为“XX杯苏州金熊高尔夫邀请赛”；</td></tr>
					<tr><td>2、企业名称或Logo出现在活动宣传资料中：签到及颁奖背景板、宣传海报等；</td></tr>
					<tr><td>3、企业可获得对于此次活动的平面、网络、杂志等媒体对赛事的相关报道；</td></tr>
					<tr><td>4、活动现场内设置广告：彩旗、遮阳伞、拱形圆门、易拉宝、发放宣传资料等；</td></tr>
					<tr><td>5、球场发球台广告展板1处（活动当天）；练习推杆果岭旁广告展板1处（活动当天）；</td></tr>
					<tr><td>6、苏州高尔夫网站通栏广告30天；</td></tr>
					<tr><td>7、参赛人员名单；球场内广告牌1个(一个月)；</td></tr>
					<tr><td>8、活动现场产品区一个，供企业做展示推广；</td></tr>
					<tr><td>9、主持人口头鸣谢；</td></tr>
					<tr><td>10、企业代表2名作为贵宾出席比赛开球仪式、颁奖晚宴并致辞（企业介绍限在5分钟内）；</td></tr>
					<tr><td>11、企业将获得免费的贵宾参赛名额2名，由企业自由支配；</td></tr>
					<tr><td>12、其他广告宣传形式可根据赞助商合理要求商讨而定。</td></tr>
				</table>	
				<h4 class='text-warning'>联合赞助：名额不限 金额1万或奖品</h4>
				<table class="table table-striped table-bordered table-hover  table-condensed">
					<tr><td>1、企业名称或Logo以联合赞助的身份出现在活动开球背景板和颁奖背景板；</td></tr>
					<tr><td>2、企业可获得对于此次活动的平面、网络、杂志等媒体的相关报道；</td></tr>
					<tr><td>3、企业可在活动现场内设置产品展示、易拉宝、发放宣传资料等；</td></tr>
					<tr><td>4、主持人口头鸣谢；</td></tr>
					<tr><td>5、企业代表1名作为贵宾出席颁奖晚宴活动。</td></tr>
				</table>
				<h4 class='text-warning'>特别赞助：一杆进洞奖（价值不低于1万元的实物奖品)  尊贵1位</h4>
				<table class="table table-striped table-bordered table-hover  table-condensed">
					<tr><td>1、企业名称或Logo以联合赞助的身份出现在活动开球背景板和颁奖背景板；</td></tr>
					<tr><td>2、企业可获得对于此次活动的平面、网络、杂志等媒体的相关报道；</td></tr>
					<tr><td>3、企业可在活动现场内设置产品展示、易拉宝、发放宣传资料等；</td></tr>
					<tr><td>4、企业可在设置一杆进洞奖的发球台放置广告板1块；</td></tr>
					<tr><td>5、主持人口头鸣谢；</td></tr>
					<tr><td>6、企业代表1名作为贵宾出席颁奖晚宴活动。</td></tr>
				</table>
				</div>
				<div class="tab-pane" id="tab-content4">
				<h2 class='text-error text-center'>2013年XXX杯金熊高尔夫邀请赛</h2>
				<h4 class='text-warning'>1、建立品牌“精致尊贵”的品质形象</h4>
				<p>       高尔夫是注重健康、演绎尊贵、却不失自由、智慧、个性、激情、奇迹的唯美运动，同时还兼容了传统文化的丰厚殷实以及突破创新的博大胸怀，品牌与高尔夫运动的紧密结合可提升其“精致尊贵”的品质形象，与高端品牌业务的宗旨相得益彰；</p>
				<h4 class='text-warning'>2、接触精准高端客户人群，挖掘潜在消费群体</h4>
				<p>       高尔夫运动目前仍为少数人的运动，本次参赛人员均为企业董事长、总经理等高管人员，为当今社会中高端人群，具有超强的消费能力，品牌通过赞助参与本次活动可直接获取潜在高端消费客户，扩大目标客户群；</p>
				<h4 class='text-warning'>3、参与社会活动、提高客户品牌认知度，获得媒体曝光</h4>
				<p>       品牌参与本次活动可以与高端客户建立互动联谊，加强客户对品牌的认知度，品牌与众不同的推广方式，可以获得媒体聚焦，获得巨大的媒体曝光机会。</p>
				
				</div>
				<div class="tab-pane" id="tab-content5">
				<h2 class='text-error text-center'>2013年XXX杯金熊高尔夫邀请赛</h2>
				<table class="table table-striped table-bordered table-hover ">
					<tr><td style='text-align:right'><span class="muted">联系电话</span></td><td><strong>0512-66180078</strong></td></tr>
					<tr><td style='text-align:right'><span class="muted">联系传真</span></td><td><strong>0512-66180079</strong></td></tr>
					<tr><td style='text-align:right'><span class="muted">投稿信箱</span></td><td><strong>szgolfer@163.com</strong></td></tr>
					<tr><td style='text-align:right'><span class="muted">联系地址</span></td><td><strong>苏州市相城区嘉元路悦豪大厦503室</strong></td></tr>
				</table>
				
			</div>
			</div>
		</div>
		<jsp:include page="./../Foot.jsp"></jsp:include>
	</div>
</body>
</html>
