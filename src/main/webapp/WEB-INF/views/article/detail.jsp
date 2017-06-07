<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

<h2>Social Board</h2>
<hr />
<div id="main" class="container">
<table class="table artTable">
	<c:forEach items="${thisArticle}" var="article">
	<c:set var="articleId" value="${article.id}"/>
		<tr style="text-align:center;">
			<th class="odd col-md-1">ID</th>
			<th class="col-md-8">Title</th>
			<th class="odd col-md-1">Writer</th>
			<th class="col-md-2">Time</th>
		</tr>
		<tr>
			<td class="odd col-md-1">${article.id}</td>
			<td class="artTitle col-md-8">${article.title}</td>
			<td class="odd col-md-1">${article.writer.name}</td>
			<td class="col-md-2">${article.writeTime }</td>
		</tr>
		<tr>
			<td colspan="4" class="artContent">${article.content}</td>
		</tr>
		<tr>
			<td colspan="4" class="text-left odd"><b>Comments:</b></td>
		</tr>
		<c:forEach items="${article.comments}" var="comment">
			<tr>
				<td colspan="4">
					<div class="form-group col-sm-1">
						${comment.writer.name}:
					</div>
					<div class="col-sm-9 text-left">
						${comment.content}
					</div>
					<div class="form-group col-sm-2">
						${comment.writeTime}
					</div>
				</td>
			</tr>
		</c:forEach>
			
		<c:choose>
			<c:when test="${not empty sessionScope.currentAccountInfo}">
				<tr>
					<td colspan="4">
						<form name="addCommentForm" method="post" action="${articleId}/addComment">
							<div class="form-group">
								<label class="col-sm-1 control-label" for="content">${currentAccountInfo.name}:</label>
							</div>
							<div class="col-sm-10">
								<input class="form-control" name="content"/>
							</div>
							
							<div class="form-group">
								<div class="col-sm-1">
									<input type="submit" value="Post" class="btn btn-info"/>
								</div>
							</div>
						</form>
						</td>
					</tr>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
		
	</c:forEach>
</table>

 		<div class="form-group">
			<div class="col-md-1">
				<a href="" onclick="history.back()"><button class="btn btn-default">List</button></a>
			</div>
			<div class="col-md-offset-9 col-md-1">
				<a href="/Article/Edit/${articleId}"><button class="btn btn-default">Edit</button></a>
			</div>
			<div class="col-md-1">
				<a href="/Article/Delete/${articleId}"><button class="btn btn-default">Delete</button></a>
			</div>
		</div>
</div>
	</tiles:putAttribute>		
</tiles:insertDefinition>