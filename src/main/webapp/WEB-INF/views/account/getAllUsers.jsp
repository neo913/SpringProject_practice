<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<div class="body">
			<h1>List of Accounts</h1>	
			<table class="table">
				<tr>
					<th>Id</th><th>email</th><th>password</th><th>name</th>
				</tr>
				
				<c:forEach items="${accounts}" var="accounts">
					<tr>
						<td>${accounts.id}</td>
						<td>${accounts.email}</td>
						<td>${accounts.password}</td>
						<td>${accounts.name}</td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>