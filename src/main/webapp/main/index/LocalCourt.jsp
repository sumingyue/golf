<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<div class="tabbable">
	<!-- Only required for left/right tabs -->
	<ul class="nav nav-tabs">
		<li class="active"><a class='text-success' href="#tab1" data-toggle="tab"><strong>苏州球场</strong></a></li>
		<li ><a class='text-success' href="#tab2" data-toggle="tab"><strong>苏州练习场</strong></a></li>
		<li><a class='text-success' href="#tab2" data-toggle="tab"><strong>学球机构</strong></a></li>
	</ul>
	<div class="tab-content">
		<div class="tab-pane active" id="tab1">
			<table
				class="table .table-striped table-bordered table-hover .table-condensed">
				<s:iterator value="courts">
					<tr>
						<td><a href="court.do?id=${id}">${name}</a></td>
					</tr>
				</s:iterator>
			</table>
		</div>
		<div class="tab-pane" id="tab2">
			<table
				class="table .table-striped table-bordered table-hover .table-condensed">
				<s:iterator value="drivingRanges">
					<tr>
						<td><a href="court.do?id=${id}">${name}</a></td>
						<td><a href="court.do?id=${id}">${phone}</a></td>
					</tr>
				</s:iterator>
			</table>
		</div>
		<div class="tab-pane" id="tab3">
			<table
				class="table  .table-striped table-bordered table-hover .table-condensed">
				<s:iterator value="learnClubs">
					<tr>
						<td><a href="learnClub.do?id=${id}">${name}</a></td>
						<td><a href="learnClub.do?id=${id}">${phone}</a></td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</div>
</div>