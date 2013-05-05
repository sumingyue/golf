<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<div>
	<table class="table table-striped table-bordered">
		<tr><td colspan='4'><h3 style="line-height:15px">
		<a href="match.do"><p class="text-error text-center">苏州金熊高尔夫邀请赛启动</p></a></h3></td></tr>
		<tr><td class="muted">比赛时间</td><td class='text-warning'>2013年05月16日</td><td class="muted">比赛地点</td><td class='text-warning'>苏州金鸡湖高尔夫俱乐部</td></tr>
		<tr><td class="muted">报名电话</td><td class='text-warning'>0512-66180078</td><td class="muted">报名地点</td><td class='text-warning'>苏州相城区嘉元路悦豪大厦503室</td></tr>
	</table>
	<p>
</div>
				
<div class="tabbable tabs-left">
	<!-- Only required for left/right tabs -->
	<ul class="nav nav-tabs alert-info" id="localNews">
		<s:iterator value="smallCategories" status="vs">
			<li id="smallCatogory${vs.index}" ><a class="text-success" href="#news-tab${vs.index}" data-toggle="tab"><strong>${name}</strong></a></li>
		</s:iterator>
	</ul>
	<div class="tab-content">
		<s:iterator value="localNewsGroups" status="vs">
			<div class="tab-pane" id="news-tab${vs.index}">
				<div class="row-fluid">
					<div class="span3">
						<s:iterator value="firsts" status="vs">
							<a href="news.do?id=${id}"> <img class="small-img" title="${title}"
									src="${image.path}" /> 
							</a>
							<p style="height:3px;"></p>
						</s:iterator>
					</div>
					<div class="span9">
						<table class="table table-striped table-bordered table-condensed">
						<s:iterator value="seconds" status="vs">
								<tr>
									<td><a href="news.do?id=${id}">${title}</a></td>
								</tr>
						</s:iterator>
				</table>
					</div>
				</div>
			
				<%-- <table class="table table-striped table-bordered">
					<tr><td><div class="row-fluid">
						<s:iterator value="firsts" status="vs">
							<div class="span4">
							<a href="news.do?id=${id}"> <img class="small-img"
									src="${image.path}" /> 
									<p class="text-center">${smallTitle}</p>
							</a></div>
						</s:iterator>
				</div></td></tr></table> --%>
				
			</div>
		</s:iterator>
	</div>
</div>