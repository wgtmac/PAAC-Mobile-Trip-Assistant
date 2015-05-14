<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1" />

<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
</head>
<body>


	<div data-role="page" id="search">
		<div data-role="header">
			<h1>Search Busline</h1>
		</div>

		<div data-role="content">

			<c:choose>
				<c:when test="${ (empty msg) }">
				</c:when>
				<c:otherwise>
					<h3 style="color: blue">${msg}</h3>
				</c:otherwise>
			</c:choose>

			<c:forEach var="error" items="${errors}">
				<h3 style="color: red">${error}</h3>
			</c:forEach>



			<form method="post" action="searchBusLine.do">
				<fieldset>
					<h1>Get all bus stops</h1>
					<label for="busline">Bus Line Name</label> 
					<input type="text" name="busline" id="busline"> 
					<input type="submit" name="action" value="Search Bus Line">
				</fieldset>
			</form>


		</div>

		<div data-role="footer" data-position="fixed">
			<div data-role="navbar">
				<ul>
                    <li><a href="search.do" data-icon="search" data-ajax="false">Search</a></li>
                    <li><a href="tripplan.do" data-icon="home" data-ajax="false">Home</a></li>
                    <li><a href="account.do" data-icon="info" data-ajax="false">Account</a></li>
				</ul>
			</div>
		</div>
	</div>

</body>
</html>