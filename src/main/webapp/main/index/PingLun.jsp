<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<div class="clear"></div>
		<!-- 一行 -->
		<div class="grid_7">
			<div class="mod-box-horizon tab-list lxctab">
				<div class="mod-hd tab-hd">
					<h3 class="tab-hd-item active"><a href="sc.do?id=${newsPingLun.smallCategory1.id}" target="_blank">${newsPingLun.smallCategory1.name}</a></h3>
					<h3 class="tab-hd-item"><a href="sc.do?id=${newsPingLun.smallCategory2.id}" target="_blank">${newsPingLun.smallCategory2.name}</a></h3>
					<h3 class="tab-hd-item last"><a href ="sc.do?id=${newsPingLun.smallCategory3.id}" target="_blank">${newsPingLun.smallCategory3.name}</a></h3>
				</div>
				<div class="mod-bd tab-pannel">
					<ul class="active tab-pannel-item mod-article-list">
						<s:iterator value="newsPingLun.smallCategoryNews1" status="vs">
							<li class="article-item small"><a
								href="news.do?id=${id}" target="_blank">${title}</a></li>
						</s:iterator>
					</ul>
					<ul class="tab-pannel-item mod-article-list">
						<s:iterator value="newsPingLun.smallCategoryNews2" status="vs">
							<li class="article-item  small"><a
								href="news.do?id=${id}" target="_blank">${title}</a></li>
						</s:iterator>
					</ul>
					<ul class="tab-pannel-item mod-article-list">
						<s:iterator value="newsPingLun.smallCategoryNews3" status="vs">
							<li class="article-item  small"><a
								href="news.do?id=${id}" target="_blank">${title}</a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div class="grid_10">
			<div class="mod-box-horizon mod-box-horizon-last news-block"
				id="jiaodianxinwen">
				<div class="mod-hd"><span class="more"><a href="c.do?id=1" target="_blank">更多</a></span><a href="c.do?id=3" target="_blank">人物评论</a></div>
				<div class="mod-bd" style="height:240px;">
					<div class="headline">
						<h3 class="mod-hd">
							<a href="news.do?id=<s:property value="newsPingLun.firstNews.id"/>"
								target="_blank"><s:property value="newsPingLun.firstNews.maxTitle" /></a>
						</h3>
						<div class="mod-bd">
							<ul class="news-list clear-fix active tab-pannel-item">
								<s:iterator value="newsPingLun.secondNews" status="vs">
									<li class="news-item"><a
										href="news.do?id=<s:property value="id"/>" target="_blank"><s:property
												value="title" /></a></li>
								</s:iterator>
							</ul>
						</div>
					</div>
					<ul class="mod-article-list">
						<s:iterator value="newsPingLun.thirdNews" status="vs">
							<li class="article-item large"><a
								href="news.do?id=<s:property value="id"/>" target="_blank">[<s:property
										value="smallCategory.name" />]&nbsp;&nbsp;<s:property value="title" /></a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div class="grid_7">
			<div class="mod-box-horizon tab-list lxctab">
				<div class="mod-hd tab-hd">
					<h3 class="tab-hd-item active"><a href="sc.do?id=${newsPingLun.smallCategory4.id}" target="_blank">${newsPingLun.smallCategory4.name}</a></h3>
					<h3 class="tab-hd-item"><a href="sc.do?id=${newsPingLun.smallCategory5.id}" target="_blank">${newsPingLun.smallCategory5.name}</a></h3>
					<h3 class="tab-hd-item last"><a href ="sc.do?id=${newsPingLun.smallCategory6.id}" target="_blank">${newsPingLun.smallCategory6.name}</a></h3>
				</div>
				<div class="mod-bd tab-pannel">
					<ul class="active tab-pannel-item mod-article-list">
						<s:iterator value="newsPingLun.smallCategoryNews4" status="vs">
							<li class="article-item small"><a
								href="news.do?id=${id}" target="_blank">${title}</a></li>
						</s:iterator>
					</ul>
					<ul class="tab-pannel-item mod-article-list">
						<s:iterator value="newsPingLun.smallCategoryNews5" status="vs">
							<li class="article-item  small"><a
								href="news.do?id=${id}" target="_blank">${title}</a></li>
						</s:iterator>
					</ul>
					<ul class="tab-pannel-item mod-article-list">
						<s:iterator value="newsPingLun.smallCategoryNews6" status="vs">
							<li class="article-item  small"><a
								href="news.do?id=${id}" target="_blank">${title}</a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div class="clear"></div>
