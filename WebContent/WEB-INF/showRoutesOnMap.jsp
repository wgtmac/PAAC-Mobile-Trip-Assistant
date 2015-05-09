<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Show Routes On Google Map</title>
    <style>
      html, body, #map-canvas {
        height: 100%;
        margin: 0px;
        padding: 0px
      }
      #panel {
        position: absolute;
        top: 5px;
        left: 50%;
        margin-left: -180px;
        z-index: 5;
        background-color: #fff;
        padding: 5px;
        border: 1px solid #999;
      }
    </style>
    
    <style>
      #directions-panel {
        height: 100%;
        float: right;
        width: 390px;
        overflow: auto;
      }

      #map-canvas {
        margin-right: 400px;
      }

      #control {
        background: #fff;
        padding: 5px;
        font-size: 14px;
        font-family: Arial;
        border: 1px solid #ccc;
        box-shadow: 0 2px 2px rgba(33, 33, 33, 0.4);
        display: none;
      }

      @media print {
        #map-canvas {
          height: 500px;
          margin: 0;
        }

        #directions-panel {
          float: none;
          width: auto;
        }
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
  			map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
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
    <div id="panel">
    
    <!--  
    <b>Mode of Travel: </b>
    <select id="mode" onchange="calcRoute();">
      <option value="DRIVING">Driving</option>
      <option value="WALKING">Walking</option>
      <option value="BICYCLING">Bicycling</option>
      <option value="TRANSIT">Transit</option>
    </select>
    -->
    
    </div>
    <div id="directions-panel"></div>
    <div id="map-canvas"></div>
  </body>
</html>