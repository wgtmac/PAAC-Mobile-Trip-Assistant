<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
</head>
<body>


	<div data-role="page" id="search">
		<div data-role="header">
			<h1>Search</h1>
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


			<form method="post" action="search.do">
				<fieldset data-role="collapsible" data-collapsed-icon="arrow-d"
					data-expanded-icon="arrow-u">
					<legend>Bus Stop</legend>
					<p>Search degsinated bus stop</p>
					<label for="busstop">Bus Stop Name</label> <input type="text"
						name="busstop" id="busstop"> <input type="submit"
						data-inline="true" name="action" value="Search Bus Stop">
				</fieldset>
			</form>

			<form method="post" action="searchBusLine.do">
				<fieldset data-role="collapsible" data-collapsed-icon="arrow-d" data-expanded-icon="arrow-u">
					<legend>Bus Line</legend>
					<p>Search degsinated bus line</p>
					<label for="busline">Bus Line Name</label> 
					<input type="text" name="busline" id="busline"> 
					<input type="submit" data-inline="true" name="action" value="Search Bus Line">
				</fieldset>
			</form>

			<form method="post" action="search.do">
				<fieldset data-role="collapsible" data-collapsed-icon="arrow-d"
					data-expanded-icon="arrow-u">
					<legend>Nearby</legend>
					<p>Search bus stops and bus lines nearby</p>
					<input type="submit" data-inline="true" name="action"
						value="Search Nearby">
				</fieldset>
			</form>


		</div>

		<div data-role="footer" data-position="fixed">
			<div data-role="navbar">
				<ul>
					<li><a href="search.do" data-icon="search">Search</a></li>
					<li><a href="tripplan.do" data-icon="home">Home</a></li>
					<li><a href="account.do" data-icon="info">Account</a></li>
				</ul>
			</div>
		</div>
	</div>

</body>
</html>