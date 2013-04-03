<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<div class="row">
	<div class="span4">
		<div id="myCarousel" class="carousel slide">
			<ol class="carousel-indicators">
				<s:iterator value="latestImageNews" status="vs">
					<s:if test="#vs.index==0">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					</s:if>
					<s:else>
						<li data-target="#myCarousel" data-slide-to="${vs.index}"></li>
					</s:else>
				</s:iterator>
			</ol>
			<!-- Carousel items -->
			<div class="carousel-inner">
				<s:iterator value="latestImageNews" status="vs">
					<s:if test="#vs.index==0">
						<div class="active item">
							<img class="news-img" src="<s:property value="image.path"/>" />
							<div class="carousel-caption">
								<p class="text-center">
									<a href="news.do?id=${id}">${title}</a>
								</p>
							</div>
						</div>
					</s:if>
					<s:else>
						<div class="item">
							<img class="news-img" src="<s:property value="image.path"/>" />
							<div class="carousel-caption">
								<p class="text-center">
									<a href="news.do?id=${id}">${title}</a>
								</p>
							</div>
						</div>
					</s:else>
				</s:iterator>
			</div>
			<!-- Carousel nav -->
			<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="carousel-control right" href="#myCarousel"
				data-slide="next">&rsaquo;</a>
		</div>
	</div>
	<div class="span8">
		<div>
			<s:iterator value="newsGroups">
				<table class="table table-striped table-bordered right-news">
					<th colspan="2" style="text-align: center"><s:iterator
							value="firsts">
							<a href="news.do?id=${id}">${maxTitle}</a>&nbsp;&nbsp;
					</s:iterator></th>
					</tr>
					<s:iterator value="seconds" status="vs">
						<s:if test="#vs.odd">
							<tr>
						</s:if>
						<td width="50%"><a href="news.do?id=${id}">${maxTitle}</a></td>
						<s:if test="#vs.even || #vs.last">
							</tr>
						</s:if>
					</s:iterator>
				</table>
			</s:iterator>
		</div>
	</div>
</div>