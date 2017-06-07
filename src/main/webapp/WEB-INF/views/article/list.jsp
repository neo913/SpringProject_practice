<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">


<h2>Social Board</h2>
<hr />
<div id="main" class="container">
<table class="table artTable">
	<tr style="text-align:center;">
		<th class="odd col-md-1">Id</th>
		<th class="col-md-7">Title</th>
		<th class="col-md-1 odd">Comments</th>
		<th class="col-md-2">Time</th>
		<th class="odd col-md-1">Writer</th>
	</tr>
	
	<c:forEach items="${articles}" var="article">
		
			<tr>
				<td class="odd col-md-1">${article.id}</td>
				<td class="col-md-7 text-left"><a href="/Article/Detail/${article.id}">${article.title}</a></td>
				<td class="odd"><%-- ${fn:length(article.comments} --%></td>
				<td class="col-md-2">${article.writeTime }</td>
				<td class="odd col-md-1">${article.writer.name}</td>
			</tr>
		
	</c:forEach>
</table>
<a href="/Article/Create"><button class="btn btn-info">New Post</button></a>
</div>


	</tiles:putAttribute>
</tiles:insertDefinition>