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

	<div data-role="page" id="triplist">
		<div data-role="header">
		    <a href="tripplan.do" data-role="button">Back</a>
			<h1>Trip</h1>
			<a href="addfavorite.do" data-role="button">Add to Favorite</a>
		</div>

		<div data-role="content">
			<h2>${ origin } --> ${ dest }</h2>

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
								 (${busline.getDuration()} / ${busline.getNumStops()} stops)</p>
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
				
				<li data-role="list-divider">UberX<span
                        class="ui-li-count"> Pickup in 5 min</span>
                </li>
                <li>
                <p><h1>In a hurry? Try Uber!</h1></p>
				<a href="uber.do" data-role="button" data-rel="dialog" data-theme="c">Request A UberX</a>
				</li>
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



</body>
</html>