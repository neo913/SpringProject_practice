<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

<h2>Social Board</h2>
<hr />
<table class="table artTable">
	<c:forEach items="${thisArticle}" var="article">
	<c:set var="articleId" value="${article.id}"/>
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

 		<div class="form-group">
			<div class="col-md-1">
				<a href="" onclick="history.back()"><button class="btn btn-default">List</button></a>
			</div>
			<div class="col-md-offset-10 col-md-1">
				<a href="/Article/Delete/${articleId}"><button class="btn btn-default">Delete</button></a>
			</div>
		</div>
		
	</tiles:putAttribute>
</tiles:insertDefinition>