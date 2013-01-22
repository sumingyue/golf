<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<div class="clear"></div>
		<!-- 一行 -->
		<div class="grid_7 slide-list-container" id="slide">
			<ul class="slide-list">
			<s:iterator value="newsLvYou.imageNews" status="vs">
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
			<s:iterator value="newsLvYou.imageNews" status="vs">
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
				<div class="mod-hd"><span class="more"><a href="c.do?id=1" target="_blank">更多</a></span><a href="c.do?id=4" target="_blank">高球旅游</a></div>
				<div class="mod-bd" style="height:240px;">
					<div class="headline">
						<h3 class="mod-hd">
							<a href="news.do?id=<s:property value="newsLvYou.firstNews.id"/>"
								target="_blank"><s:property value="newsLvYou.firstNews.title" /></a>
						</h3>
						<div class="mod-bd">
							<ul class="news-list clear-fix active tab-pannel-item">
								<s:iterator value="newsLvYou.secondNews" status="vs">
									<li class="news-item"><a
										href="news.do?id=<s:property value="id"/>" target="_blank"><s:property
												value="title" /></a></li>
								</s:iterator>
							</ul>
						</div>
					</div>
					<ul class="mod-article-list">
						<s:iterator value="newsLvYou.thirdNews" status="vs">
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
					<h3 class="tab-hd-item active"><a href="sc.do?id=${newsLvYou.smallCategory1.id}" target="_blank">${newsLvYou.smallCategory1.name}</a></h3>
					<h3 class="tab-hd-item"><a href="sc.do?id=${newsLvYou.smallCategory2.id}" target="_blank">${newsLvYou.smallCategory2.name}</a></h3>
					<h3 class="tab-hd-item last"><a href ="sc.do?id=${newsLvYou.smallCategory3.id}" target="_blank">${newsLvYou.smallCategory3.name}</a></h3>
				</div>
				<div class="mod-bd tab-pannel">
					<ul class="active tab-pannel-item mod-article-list">
						<s:iterator value="newsLvYou.smallCategoryNews1" status="vs">
							<li class="article-item small"><a
								href="news.do?id=${id}" target="_blank">${title}</a></li>
						</s:iterator>
					</ul>
					<ul class="tab-pannel-item mod-article-list">
						<s:iterator value="newsLvYou.smallCategoryNews2" status="vs">
							<li class="article-item  small"><a
								href="news.do?id=${id}" target="_blank">${title}</a></li>
						</s:iterator>
					</ul>
					<ul class="tab-pannel-item mod-article-list">
						<s:iterator value="news	.smallCategoryNews3" status="vs">
							<li class="article-item  small"><a
								href="news.do?id=${id}" target="_blank">${title}</a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div class="clear"></div>
