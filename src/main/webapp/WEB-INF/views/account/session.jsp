<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
    <c:when test="${empty sessionScope.currentAccountInfo}">
	    <ul class="nav navbar-nav navbar-right">
			<li ng-class='{active:page.getPage(90)}'>
			<a href ng-click='page.setPage(90)'>Sign In</a></li>
		</ul>
	</c:when>
	<c:otherwise>
		<ul class="nav navbar-nav navbar-right">
	    	<li><a>Welcome! ${sessionScope.currentAccountInfo.getName()}</a></li>
	    	<li><a href="./Account/SignOut">Sign Out</a></li>
	    </ul>
	</c:otherwise>
</c:choose>
