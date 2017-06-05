<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

	<c:choose>
		<c:when test="${not empty sessionScope.currentAccountInfo}">
			<div class="row">
			<form name="articleEditForm" method="post" action="createArticle">
				
				<div class="form-group">
					<label class="col-sm-1 control-label" for="title">Title: </label>
					<div class="col-sm-6">
						<input class="form-control" name="title" autofocus /><br />
					</div>
				</div>
				<div class="col-sm-12">
					Content:
					<textarea class="form-control" rows="10" name="content"></textarea>
				</div>
				
				<div class="clearfix"></div>
				<div class="blank-20"></div>
				<div class="form-group">
					<div class="col-md-1">
						<input type="submit" value="Post" class="btn btn-primary"/> 
					</div>
					<div class="col-md-offset-10 col-md-1">
						<a href="" onclick="history.back()"><button class="btn btn-default">List</button></a>
					</div>
				</div>
			</form>
			</div>
		
		</c:when>
		<c:otherwise>
			<script>window.location.replace("/Account/SignIn")</script>
		</c:otherwise>
	
	</c:choose>
		



	</tiles:putAttribute>
</tiles:insertDefinition>