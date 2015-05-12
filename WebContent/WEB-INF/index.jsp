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
	
	
	
    <script>
    
    
    var options = {
    		  enableHighAccuracy: true,
    		  timeout: 5000,
    		  maximumAge: 0
    		};

    		function success(pos) {
    		  var crd = pos.coords;
    		  
    		  document.getElementById("lat").value= crd.latitude;
    		  document.getElementById("lng").value= crd.longitude;
    		  document.getElementById("ori").value= "Current Location";
    		};

    		function error(err) {
    		  console.warn('ERROR(' + err.code + '): ' + err.message);
    		};

    		function addZero(i) {
    		    if (i < 10) {
    		        i = "0" + i;
    		    }
    		    return i;
    		}
 
    	
        function init() {
            if (navigator.geolocation) {
            	navigator.geolocation.getCurrentPosition(success, error, options);
            } else {
                alert("HTML5 GEO Unsupported");
            }
            
            // get current time
            var date = new Date();
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            if (month >= 1 && month <= 9) {
                month = "0" + month;
            }
            if (strDate >= 0 && strDate <= 9) {
                strDate = "0" + strDate;
            }
            
            // 2015-05-12T15:30
            var currentdate = date.getFullYear() + "-" + month + "-" + strDate
                    + "T" + addZero(date.getHours()) + ":" + addZero(date.getMinutes());
                    
            document.getElementById("datetime").value = currentdate;
        }
    </script>
</head>
<body onload="init()">


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

			<form method="post" action="tripplan.do">
				<div data-role="fieldcontain">
					<label for="origin">Origin</label> 
					<input type="text" name="origin" id="ori"> 
					<label for="destination">Destination</label> 
					<input type="text" name="destination" id="dst"> 
						<input type="hidden" id="lat" name="lat"> 
						<input type="hidden" id="lng" name="lng">
					</br>

					<fieldset data-role="collapsible" data-collapsed-icon="arrow-d"
						data-expanded-icon="arrow-u">
						<legend>Date/Time</legend>
						<label for="datetime">Date / Time</label> 
						<input type="datetime-local" data-clear-btn="true" name="datetime" id="datetime"> 
						<label for="type">Type</label> <select name="type" id="type">
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