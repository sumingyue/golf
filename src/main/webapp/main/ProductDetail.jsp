<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
<meta charset="UTF-8">
	<title>苏州高尔夫网</title>
	<link rel="stylesheet" href="css/base.css">
	<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="js/base.js"></script>
<style type="text/css">
		.mod-inner{
			margin:10px;
		}
		.paginate{
			margin-top:5px;
		}
		.image-item{width:100px;}
		.image-item img{
			width:100%;
		}
		.filter{margin-bottom:8px;}
		.filter .tag{padding:3px;background-color:#F0F7E7;margin-right:5px;}
		.filter .active{background-color:#C2D39F;color:#fff;}

		.menu{background-color:#3A5832;padding:10px 0;}
		.menu .menu-item{margin:5px 10px;}
		.menu .menu-item h3{font-size:16px;}
		.menu .menu-item h3 a{color:#E4CD24;}
		.menu .menu-item a{color:#fff;}
		.menu .submenu li{float:left;margin-right:10px;margin-bottom:5px;}
		
		
		
		#slide{margin-bottom:10px;}
		#slide .bigpic{display:none;width:470px;height:300px;overflow:hidden;}
		#slide .bigpic img{width:470px;height:300px;}
		#slide .active{display:block;}
		#slide .smallpic-list{}
		#slide .smallpic{float:left;cursor:pointer;width:117px;}
		#slide .smallpic img{width:115px;padding:5px;}
		#slide .smallpic-list .active{background-color:#C2D39F;}
		
		.form .input{width:90px;}
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
			<img src="" alt="广告图" class="img-full" />
			<img src="" alt="广告图" class="img-full" />
		</div>
		
		<div class="grid_19">
			<div class="grid_12 alpha">
				<div id="slide">
					<ul>
						<s:iterator value="product.images" status="vs">
							<s:if test="#vs.first">
								<li class="bigpic active">
									<img src="<s:property value="path"/>" alt="大图" class="img-full" />
								</li>
							</s:if>
							<s:else>
								<li class="bigpic">
									<img src="<s:property value="path"/>" alt="大图" class="img-full" />
								</li>
							</s:else>
						</s:iterator>
					</ul>
					<ul class="smallpic-list clear-fix">
					<li class="smallpic active">
							<img src="<s:property value="path"/>" alt="小图" class="img-full" />
						</li><li class="smallpic active">
							<img src="<s:property value="path"/>" alt="小图" class="img-full" />
						</li><li class="smallpic active">
							<img src="<s:property value="path"/>" alt="小图" class="img-full" />
						</li><li class="smallpic active">
							<img src="<s:property value="path"/>" alt="小图" class="img-full" />
						</li>
						
						<!-- 这里只输出四个
						<s:iterator value="product.images" status="vs">
						
							<s:if test="#vs.first">
								<li class="smallpic active">
									<img src="<s:property value="path"/>" alt="小图" class="img-full" />
								</li>
							</s:if>
							<s:else>
								<li class="smallpic">
									<img src="<s:property value="path"/>" alt="大图" class="img-full" />
								</li>
							</s:else>
						</s:iterator>
							 -->
					</ul>
				</div>
			</div>
			<div class="grid_7 omega">
				<table class="table">
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
				<hr style="border:1px dashed #ccc;"/>
				<form class="shop-form form" action="po.do">
					<legend class="legend">订购提交</legend>
					<input type="hidden" name="productOrder.productId" class="input" value='<s:property value="product.id"/>'/>
					<div class="row">
						<label for="f_content">联系人:</label><input type="text" name="productOrder.userName" class="input" />
						<label for="f_mobile">手机:</label><input type="text"  name="productOrder.userPhone" class="input" />
					</div>
					<div class="row">
						<label for="f_num">购买数量:</label><input type="text"  name="productOrder.orderNumber" class="input s-input" />
					</div>
					<div class="row">
						<label for="f_addr">收件地址:</label><input type="text" id="f_addr" name="productOrder.userAddress" class="input" />
					</div>
					<div class="row"><input type="submit" value="提交" class="btn"/></div>
				</form>
			</div>
			<div class="clear"></div>
			<div class="article">
				<h2 class="article-title">产品介绍</h2>
				<div class="article-body">
					<p>
						<s:property value="product.introduction"/>
					</p>
				</div>
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


