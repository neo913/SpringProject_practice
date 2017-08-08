<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">


<h2>Social Board</h2>
<hr />
<div id="main" class="container">
<div class="artTable">
<table class="table">
	<tr style="text-align:center;">
		<th class="col-md-1 odd">ID</th>
		<th class="col-md-8">Title</th>
		<th class="col-md-1 odd">Writer</th>
		<th class="col-md-2">Time</th>
	</tr>
	
	<c:forEach items="${articles.content}" var="article">
		
			<tr>
				<td class="col-md-1 odd">${article.id}</td>
				<td class="col-md-7 text-left"><a href="/Article/Detail/${article.id}">${article.title} [${fn:length(article.comments)}]</a></td>
				<td class="col-md-1 odd">${article.writer.name}</td>
				<td class="col-md-2 dateFont">
					<fmt:formatDate type = "both" dateStyle = "medium" timeStyle = "medium" value = "${article.writeTime}" />
				</td>
			</tr>
	</c:forEach>
</table>
</div>
<div class="row">
	<div class="col-md-offset-2 col-md-8 pageNumCont" >
		<div class="pageNum">
			<c:if test="${articles.number != 0}">
				<a href="/Article/?page.page=${articles.number}">Prev</a>
			</c:if>
		
		
			<c:forEach begin="1" end="${articles.totalPages}" varStatus="page">
				<c:choose>
					<c:when test="${articles.number+1 == page.count}">
						<a class="pActive" href="/Article/?page.page=${page.count}">${page.count}</a>
					</c:when>
					<c:otherwise>
						<a href="/Article/?page.page=${page.count}">${page.count}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		
			<c:if test="${articles.number != (articles.totalPages-1)}">
				<a href="/Article/?page.page=${articles.number+2}">Next</a>
			</c:if>
		</div>
	</div>
</div>
<div>
	<a href="/Article/Create"><button class="btn btn-info">New Post</button></a>
</div>
</div>


	</tiles:putAttribute>
</tiles:insertDefinition>