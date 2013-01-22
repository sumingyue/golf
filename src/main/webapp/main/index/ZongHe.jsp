<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<div class="clear"></div>
		<!-- 一行 -->
		<div class="grid_7 slide-list-container" id="slide">
			<ul class="slide-list">
			<s:iterator value="newsZongHe.imageNews" status="vs">
				<s:if test="#vs.index==0">
					<li class="active slide-list-item"><img class="slide-list-img"
					src="${image.path}"
					alt=""> <a class="slide-list-tit" href="news.do?id=${id}">${maxTitle}</a></li>
				</s:if>
				<s:else>
					<li class="slide-list-item"><img class="slide-list-img"
					src="${image.path}"
					alt=""> <a class="slide-list-tit" href="news.do?id=${id}">${maxTitle}</a></li>
				</s:else>
			</s:iterator>
			</ul>
			<ul class="slide-nums">
			<s:iterator value="newsZongHe.imageNews" status="vs">
				<s:if test="#vs.index==0">
					<li class="active"><a href="#">${vs.index+1}</a></li>
				</s:if>
				<s:else>
					<li><a href="#">${vs.index+1}</a></li>
				</s:else>
			</s:iterator>
			</ul>
		</div>

		<div class="grid_10">
			<div class="mod-box-horizon mod-box-horizon-last news-block"
				id="jiaodianxinwen">
				<div class="mod-hd"><span class="more"><a href="c.do?id=1" target="_blank">更多</a></span><a href="c.do?id=1" target="_blank">综合新闻</a></div>
				<div class="mod-bd" style="height:240px;">
					<div class="headline">
						<h3 class="mod-hd">
							<a href="news.do?id=<s:property value="newsZongHe.firstNews.id"/>"
								target="_blank"><s:property value="newsZongHe.firstNews.title" /></a>
						</h3>
						<div class="mod-bd">
							<ul class="news-list clear-fix active tab-pannel-item">
								<s:iterator value="newsZongHe.secondNews" status="vs">
									<li class="news-item"><a
										href="news.do?id=<s:property value="id"/>" target="_blank"><s:property
												value="title" /></a></li>
								</s:iterator>
							</ul>
						</div>
					</div>
					<ul class="mod-article-list">
						<s:iterator value="newsZongHe.thirdNews" status="vs">
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
					<h3 class="tab-hd-item active"><a href="sc.do?id=${newsZongHe.smallCategory1.id}" target="_blank">${newsZongHe.smallCategory1.name}</a></h3>
					<h3 class="tab-hd-item"><a href="sc.do?id=${newsZongHe.smallCategory2.id}" target="_blank">${newsZongHe.smallCategory2.name}</a></h3>
					<h3 class="tab-hd-item last"><a href ="sc.do?id=${newsZongHe.smallCategory3.id}" target="_blank">${newsZongHe.smallCategory3.name}</a></h3>
				</div>
				<div class="mod-bd tab-pannel">
					<ul class="active tab-pannel-item mod-article-list">
						<s:iterator value="newsZongHe.smallCategoryNews1" status="vs">
							<li class="article-item small"><a
								href="news.do?id=${id}" target="_blank">${title}</a></li>
						</s:iterator>
					</ul>
					<ul class="tab-pannel-item mod-article-list">
						<s:iterator value="newsZongHe.smallCategoryNews2" status="vs">
							<li class="article-item  small"><a
								href="news.do?id=${id}" target="_blank">${title}</a></li>
						</s:iterator>
					</ul>
					<ul class="tab-pannel-item mod-article-list">
						<s:iterator value="newsZongHe.smallCategoryNews3" status="vs">
							<li class="article-item  small"><a
								href="news.do?id=${id}" target="_blank">${title}</a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div class="clear"></div>
