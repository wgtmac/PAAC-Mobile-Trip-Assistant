package controller;

import javax.servlet.http.HttpServletRequest;

public class ShowRoutesOnMapAction extends Action {

	public ShowRoutesOnMapAction() {
		
	}
	
	public String getName() { return "showRoutesOnMap.do"; }
    
    public String perform(HttpServletRequest request) {
    	return "showRoutesOnMap.jsp";
    }
}
