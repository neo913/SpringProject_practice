<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">


<h2>Social Board</h2>
<hr />
<table class="table artTable">
	<tr style="text-align:center;">
		<th class="odd">Id</th>
		<th class="tnc">Title</th>
		<th class="odd">Writer</th>
		<th>Time</th>
		<th class="odd">Comments</th>
	</tr>
	
	<c:forEach items="${articles}" var="article">
		
			<tr>
				<td class="odd">${article.id}</td>
				<td class="artTitle"><a href="/Article/Detail/${article.id}">${article.title}</a></td>
				<td class="odd">${article.writer.name}</td>
				<td>${article.writeTime }</td>
				<%-- <td class="odd">${fn:length(article.comments}</td> --%>
			</tr>
		
	</c:forEach>
</table>
<a href="/Article/Create"><button class="btn btn-info">New Post</button></a>


	</tiles:putAttribute>
</tiles:insertDefinition>