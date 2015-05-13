package controller;


import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import databean.Itinerary;



public class AddFavoriteAction extends Action {

	public AddFavoriteAction() {
		
	}
	
	public String getName() { return "addfavorite.do"; }
    
    public String perform(HttpServletRequest request) {
    	HttpSession session = request.getSession();
    	
    	HashMap<String, String[]> favorite;
    	if (session.getAttribute("favorite") == null) {
    		favorite = new HashMap<String, String[]> ();
    		session.setAttribute("favorite", favorite);
    	} else {
    		favorite = (HashMap<String, String[]>) session.getAttribute("favorite");
    	}
    	
		ArrayList<Itinerary> triplist = (ArrayList<Itinerary>) session.getAttribute("tripresult");
		
		if (triplist.size() > 0) {
			String ori = triplist.get(0).getOrigin();
			String dst = triplist.get(0).getDestination();
			favorite.put(ori + "+" + dst, new String[] { ori, dst });
		}
    	
    	return "triplist.jsp";
    }
        
}
