<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!--  
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
	<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
	<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
	-->
	
	<link rel="stylesheet" href="css/jquery.mobile.css" />
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery.mobile.min.js"></script>
    <script type="text/javascript" src="js/jquery.ui.map.min.js"></script>
	<style>
      #map_canvas {
      	position:absolute; width:50%; height:50%;
      }
    </style>
    
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true"></script>
    <script>
		var directionsDisplay;
		var directionsService = new google.maps.DirectionsService();
		var map;
		var curPosition = new google.maps.LatLng(40.435862,-79.9204454);
		var toPosition = new google.maps.LatLng(40.44417,-79.9433918);

		function initialize() {
  			directionsDisplay = new google.maps.DirectionsRenderer();
  			var mapOptions = {
    			zoom: 14,
    			center: curPosition
  			}
  			map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);
  			directionsDisplay.setMap(map);
  			directionsDisplay.setPanel(document.getElementById('directions-panel'));
  			calcRoute();
		}

		function calcRoute() {
  			//var selectedMode = document.getElementById('mode').value;
  			var request = {
      			origin: curPosition,
      			destination: toPosition,
      			// Note that Javascript allows us to access the constant
      			// using square brackets and a string value as its "property."
      			//travelMode: google.maps.TravelMode[selectedMode]
      			travelMode: google.maps.TravelMode["TRANSIT"]
  			};
  			directionsService.route(request, function(response, status) {
    			if (status == google.maps.DirectionsStatus.OK) {
      				directionsDisplay.setDirections(response);
    			}
  			});
		}

		google.maps.event.addDomListener(window, 'load', initialize);
    </script>
</head>

<body>
		<div data-role="header">
			<h1>Trip Planner</h1>
		</div>

		
		<div data-role="content" id="map_canvas" name="contentMain"></div>
		

		<div data-role="footer" data-position="fixed">
			<div data-role="navbar">
				<ul>
					<li><a href="search.do" data-icon="search">Search</a></li>
					<li><a href="tripplan.do" data-icon="home">Home</a></li>
					<li><a href="account.do" data-icon="info">Account</a></li>
				</ul>
			</div>
		</div>

</body>
</html>