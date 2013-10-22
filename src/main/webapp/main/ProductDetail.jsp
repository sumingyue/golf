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
	<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="js/base.js"></script>
<style type="text/css">
		.mod-inner{
			margin:10px;
		}
		.image-item{width:100px;}
		.image-item img{
			width:100%;
		}
		.filter{margin-bottom:8px;}
		.filter .tag{padding:3px;background-color:#F0F7E7;margin-right:5px;}
		.filter .active{background-color:#C2D39F;color:#fff;}


		.menu{padding:10px 0;}
		.menu .menu-item{margin:5px 10px;}
		.menu .menu-item h3{font-size:16px;}
		.menu .submenu li{float:left;margin-bottom:5px;}
		.menu .submenu li a{_margin-left:5px;}
		
		.image-link {
			display: block;
			margin-bottom: 10px;
		}
		
		#slide .slide-list-img{
			height:325px;
			width:430px;
		}
		
	</style>
</head>
<body youdao="bind">
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>

<div class="grid_5">
			<ul class="menu">
				<li class="menu-item">
					<h3><a href="products.do?type=1">球具</a></h3>
					<ul class="submenu clear-fix">
						<s:iterator value="category1" status="vs">
							<li><a href="products.do?id=<s:property value="id"/>"><s:property value="name"/></a></li>
						</s:iterator>
					</ul>
				</li>
				
				<li class="menu-item">
					<h3><a href="products.do?type=2">服饰</a></h3>
					<ul class="submenu clear-fix">
					<ul class="submenu clear-fix">
						<s:iterator value="category2" status="vs">
							<li><a href="products.do?id=<s:property value="id"/>"><s:property value="name"/></a></li>
						</s:iterator>
					</ul>
					</ul>
				</li>
				
				<li class="menu-item">
					<h3><a href="products.do?type=3">用品</a></h3>
					<ul class="submenu clear-fix">
					<ul class="submenu clear-fix">
						<s:iterator value="category3" status="vs">
							<li><a href="products.do?id=<s:property value="id"/>"><s:property value="name"/></a></li>
						</s:iterator>
					</ul>
					</ul>
				</li>
				
				<li class="menu-item">
					<h3><a href="products.do?type=4">附件</a></h3>
					<ul class="submenu clear-fix">
					<ul class="submenu clear-fix">
						<s:iterator value="category4" status="vs">
							<li><a href="products.do?id=<s:property value="id"/>"><s:property value="name"/></a></li>
						</s:iterator>
					</ul>
					</ul>
				</li>
			</ul>
			<a class="image-link" href="${adwordsService.adwords[27].url}" target="_blank"><img
				class="img-full" src="${adwordsService.adwords[27].image.path}"
				border="0" style="height: 300px" ></a>
			<a class="image-link" href="${adwordsService.adwords[28].url}" target="_blank"><img
				class="img-full" src="${adwordsService.adwords[28].image.path}"
				border="0" style="height: 300px" ></a>
		</div>
		
		<div class="grid_19">
			<div class="grid_11 alpha">
			
			
				<div id="slide" class="slide-list-container">
					<ul class="slide-list">
					<s:iterator value="product.images" status="vs">
						<s:if test="#vs.first">
							<li class="active slide-list-item">
								<img class="slide-list-img" src="<s:property value="path"/>" alt="大图${vs.index}" class="img-full" />
								<a class="slide-list-tit" href="#"></a>
							</li>
						</s:if>
						<s:else>
							<li class="slide-list-item">
								<img class="slide-list-img" src="<s:property value="path"/>" alt="大图${vs.index}" class="img-full" />
								<a class="slide-list-tit" href="#"></a>
							</li>
						</s:else>
					</s:iterator>
					</ul>
					<ul class="slide-nums">
					<s:iterator value="product.images" status="vs">
						<s:if test="#vs.index==0">
							<li class="active"><a href="#">${vs.index+1}</a></li>
						</s:if>
						<s:else>
							<li><a href="#">${vs.index+1}</a></li>
						</s:else>
					</s:iterator>
					</ul>
				</div>
			</div>
			<div class="grid_8 omega">
				<table class="table" style="margin-bottom:6px;">
					<tr>
						<td colspan=2>名称:<s:property value="product.name"/></td>
					</tr>
					<tr>
						<td>所属品牌:<s:property value="product.name"/></td>
						<td>单位:<s:property value="product.unit"/></td>
					</tr>
					<tr>
						<td colspan=2>适用:<s:property value="product.crowd"/></td>
					</tr>
					<tr>
						<td colspan=2>适合人群:<s:property value="product.crowd"/></td>
					</tr>
					<tr>
						<td colspan=2>杆身材质:<s:property value="product.material"/></td>
					</tr>
					<tr>
						<td colspan=2>本站价格:<s:property value="product.price"/></td>
					</tr>
					<tr>
						<td colspan=2>会员价格:<s:property value="product.memberPrice"/></td>
					</tr>
				</table>
				<form class="shop-form form" action="orderProduct.do">
					<legend class="legend">订购提交</legend>
					<input readonly type="hidden" name="productOrder.productId" class="input" value='<s:property value="product.id"/>'/>
					<div class="row">
						<label for="f_content">联系人:</label><input readonly type="text" name="productOrder.userName" class="input" />
					</div>
					<div class="row">
						<label for="f_mobile">手机:</label><input readonly type="text"  name="productOrder.userPhone" class="input" />
					</div>
					<div class="row">
						<label for="f_num">购买数量:</label><input readonly type="text"  name="productOrder.orderNumber" class="input s-input" />
					</div>
					<div class="row">
						<label for="f_addr">收件地址:</label><input readonly type="text" id="f_addr" name="productOrder.userAddress" class="input l-input" />
					</div>
					<div class="row"><input readonly type="submit" value="提交" class="btn"/></div>
				</form>
			</div>
			<div class="clear"></div>
			<div class="article">
				<div class="bread-crumbs">产品介绍</div>
				<div class="article-body">
					<p>
						<s:property value="product.introduction"/>
					</p>
				</div>
			</div>
		</div>
		
			<div class="clear"></div>
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
	<script type="text/javascript">
	(function(){
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
		
		$(".side-banner .close").click(function(){
			$(this).parent().remove();
			return false;
		});
	})();
	</script>
</body>
</html>


