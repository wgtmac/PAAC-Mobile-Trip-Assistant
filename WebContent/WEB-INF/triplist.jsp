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
			<h1>Trip</h1>
		</div>

		<div data-role="content">
			<h2>Detail for CMU to UPitts</h2>
			<ul data-role="listview" data-inset="true">
				<li data-role="list-divider">71A <span class="ui-li-count">Arrive
						in 15 min</span></li>
				<li><a href="#">
						<h2>7:17 - 8:04 AM</h2>
						<p>
							<b>71A</b> from <b>Craig St</b> to <b>Forbes Ave</b>
						</p>
						<p class="ui-li-aside">46 min</p>
				</a></li>

				<li data-role="list-divider">71A - 61B <span
					class="ui-li-count">Arrive in 18 min</span></li>
				<li><a href="#">
						<h2>7:17 - 8:04 AM</h2>
						<p>
							<b>71A</b> from <b>Craig St</b> to <b>Forbes Ave</b>
						</p>
						<p>
							<b>61B</b> from <b>Forbes Ave</b> to <b>XXX Ave</b>
						</p>
						<p class="ui-li-aside">46 min</p>
				</a></li>
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