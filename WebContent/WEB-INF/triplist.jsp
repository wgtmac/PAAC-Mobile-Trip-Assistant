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

	<div data-role="page" id="triplist">
		<div data-role="header">
		    <a href="tripplan.do" data-role="button">Back</a>
			<h1>Trip</h1>
		</div>

		<div data-role="content">
			<h2>Detail for ${ origin } to ${ dest }</h2>

			<ul data-role="listview" data-inset="true">

				<c:choose>
					<c:when test="${ tripresult.size() == 0 }">
                    <li>
                       <h1>No available buses</h1>
                    </li>
					</c:when>
				</c:choose>

				<c:forEach var="route" items="${tripresult}">
					<li data-role="list-divider">${route.getRouteName()}<span
						class="ui-li-count"> ${ route.getPredTime() } </span>
					</li>
					<li><a href="showRoutesOnMap.do" data-ajax="false"> <c:forEach var="busline"
								items="${route.getRoutes()}">
								<p><b>${busline.getBusline()}: ${busline.getDepartTime()} - ${busline.getArrTime()}</b>
								 (${busline.getDuration()} ${busline.getNumStops()} stops)</p>
								<p>
									Departure: <b>${busline.getOriStop()}</b>
								</p>
								<p>
									Arrival: <b>${busline.getOriStop()}</b>
								</p>
								</br>
							</c:forEach>
							<p class="ui-li-aside">${route.getDuration()}</p>

					</a></li>

				</c:forEach>
			</ul>
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

	<div data-role="page" id="login">
		<div data-role="header">
			<h1>Login</h1>
		</div>

		<div data-role="content">
			<p>Login form here</p>
			Do not have an account? <a href="#register" data-rel="dialog">Register</a>
			here!
		</div>
	</div>

	<div data-role="page" id="register">
		<div data-role="header">
			<h1>Register</h1>
		</div>

		<div data-role="content">
			<p>register form here</p>
			Already have an account? <a href="#login" data-rel="dialog">Login</a>
			here!
		</div>
	</div>



</body>
</html>