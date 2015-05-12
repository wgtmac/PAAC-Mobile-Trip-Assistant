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


	<div data-role="page" id="home">
		<div data-role="header">
			<h1>Trip Planner</h1>
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
			
<button onclick="getLocation()">Try</button>
<script>
var x=document.getElementById("demo");

function getLocation()
  {
  if (navigator.geolocation)
    {
    navigator.geolocation.getCurrentPosition(showPosition);
    }
  else{x.innerHTML="Geolocation is not supported by this browser.";}
  }
function showPosition(position)
  {
  x.innerHTML="Latitude: " + position.coords.latitude + 
  "<br />Longitude: " + position.coords.longitude;  
  }
</script>



			<form method="post" action="tripplan.do">
				<div data-role="fieldcontain">
					<label for="origin">Origin</label> <input type="text" name="origin"
						id="ori" value="Current Location"> <label
						for="destination">Destination</label> <input type="text"
						name="destination" id="dst"> <input type="hidden"
						name="lat"> <input type="hidden" name="lng">


					</br>

					<fieldset data-role="collapsible" data-collapsed-icon="arrow-d"
						data-expanded-icon="arrow-u">
						<legend>Date/Time</legend>

						<label for="time">Date / Time</label> <input type="datetime-local"
							data-clear-btn="true" name="time" id="time" value=""> <label
							for="type">Type</label> <select name="type" id="type">
							<option value="dep">Departure</option>
							<option value="arr">Arrival</option>
						</select>
					</fieldset>

				</div>
				<input type="submit" data-inline="false" name="action" value="Go">
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