<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
    <script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
  </head>
<body>

<div data-role="page" id="home">
  <div data-role="header">
    <h1>Trip Planner</h1>
  </div>

  <div data-role="content">
    <form method="post" action="??">
      <div data-role="fieldcontain">
        <label for="ori">Origin</label>
        <input type="text" name="ori" id="ori">
        <label for="dst">Destination</label>
        <input type="text" name="dst" id="dst">

        </br>

        <fieldset data-role="collapsible" data-collapsed-icon="arrow-d" data-expanded-icon="arrow-u">
          <legend>Date/Time</legend>
          
          <label for="datetime-4">Date / Time</label>
          <input type="datetime-local" data-clear-btn="true" name="datetime-4" id="datetime-4" value="">

          <label for="type">Type</label>
          <select name="type" id="type">
            <option value="dep">Departure</option>
            <option value="arr">Arrival</option>
          </select>
        </fieldset>

      </div>
      <input type="submit" data-inline="false" name="go" value="Go">
    </form>
  </div>

  <div data-role="footer" data-position="fixed">
    <div data-role="navbar">
      <ul>
        <li><a href="#search" data-icon="search">Search</a></li>
        <li><a href="#home" data-icon="home" >Home</a></li>
        <li><a href="#account" data-icon="info">Account</a></li>
      </ul>
    </div>
  </div>
</div> 


<div data-role="page" id="search">
  <div data-role="header">
    <h1>Search</h1>
  </div>

  <div data-role="content">


    <form method="post" action="??">
      <fieldset data-role="collapsible" data-collapsed-icon="arrow-d" data-expanded-icon="arrow-u">
        <legend>Bus Stop</legend>
          <p>Search degsinated bus stop</p>
          <label for="busstop">Bus Stop Name</label>
          <input type="text" name="busstop" id="busstop">
        <input type="submit" data-inline="true" name="search_stop" value="Search">
      </fieldset>
    </form>

    <form method="post" action="??">
      <fieldset data-role="collapsible" data-collapsed-icon="arrow-d" data-expanded-icon="arrow-u">
        <legend>Bus Line</legend>
          <p>Search degsinated bus line</p>
          <label for="busline">Bus Line Name</label>
          <input type="text" name="busline" id="busline">
        <input type="submit" data-inline="true" name="search_line" value="Search">
      </fieldset>
    </form>

    <form method="post" action="??">
      <fieldset data-role="collapsible" data-collapsed-icon="arrow-d" data-expanded-icon="arrow-u">
        <legend>Nearby</legend>
          <p>Search bus stops and bus lines nearby</p>
        <input type="submit" data-inline="true" name="search_nearby" value="Search">
      </fieldset>
    </form>


  </div>

  <div data-role="footer" data-position="fixed">
    <div data-role="navbar">
      <ul>
        <li><a href="#search"  data-icon="search">Search </a></li>
        <li><a href="#home"    data-icon="home"  >Home   </a></li>
        <li><a href="#account" data-icon="info"  >Account</a></li>
      </ul>
    </div>
  </div>
</div> 


<div data-role="page" id="account">

  <div data-role="header">
    <a href="#" data-role="button" >Sign Out</a>
    <h1>Account</h1>
    <a href="#login" data-role="button" data-rel="dialog">Login/Register</a>
  </div>

  <div data-role="content">
    <div class="content-primary">
       <h2>Some text here</h2>
    </div>
    <div class="content-secondary">
    <ul data-role="listview">
      <li><a href="#">Setting</a></li>
      <li><a href="#">Favorites</a></li>
      <li><a href="#">About</a></li>
    </ul>
    </div>
  </div>

  <div data-role="footer" data-position="fixed" >
    <div data-role="navbar">
      <ul>
        <li><a href="#search" data-icon="search">Search</a></li>
        <li><a href="#home" data-icon="home" >Home</a></li>
        <li><a href="#account" data-icon="info">Account</a></li>
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
    Do not have an account? <a href="#register" data-rel="dialog">Register</a> here!
  </div>
</div> 

<div data-role="page" id="register">
  <div data-role="header">
    <h1>Register</h1>
  </div>

  <div data-role="content">
    <p>register form here</p>
    Already have an account? <a href="#login" data-rel="dialog">Login</a> here!
  </div>
</div> 



</body>
</html>