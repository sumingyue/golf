<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/productList.css">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/base.js"></script>
</head>
<body youdao="bind">
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>

		<div class="grid_5">
			<ul class="menu">
				<li class="menu-item">
					<h3>
						<a href="products.do?type=1">球具</a>
					</h3>
					<ul class="submenu clear-fix">
						<s:iterator value="category1" status="vs">
							<li><a href="products.do?id=<s:property value="id"/>"><s:property
										value="name" /></a></li>
						</s:iterator>
					</ul>
				</li>

				<li class="menu-item">
					<h3>
						<a href="products.do?type=2">服饰</a>
					</h3>
					<ul class="submenu clear-fix">
						<ul class="submenu clear-fix">
							<s:iterator value="category2" status="vs">
								<li><a href="products.do?id=<s:property value="id"/>"><s:property
											value="name" /></a></li>
							</s:iterator>
						</ul>
					</ul>
				</li>

				<li class="menu-item">
					<h3>
						<a href="products.do?type=3">用品</a>
					</h3>
					<ul class="submenu clear-fix">
						<ul class="submenu clear-fix">
							<s:iterator value="category3" status="vs">
								<li><a href="products.do?id=<s:property value="id"/>"><s:property
											value="name" /></a></li>
							</s:iterator>
						</ul>
					</ul>
				</li>

				<li class="menu-item">
					<h3>
						<a href="products.do?type=4">附件</a>
					</h3>
					<ul class="submenu clear-fix">
						<ul class="submenu clear-fix">
							<s:iterator value="category4" status="vs">
								<li><a href="products.do?id=<s:property value="id"/>"><s:property
											value="name" /></a></li>
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
			<div class="news-slide" id="slide">
				<div id="slide-container" class="gallery clear-fix">
					<ul class="bigpics clear-fix">
						<li class="bigpic active">
							<h3>Title</h3>
							<p>
								<img class="img-full"
									src="${adwordsService.adwords[23].image.path}" 
									border="0">
							</p>
						</li>
						<li class="bigpic">
							<h3></h3>
							<p>
								<img class="img-full"
									src="${adwordsService.adwords[24].image.path}" 
									border="0">
							</p>
						</li>
						<li class="bigpic">
							<h3></h3>
							<p>
								<img class="img-full"
									src="${adwordsService.adwords[25].image.path}" 
									border="0">
							</p>
						</li>
						<li class="bigpic">
							<h3></h3>
							<p>
								<img class="img-full"
									src="${adwordsService.adwords[26].image.path}"
									border="0">
							</p>
						</li>
					</ul>
					<ul class="smallpics">
						<li class="smallpic active"><a href="${adwordsService.adwords[23].url}" target="_blank"><img
				class="img-full" src="${adwordsService.adwords[23].image.path}"
				border="0"></a></li>
						<li class="smallpic"><a href="${adwordsService.adwords[24].url}" target="_blank"><img
				class="img-full" src="${adwordsService.adwords[24].image.path}"
				border="0"></a></li>
						<li class="smallpic"><a href="${adwordsService.adwords[25].url}" target="_blank"><img
				class="img-full" src="${adwordsService.adwords[25].image.path}"
				border="0"></a></li>
						<li class="smallpic"><a href="${adwordsService.adwords[26].url}" target="_blank"><img
				class="img-full" src="${adwordsService.adwords[26].image.path}"
				border="0"></a></li>
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
				商城位置 <a href="#"> <s:if test="productCategory.type==1">>球具></s:if>
					<s:elseif test="productCategory.type==2">>服饰></s:elseif> <s:elseif
						test="productCategory.type==3">>用品></s:elseif> <s:elseif
						test="productCategory.type==4">>附件></s:elseif>
				</a> <a href="#"><s:property value="productCategory.name" /></a>
			</div>
			<ul class="gallery" id="products">

				<s:iterator value="products" status="vs">
					<li class="image-item"><a
						href="product.do?id=<s:property value="id"/>"><img
							src="<s:property value="image.path"/>" alt="图片"></a>
						<p>
							<span class="label">名称：</span>
							<s:property value="name" />
						</p>
						<p>
							<span class="label">原价：</span>
							<s:property value="price" />
						</p>
						<p>
							<span class="label">会员价：</span>
							<span style="color:#f33;"><s:property value="memberPrice" /></span>
						</p></li>
				</s:iterator>
			</ul>
			<div class="paginate">
				共&nbsp;
				<s:property value="pagedTool.totalNumber" />
				&nbsp;条记录 <a href="?pagedTool.pageIndex=0">首页</a>&nbsp;&nbsp; <a
					href="?pagedTool.pageIndex=<s:property value="pagedTool.pageIndex-1"/>&type=<s:property value="type"/>&id=<s:property value="productCategoryId"/>">上一页</a>&nbsp;&nbsp;
				<a
					href="?pagedTool.pageIndex=<s:property value="pagedTool.pageIndex+1"/>&type=<s:property value="type"/>&id=<s:property value="productCategoryId"/>">下一页</a>&nbsp;&nbsp;
				<a
					href="?pagedTool.pageIndex=<s:property value="pagedTool.totalPage"/>&type=<s:property value="type"/>&id=<s:property value="productCategoryId"/>">末页</a>&nbsp;&nbsp;
				共&nbsp;
				<s:property value="pagedTool.totalPage" />
				&nbsp;页,当前第&nbsp;
				<s:property value="pagedTool.pageIndex" />
				页&nbsp;
				<s:property value="pagedTool.pageSize" />
				条记录/页&nbsp;
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


