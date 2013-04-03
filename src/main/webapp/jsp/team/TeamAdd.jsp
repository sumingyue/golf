<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#teamList').addClass("active");
	$("#form").validate({
		rules : {
			"team.name" : {
				required : true
			},
			"team.setUpTime" : {
				required : true
			},
			"team.founder" : {
				required : true
			},
			"team.captain" : {
				required : true
			},
			"team.announcement" : {
				required : true
			},
			"team.introduction" : {
				required : true
			}
		},
		messages : {
			"team.name" : {
				required : "请输入球队名称"
			},
			"team.setUpTime" : {
				required : "请输入成立时间"
			},
			"team.founder" : {
				required : "请输入首任会长"
			},
			"team.captain" : {
				required : "请输入现任会长"
			},
			"team.announcement" : {
				required : "请输入球队公告"
			},
			"team.introduction" : {
				required : "请输入球队介绍"
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
				<form action="teamAddSubmit.do" id="form" method="post">
				<table class="table table-striped table-bordered" width="100%">
					<tr><td colspan='2'>
						<h4 style="text-align:center">新增球队信息</h4>
					</td></tr>
					<tr>
						<td class="left" width="30%">球队名称<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="team.name" /></td>
					</tr>
					<tr>
						<td class="left" width="30%">建队时间<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="team.setUpTime" /></td>
					</tr>
					<tr>
						<td class="left" width="30%">首任会长<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="team.founder" /></td>
					</tr>
					<tr>
						<td class="left" width="30%">现任会长<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="team.captain" /></td>
					</tr>
					<tr>
						<td class="left" width="30%">球队口号<span class='red'>*</span></td>
						<td class="right"><input type="text" size="78" name="team.slogan" /></td>
					</tr>
					<tr>
						<td class="left" width="30%">球队公告<span class='red'>*</span></td>
						<td class="right"><textarea  name="team.announcement"  rows="3" cols="80"></textarea>
						</td>
					</tr>
					<tr>
						<td class="left" width="30%">球队介绍<span class='red'>*</span></td>
						<td class="right"><textarea  name="team.introduction"  rows="3" cols="80"></textarea>
						</td>
					</tr>
					<tr>
						<td class="left" width="30%">球队成员</td>
						<td class="right"><textarea  name="team.members"  rows="3" cols="80"></textarea>
						</td>
					</tr>
					<tr>
						<td class="left" width="30%">球队成绩</td>
						<td class="right"><textarea  name="team.achievement"  rows="4" cols="80"></textarea>
						</td>
					</tr><tr><td colspan="2" style="text-align:center">
						<button type="submit" class="btn btn-primary  btn-large">提交</button></tr>
				</table>
			</form>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>

