<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">


<h2>Social Board</h2>
<hr />
<div id="main" class="container">
<table class="table artTable">
	<tr style="text-align:center;">
		<th class="col-md-1 odd">Id</th>
		<th class="col-md-8">Title</th>
		<th class="col-md-2 odd">Time</th>
		<th class="col-md-1">Writer</th>
	</tr>
	
	<c:forEach items="${articles}" var="article">
		
			<tr>
				<td class="col-md-1 odd">${article.id}</td>
				<td class="col-md-7 text-left"><a href="/Article/Detail/${article.id}">${article.title} [${fn:length(article.comments)}]</a></td>
				<%-- <td class="odd">${fn:length(article.comments)}</td> --%>
				<td class="col-md-2 odd dateFont">
					<fmt:formatDate type = "both" dateStyle = "medium" timeStyle = "medium" value = "${article.writeTime}" />
				</td>
				<td class="col-md-1">${article.writer.name}</td>
				
				
			</tr>
		
	</c:forEach>
</table>
<a href="/Article/Create"><button class="btn btn-info">New Post</button></a>
</div>


	</tiles:putAttribute>
</tiles:insertDefinition>