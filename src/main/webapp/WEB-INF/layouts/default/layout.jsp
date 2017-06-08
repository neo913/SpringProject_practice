<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Social Web</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href='https://fonts.googleapis.com/css?family=Spinnaker' rel='stylesheet'>
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
	<link rel="stylesheet" href="<c:url value="/resources/css/mainCss.css" />" />
</head>
<body>
	<div class="main">
		<tiles:insertAttribute name="header" />
		<div>
			<tiles:insertAttribute name="blank" />
			<tiles:insertAttribute name="body" />
		</div>
	</div>
	<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/customJS.js"/>"></script>
</body>
</html>