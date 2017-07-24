<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Menus -->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
		
			<ul class="nav navbar-nav">
				<li>
					<a href="/">Home</a></li>
				<li>
					<a href="/About">About</a></li>
				<li>
					<a href="/Article">Board</a></li>
				
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Lecture <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="dropdown-header">Edward's Fingerstyle</li>
						<li>
							<a href="/">About</a></li>
						<li>
							<a href="/">Lecture</a></li>
						<li role="separator" class="divider"></li>
						<li class="dropdown-header">John's Chord Lab</li>
						<li>
							<a href="/">About</a></li>
						<li>
							<a href="/">Lecture</a></li>
					</ul></li>
					
					<li>
					<a href="/">Event</a></li>
					<li>
					<a href="/Account/ShowList">Admin</a></li>
			</ul>

			<c:choose>
			    <c:when test="${empty sessionScope.currentAccountInfo}">
				    <ul class="nav navbar-nav navbar-right">
						<li>
						<a href="/Account/SignIn">Sign In</a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="nav navbar-nav navbar-right">
				    	<li><a>Welcome! ${sessionScope.currentAccountInfo.getName()}</a></li>
				    	<li><a href="/Account/SignOut">Sign Out</a></li>
				    </ul>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</nav>
