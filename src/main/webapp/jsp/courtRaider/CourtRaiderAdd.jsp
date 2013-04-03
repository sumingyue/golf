<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" courtRaider="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#courtRaiderList').addClass("active");
	$("#form").validate({
		rules : {
			"courtRaider.name" : {
				required : true
			},"courtRaider.indexName" : {
				required : true
			},"upload" : {
				required : true
			},"courtRaider.des" : {
				required : true
			}
		},
		messages : {
			"courtRaider.name" : {
				required : "请输入球道分类"
			},"courtRaider.indexName" : {
				required : "请输入球道顺序"
			},"upload" : {
				required : "请上传球道图片"
			},"courtRaider.des" : {
				required : "请输入球道介绍"
			}
		}
	});
});
</script>
</head>
<body>
  <%@include file="./../Head.jsp"%>
  </br>
  </br>
  <div class="container-fluid">
    <div class="row-fluid">
      <%@include file="./../Menu.jsp"%>
      <div class="span10">
			<h4 style="text-align:center">新增高尔夫俱乐部球道信息</h4>
			<form action="courtRaiderAddSubmit.do" id="form" method="post"  
				enctype="multipart/form-data">
				<table class="table table-striped table-bordered">
					<tr>
						<td class="left"  width="10%">球场<span class='red'>*</span></td>
						<td class="right" colspan="3">
							<s:select name="courtRaider.courtId" id="courtId"
								list="courts" listKey="id" listValue="name"  theme="simple" >
							</s:select>
						</td>
					</tr>
					<tr>
						<td class="left">球道分类<span class='red'>*</span></td>
						<td class="right" colspan="3"><input type="text" size="30" name="courtRaider.type" /></td>
					</tr>
					<s:iterator value="flags" status="vs">
					<tr>
						<td class="left" rowspan="2">球道${1+vs.index}</td>
						<td class="right">顺序<span class='red'>*</span><input type="text" size="10" name="typeIndex" />
						名称<span class='red'>*</span><input type="text" size="20" name="name" />
						图片<span class='red'>*</span><input type="file" name="uploads" id="fileUpload_upload">
						<td></td>
						<td rowspan="2">球道简介<textarea  name="des"  rows="3" cols="30"></textarea></td>
					</tr>
					<tr>
						<td class="right">
						红(码)<span class='red'>*</span><input type="text" size="10" name="indicator1" />
						白(码)<span class='red'>*</span><input type="text" size="10" name="indicator2" />
						蓝(码)<span class='red'>*</span><input type="text" size="10" name="indicator3" />
						金(码)<span class='red'>*</span><input type="text" size="10" name="indicator4" />
						黑(码)<span class='red'>*</span><input type="text" size="10" name="indicator5" /></td>					
					</tr>
					</s:iterator>
					<tr>
						<td colspan="5" style="text-align:center">
							<button type="submit" class="btn btn-primary  btn-normal">提交</button>
					</tr>
					</table>
			</form>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>

