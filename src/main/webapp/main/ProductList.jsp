<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="css/base.css">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<style type="text/css">
	.news-slide{float:left;width:750px;}
	.news-article{float:left;width:200px;}
	.gallery{}
	.gallery .bigpics{float:left;}
	.gallery .bigpic{display: none;position: relative;}
	.gallery .bigpic{float:left;}
	.gallery .bigpic img{width:600px;height:400px;}
	.gallery .bigpic h3{position: absolute;bottom:0;background-color: rgba(0,0,0,0.5);width:100%;color:#fff;padding:10px 0;text-align: center;}
	.gallery .bigpics .active{display: block;}
	.gallery .smallpics{float:left;}
	.gallery .smallpic{padding:6px 10px;}
	.gallery .smallpic img{width:130px;height:88px;}
	.gallery .smallpics .active{background-image:url(http://i0.sinaimg.cn/ty/2011hqj/golf/images/sports_golf_zxh_0214_02.png);}
	
		
		.bread-crumbs{padding:10px;background-color:#f5f5f5;margin-top:10px;}
		.mod-inner{
			margin:10px;
		}
		.paginate{
			margin-top:5px;
		}
		.image-item{width:130px;}
		.image-item img{
			width:100%;
		}
		.filter{margin-bottom:8px;}
		.filter .tag{padding:3px;background-color:#F0F7E7;margin-right:5px;}
		.filter .active{background-color:#C2D39F;color:#fff;}
		.menu{padding:10px 0;}
		.menu .menu-item{margin:5px 10px;}
		.menu .menu-item h3{font-size:16px;}
		.menu .submenu li{float:left;margin-right:10px;margin-bottom:5px;}
		
		
		#slide{margin-bottom:10px;}
		#slide .bigpic{display:none;overflow:hidden;height:300px;}
		#slide .bigpic .img-full{width:750px;}
		#slide .active{display:block;}
		#slide .smallpic-list{}
		#slide .smallpic{float:left;cursor:pointer;}
		#slide .smallpic img{width:115px;padding:5px;}
		#slide .smallpic-list .active{background-color:#C2D39F;}
		
		#products img{width:130px;height:75px;}
	</style>
</head>
<body youdao="bind">
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>

<div class="grid_5">
			<ul class="menu">
				<li class="menu-item">
					<h3><a href="?type=1">球具</a></h3>
					<ul class="submenu clear-fix">
						<s:iterator value="category1" status="vs">
							<li><a href="products.do?id=<s:property value="id"/>"><s:property value="name"/></a></li>
						</s:iterator>
					</ul>
				</li>
				
				<li class="menu-item">
					<h3><a href="?type=2">服饰</a></h3>
					<ul class="submenu clear-fix">
					<ul class="submenu clear-fix">
						<s:iterator value="category2" status="vs">
							<li><a href="products.do?id=<s:property value="id"/>"><s:property value="name"/></a></li>
						</s:iterator>
					</ul>
					</ul>
				</li>
				
				<li class="menu-item">
					<h3><a href="?type=3">用品</a></h3>
					<ul class="submenu clear-fix">
					<ul class="submenu clear-fix">
						<s:iterator value="category3" status="vs">
							<li><a href="products.do?id=<s:property value="id"/>"><s:property value="name"/></a></li>
						</s:iterator>
					</ul>
					</ul>
				</li>
				
				<li class="menu-item">
					<h3><a href="?type=4">附件</a></h3>
					<ul class="submenu clear-fix">
					<ul class="submenu clear-fix">
						<s:iterator value="category4" status="vs">
							<li><a href="products.do?id=<s:property value="id"/>"><s:property value="name"/></a></li>
						</s:iterator>
					</ul>
					</ul>
				</li>
			</ul>
			<img src="" alt="广告图" class="img-full" style="height:300px"/>
			<img src="" alt="广告图" class="img-full" style="height:300px"/>
		</div>
		<div class="grid_19">
			<div class="news-slide">
				<div id="slide-container" class="gallery clear-fix">
					<ul class="bigpics clear-fix">
						<li class="bigpic">
							<h3>Title</h3>
							<p><img src="http://i1.sinaimg.cn/ty/golf/idx/2012/1127/U364P6T967D1F29157DT20121127100815.jpg" alt=""></p>
						</li>
						<li class="bigpic">
							<h3>Title</h3>
							<p><img src="http://i1.sinaimg.cn/ty/golf/idx/2012/1127/U364P6T967D1F29149DT20121127160052.jpg" alt=""></p>
						</li>
						<li class="bigpic">
							<h3>Title</h3>
							<p><img src="http://i3.sinaimg.cn/ty/golf/idx/2012/1127/U1340P6T967D1F29161DT20121127071748.jpg" alt=""></p>
						</li>
						<li class="bigpic active">
							<h3>Title</h3>
							<p><img src="http://i0.sinaimg.cn/ty/http/video.sina.com.cn/p/sports/golf/v/2012-11-04/U6083P6T408D122651F8868DT20121104174904.jpg" alt=""></p>
						</li>
					</ul>
					<ul class="smallpics">
						<li class="smallpic"><img src="http://i3.sinaimg.cn/ty/golf/idx/2012/1127/U364P6T967D1F29165DT20121127160052.jpg" alt=""></li>
						<li class="smallpic"><img src="http://i0.sinaimg.cn/ty/golf/idx/2012/1126/U2010P6T967D1F29166DT20121126164618.jpg" alt=""></li>
						<li class="smallpic"><img src="http://i2.sinaimg.cn/ty/golf/idx/2012/1127/U364P6T967D1F29167DT20121127100815.jpg" alt=""></li>
						<li class="smallpic active"><img src="http://i2.sinaimg.cn/ty/golf/idx/2012/1127/U1340P6T967D1F29168DT20121127071748.jpg" alt=""></li>
					</ul>
				</div>
			</div>
			<div class="clear"></div>
			<%-- <div class="filters">
				<div class="filter"><span class="tt">品牌：</span><span class="tag">AAA</span><span class="tag active">AAA</span><span class="tag">AAA</span><span class="tag">AAA</span></div>
				<div class="filter"><span class="tt">价格：</span><span class="tag active">1000以下</span><span class="tag">10000---10000万</span><span class="tag">10000万上</span></div>
				<div class="filter"><span class="tt">类型：</span><span class="tag">套杆</span><span class="tag">推杆</span><span class="tag">球</span><span class="tag">服饰</span><span class="tag">球鞋</span><span class="tag active">防晒产品</span></div>
			</div> --%>
			<div class="bread-crumbs">
					商城位置 <a href="#">
					<s:if test="productCategory.type==1">>球具></s:if>
					<s:elseif test="productCategory.type==2">>服饰></s:elseif>
					<s:elseif test="productCategory.type==3">>用品></s:elseif>
					<s:elseif test="productCategory.type==4">>附件></s:elseif>
					</a>  <a href="#"><s:property value="productCategory.name"/></a> 
			</div>
			<ul class="gallery" id="products">
				
				<s:iterator value="products" status="vs">
					<li class="image-item">
					<a href="pd.do?id=<s:property value="id"/>"><img src="<s:property value="image.path"/>" alt="图片"></a>
					<p href="">名称:<s:property value="name"/></p>
					<p href="">原价：<s:property value="price"/></p>
					<p href="">会员价：<s:property value="memberPrice"/></p>
					</li>
				</s:iterator>
			</ul>
			<div>
				共&nbsp;<s:property value="pagedTool.totalNumber"/>&nbsp;条记录
				<a href="?pagedTool.pageIndex=0">首页</a>&nbsp;&nbsp;
				<a href="?pagedTool.pageIndex=<s:property value="pagedTool.pageIndex-1"/>&type=<s:property value="type"/>&id=<s:property value="productCategoryId"/>">上一页</a>&nbsp;&nbsp;
				<a href="?pagedTool.pageIndex=<s:property value="pagedTool.pageIndex+1"/>&type=<s:property value="type"/>&id=<s:property value="productCategoryId"/>">下一页</a>&nbsp;&nbsp;
				<a href="?pagedTool.pageIndex=<s:property value="pagedTool.totalPage"/>&type=<s:property value="type"/>&id=<s:property value="productCategoryId"/>">末页</a>&nbsp;&nbsp;
				共&nbsp;<s:property value="pagedTool.totalPage"/>&nbsp;页,当前第&nbsp;<s:property value="pagedTool.pageIndex"/>页&nbsp;
				<s:property value="pagedTool.pageSize"/>条记录/页&nbsp;
			</div>
		</div>
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
	<script type="text/javascript">
		new TabPannel({
			container : $("#slide"),
			triggerType : "hover",
			headCS : ".smallpic",
			itemCS : ".bigpic",
			activeCls : "active"
		});
	</script>
</body>
</html>


