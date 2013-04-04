<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<html xmlns="http://www.w3.org/1999/xhtml"><!-- Real 404 --><head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>404 | 苏州高尔夫网</title>
	<style type="text/css">
		html
		{
			background: #f7f7f7;
		}
		body
		{
			background: #fff;
			color: #333;
			font-family: "MicrosoftYaHei" , "微软雅黑" ,Verdana,Arial;
			margin: 2em auto 0 auto;
			width: 700px;
			padding: 1em 2em;
			-moz-border-radius: 11px;
			-khtml-border-radius: 11px;
			-webkit-border-radius: 11px;
			border-radius: 11px;
			border: 1px solid #dfdfdf;
		}
		a
		{
			color: #2583ad;
			text-decoration: none;
		}
		a:hover
		{
			color: #d54e21;
		}
		h1
		{
			border-bottom: 1px solid #dadada;
			clear: both;
			color: #666;
			margin: 5px 0 5px 0;
			padding: 0;
			padding-bottom: 1px;
		}
		h2
		{
			text-align:center;
			font-size:30px;
			}
		p
		{
			text-align: center;
			font-size:18px;
		}
		div{margin-bottom:80px;}
		ul
		{
			width:400px;
			margin:0 auto;
			}
	</style>
	<script type="text/javascript">
		function gid(id) { return document.getElementById ? document.getElementById(id) : null; }
		function timeDesc() {
			if (all <= 0) {
				self.location = "http://www.dianping.com/";
			}
			var obj = gid("tS");
			if (obj) obj.innerHTML = all + " 秒后";
			all--;
		}
		var all = 8;
		if (all > 0) window.setInterval("timeDesc();", 1000);
	</script>
</head>
<body>
	<h1 id="logo" style="text-align: center">
	<h2><img src="img/err404.gif">操作失败</h2>
	<p>抱歉，你输入的网址可能不正确，或者该网页不存在。</p>
	<div><ul><li><a href="index.do"><span id="tS">4 秒后</span>返回首页</a></li></ul></div>
</body></html>