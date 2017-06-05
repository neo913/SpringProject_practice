<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

<!-- <style type="text/css">
	.artTable{	text-align: center;	}
	.tnc{	width: 70%;	}
	th{text-align: center;}
	td{text-align: center;}
	.artTitle{text-align: left;}
	.odd{background-color: #87ceeb;}
</style> -->

<h2>Social Board</h2>
<hr />
<table class="table artTable">
	<c:forEach items="${thisArticle}" var="article">
		<tr style="text-align:center;">
			<th class="odd">ID</th>
			<th class="tnc">Title</th>
			<th class="odd">Writer</th>
			<th>Time</th>
			<th></th>
		</tr>
		<tr class="box">
			<td class="odd">${article.id}</td>
			<td class="artTitle"><a href="./Article/${article.id}/Detail">${article.title}</a></td>
			<td class="odd">${article.writer.name}</td>
			<td>${article.writeTime }</td>
			<td></td>
		</tr>
		<tr>
			<td colspan="4" class="artTitle">${article.content}</td>
		</tr>
		<c:forEach items="${article.comments}" var="comment">
			<tr>
				<td colspan="4">Writer: ${comment.writer} Time: ${comment.writeTime}<br />
				<td colspan="4">${comment.content}
			</tr>
		</c:forEach>
	</c:forEach>
</table>

<%-- 
<c:choose>
	
	<c:when test="${not empty sessionScope.currentAccountInfo }">
		<div class="row">
			<c:forEach items="${thisArticle}" var="article">
		
			</c:forEach>
		</div>
	</c:when>
	
	<c:otherwise>
	
	</c:otherwise>
</c:choose>
 --%>
 
 <div class="form-group">
	<div>
		<a href="" onclick="history.back()"><button class="btn btn-default">List</button></a> 
	</div>
</div>
	</tiles:putAttribute>
</tiles:insertDefinition>