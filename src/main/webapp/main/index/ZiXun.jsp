<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<div class="clear"></div>
<div class="grid_8">
	<div class="mod-box-horizon tab-list lxctab">
		<div class="mod-hd tab-hd">
			<h3 class="tab-hd-item zixun active"><a href="sc.do?id=${newsZiXun.smallCategory1.id}" target="_blank">${newsZiXun.smallCategory1.name}</a></h3>
			<h3 class="tab-hd-item zixun"><a href="sc.do?id=${newsZiXun.smallCategory2.id}" target="_blank">${newsZiXun.smallCategory2.name}</a></h3>
			<h3 class="tab-hd-item zixun last"><a href ="sc.do?id=${newsZiXun.smallCategory3.id}" target="_blank">${newsZiXun.smallCategory3.name}</a></h3>
		</div>
		<div class="mod-bd tab-pannel">
			<ul class="active tab-pannel-item mod-article-list">
				<s:iterator value="newsZiXun.smallCategoryNews1" status="vs">
					<li class="article-item small"><a
						href="news.do?id=${id}" target="_blank">${title}</a></li>
				</s:iterator>
			</ul>
			<ul class="tab-pannel-item mod-article-list">
				<s:iterator value="newsZiXun.smallCategoryNews2" status="vs">
					<li class="article-item  small"><a
						href="news.do?id=${id}" target="_blank">${title}</a></li>
				</s:iterator>
			</ul>
			<ul class="tab-pannel-item mod-article-list">
				<s:iterator value="newsZiXun.smallCategoryNews3" status="vs">
					<li class="article-item  small"><a
						href="news.do?id=${id}" target="_blank">${title}</a></li>
				</s:iterator>
			</ul>
		</div>
	</div>
</div>
<div class="grid_8">
	<div class="mod-box-horizon tab-list lxctab">
		<div class="mod-hd tab-hd">
			<h3 class="tab-hd-item zixun active"><a href="sc.do?id=${newsZiXun.smallCategory4.id}" target="_blank">${newsZiXun.smallCategory4.name}</a></h3>
			<h3 class="tab-hd-item zixun"><a href="sc.do?id=${newsZiXun.smallCategory5.id}" target="_blank">${newsZiXun.smallCategory5.name}</a></h3>
			<h3 class="tab-hd-item zixun last"><a href ="sc.do?id=${newsZiXun.smallCategory6.id}" target="_blank">${newsZiXun.smallCategory6.name}</a></h3>
		</div>
		<div class="mod-bd tab-pannel">
			<ul class="active tab-pannel-item mod-article-list">
				<s:iterator value="newsZiXun.smallCategoryNews4" status="vs">
					<li class="article-item small"><a
						href="news.do?id=${id}" target="_blank">${title}</a></li>
				</s:iterator>
			</ul>
			<ul class="tab-pannel-item mod-article-list">
				<s:iterator value="newsZiXun.smallCategoryNews5" status="vs">
					<li class="article-item  small"><a
						href="news.do?id=${id}" target="_blank">${title}</a></li>
				</s:iterator>
			</ul>
			<ul class="tab-pannel-item mod-article-list">
				<s:iterator value="newsZiXun.smallCategoryNews6" status="vs">
					<li class="article-item  small"><a
						href="news.do?id=${id}" target="_blank">${title}</a></li>
				</s:iterator>
			</ul>
		</div>
	</div>
</div>
<div class="grid_8">
	<div class="mod-box-horizon tab-list lxctab">
		<div class="mod-hd tab-hd">
			<h3 class="tab-hd-item zixun active"><a href="sc.do?id=${newsZiXun.smallCategory7.id}" target="_blank">${newsZiXun.smallCategory7.name}</a></h3>
			<h3 class="tab-hd-item zixun"><a href="sc.do?id=${newsZiXun.smallCategory8.id}" target="_blank">${newsZiXun.smallCategory8.name}</a></h3>
			<h3 class="tab-hd-item zixun last"><a href ="sc.do?id=${newsZiXun.smallCategory9.id}" target="_blank">${newsZiXun.smallCategory9.name}</a></h3>
		</div>
		<div class="mod-bd tab-pannel">
			<ul class="active tab-pannel-item mod-article-list">
				<s:iterator value="newsZiXun.smallCategoryNews7" status="vs">
					<li class="article-item small"><a
						href="news.do?id=${id}" target="_blank">${title}</a></li>
				</s:iterator>
			</ul>
			<ul class="tab-pannel-item mod-article-list">
				<s:iterator value="newsZiXun.smallCategoryNews8" status="vs">
					<li class="article-item  small"><a
						href="news.do?id=${id}" target="_blank">${title}</a></li>
				</s:iterator>
			</ul>
			<ul class="tab-pannel-item mod-article-list">
				<s:iterator value="newsZiXun.smallCategoryNews9" status="vs">
					<li class="article-item  small"><a
						href="news.do?id=${id}" target="_blank">${title}</a></li>
				</s:iterator>
			</ul>
		</div>
	</div>
</div>
<div class="clear"></div>
