package controller;

import javax.servlet.http.HttpServletRequest;

public class ShowRoutesOnMapAction extends Action {

	public ShowRoutesOnMapAction() {
		
	}
	
	public String getName() { return "showRoutesOnMap.do"; }
    
    public String perform(HttpServletRequest request) {
    	String curLat = "40.435862";
    	String curLng = "-79.9204454";
    	String destLat = "40.44417";
    	String destLng = "-79.9433918";
    	request.setAttribute("curLat", curLat);
    	request.setAttribute("curLng", curLng);
    	request.setAttribute("destLat", destLat);
    	request.setAttribute("destLng", destLng);
    	
    	return "showRoutesOnMap.jsp";
//    	return "showSelectedRouteOnMap.jsp";
//    	return "testMap2.jsp";
//    	return "showMap.html";
    	
    	
//    	http://maps.googleapis.com/maps/api/directions/json?origin=5860+Bartlett+St+Pittsburgh&destination=5000+Forbes+Ave+Pittsburgh&sensor=false&departure_time&mode=transit
    }
}
