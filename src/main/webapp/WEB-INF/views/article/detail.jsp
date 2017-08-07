<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	pageContext.setAttribute("br", "<br />");
	pageContext.setAttribute("cn", "\n");
%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
	
	<script>
	function commentEditForm(id){
		var original = document.getElementById("comment_"+id).innerHTML;
		var artId = document.getElementById("art_id").innerHTML;
		var writer = document.getElementById("com_"+id+"_name").innerHTML;
		var content = document.getElementById("com_"+id+"_cont").innerHTML;
		var date = document.getElementById("com_"+id+"_date").innerHTML;
		
		var edited = 
			 '<div class="form-group col-sm-1">'
			+'	<b>'+writer+'</b>'
			+'</div>'
			+''
			+'	<form name="editCommentForm" method="post" action="/Comment/Update/'+id+'">'
			+'		<div class="col-sm-8">'
			+'			<input class="form-control" name="content" value="'+content+'"/>'
			+'		</div>'
			+'		<div class="col-sm-1 form-group">'
			+'			<input class="ex lk textBtn" type="submit" value="edit" />'
			+'			<a href="/Article/Detail/'+artId+'" class="ex lk">cancel</a>'
			+'		</div>'
			+'	</form>'
			+''
			+'<div class="com_'+id+'_date" class="col-sm-2">'
			+	'<span class="dateFont_com">'+date+'</span>'
			+'</div>';
		document.getElementById("comment_"+id).innerHTML = edited;
	};
	
	</script>
<h2>Social Board</h2>
<hr />
<div id="main" class="container">
<table class="table artTable">
	<c:forEach items="${thisArticle}" var="article">
	<c:set var="thisArticle" value="${article}"/>
		<tr style="text-align:center;">
			<th class="odd col-md-1">ID</th>
			<th class="col-md-8">Title</th>
			<th class="odd col-md-1">Writer</th>
			<th class="col-md-2">Time</th>
		</tr>
		<tr>
			<td id="art_id" class="odd col-md-1">${article.id}</td>
			<td class="artTitle col-md-8">${article.title}</td>
			<td class="odd col-md-1">${article.writer.name}</td>
			<td class="col-md-2 dateFont">
				<fmt:formatDate type = "both" dateStyle = "medium" timeStyle = "medium" value = "${article.writeTime}" />
			</td>
		</tr>
		<tr>
			<td colspan="4" class="artContent">${fn:replace(article.content, cn, br)}</td>
		</tr>
		<tr>
			<td colspan="4" class="text-left odd"><b>Comments:</b></td>
		</tr>
		<c:forEach items="${comments}" var="comment">
			<tr>
				<td colspan="4">
				<div id="comment_${comment.id}">
					<div id="com_${comment.id}_name" class="form-group col-sm-1">
						<b>${comment.writer.name}:</b>
					</div>
					
					<c:choose>
						<c:when test="${comment.writer.id == sessionScope.currentAccountInfo.id}">
							<div class="col-sm-8 text-left">
								<span id="com_${comment.id}_cont">${fn:replace(comment.content,cn, br)}</span>
							</div>
							<div class="col-sm-1">
								<span>
									<a class="ex lk" onclick="commentEditForm(${comment.id})">edit</a>
									<a href="/Comment/Delete/${comment.id}" class="ex lk">del</a>
								</span>
							</div>
						</c:when>
						<c:otherwise>
							<div class="col-sm-9 text-left">
								${comment.content}
							</div>
							
						</c:otherwise>
					</c:choose>
					
					<div id="com_${comment.id}_date" class="col-sm-2 dateFont_com">
						<span class="dateFont_com">
							<fmt:formatDate type = "both" dateStyle = "medium" timeStyle = "medium" value = "${comment.writeTime}" />
						</span>
					</div>
				</div>
				</td>
			</tr>
		</c:forEach>
			
		<c:choose>
			<c:when test="${not empty sessionScope.currentAccountInfo}">
				<tr>
					<td colspan="4">
						<form name="addCommentForm" method="post" action="${article.id}/addComment">
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
				<a href="/Article/""><button class="btn btn-default">List</button></a>
			</div>
			<c:if test="${thisArticle.writer.id == sessionScope.currentAccountInfo.id}">
				<div class="col-md-offset-9 col-md-1">
					<a href="/Article/Update/${thisArticle.id}"><button class="btn btn-default">Edit</button></a>
				</div>
				<div class="col-md-1">
					<a href="/Article/Delete/${thisArticle.id}"><button class="btn btn-default">Delete</button></a>
				</div>
			</c:if>
		</div>
</div>
	</tiles:putAttribute>		
</tiles:insertDefinition>