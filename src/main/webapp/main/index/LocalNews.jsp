<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<div class="tabbable tabs-left">
	<!-- Only required for left/right tabs -->
	<ul class="nav nav-tabs">
		<s:iterator value="smallCategories" status="vs">
			<s:if test="vs.index==0">
				<li class="active"><a href="#news-tab${vs.index}"
					data-toggle="tab">${name}</a></li>
			</s:if>
			<s:else>
				<li><a href="#news-tab${vs.index}" data-toggle="tab">${name}</a></li>
			</s:else>
		</s:iterator>
	</ul>
	<div class="tab-content">
		<s:iterator value="localNewsGroups" status="vs">
			<div class="tab-pane" id="news-tab${vs.index}">
				<table class="table table-striped table-bordered">
					<tr><td><div class="row-fluid">
						<s:iterator value="firsts" status="vs">
							<div class="span4">
							<a href="news.do?id=${id}"> <img class="small-img"
									src="${image.path}" /> 
									<p class="text-center">${smallTitle}</p>
							</a></div>
						</s:iterator>
				</div></td></tr></table>
				<table class="table table-striped table-bordered">
					<s:iterator value="seconds" status="vs">
						<s:if test="#vs.odd">
							<tr>
						</s:if>
						<td width="50%"><a href="news.do?id=${id}">${normalTitle}</a></td>
						<s:if test="#vs.even || #vs.last">
							</tr>
						</s:if>
					</s:iterator>
				</table>
			</div>
		</s:iterator>
	</div>
</div>