<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<html>
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
				<h4 style="text-align:center">修改球队信息</h4>
				<form action="teamUpdateSubmit.do" id="form" method="post">
				<table align="center" cellpadding="2" cellspacing="1" width="100%">
					<input type="hidden" name="team.id" value="<s:property value="team.id"/>"/>
					<tr>
						<td class="left" width="30%">球队名称<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="40" name="team.name" value="<s:property value="team.name"/>"/></td>
					</tr>
					<tr>
						<td class="left" width="30%">建队时间<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="40" name="team.setUpTime" value="<s:property value="team.setUpTime"/>"/></td>
					</tr>
					<tr>
						<td class="left" width="30%">首任会长<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="40" name="team.founder" value="<s:property value="team.founder"/>"/></td>
					</tr>
					<tr>
						<td class="left" width="30%">现任会长<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="40" name="team.captain" value="<s:property value="team.captain"/>"/></td>
					</tr>
					<tr>
						<td class="left" width="30%">球队口号<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="78" name="team.slogan" value="<s:property value="team.slogan"/>"/></td>
					</tr>
					<tr>
						<td class="left" width="30%">球队公告<span style='color: red'>*</span></td>
						<td class="right"><textarea  name="team.announcement"  rows="3" cols="80"><s:property value="team.announcement"/></textarea>
						</td>
					</tr>
					<tr>
						<td class="left" width="30%">球队介绍<span style='color: red'>*</span></td>
						<td class="right"><textarea  name="team.introduction"  rows="3" cols="80"><s:property value="team.introduction"/></textarea>
						</td>
					</tr>
					<tr>
						<td class="left" width="30%">球队成员</td>
						<td class="right"><textarea  name="team.members"  rows="3" cols="80"><s:property value="team.members"/></textarea>
						</td>
					</tr>
					<tr>
						<td class="left" width="30%">球队成绩</td>
						<td class="right"><textarea  name="team.achievement"  rows="3" cols="80"><s:property value="team.achievement"/></textarea>
						</td>
					</tr><tr><td colspan="2" align="center"><button type="submit" class="btn">提交</button></tr>
				</table>
			</form>
			<br>
			<table align="center" cellpadding="2" cellspacing="1" width="100%"
					width="95%">
					<tr class="title">
						<td colspan="2">球队Logo图片</td>
					</tr><tr>
						<td width="40%"><img src='<s:property value="team.logo.path"/>'></td>
						<td>
							<form action="updateTeamLogo.do" id="form" method="post"
							enctype="multipart/form-data">
								<input type="hidden" name="teamId" value="<s:property value="team.id"/>"/>
								<input type="file" name="upload"
									id="fileUpload_upload"/>
								<input type="submit" value="提交"/>
							</form>
						</td>
					</tr>
			</table>
			<br>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>
