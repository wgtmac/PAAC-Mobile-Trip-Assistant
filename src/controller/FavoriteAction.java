package controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.PAAC;

import org.json.JSONException;
import databean.Itinerary;

public class FavoriteAction extends Action {

	public FavoriteAction() {
	}

	public String getName() {
		return "favorite.do";
	}

	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<String> errors = new ArrayList<String>();
		

		try {
			
			String ori = request.getParameter("ori");
			String dst = request.getParameter("dst");

			PAAC paac = new PAAC();
			ArrayList<Itinerary> triplist;
			triplist = paac.getTripPlan(ori, dst, "", true);
			
			if (triplist != null) {
				session.setAttribute("tripresult", triplist);
				session.setAttribute("origin", ori);
				session.setAttribute("dest", dst);
			}

			return "triplist.jsp";
		} catch (UnsupportedEncodingException | JSONException e) {
			errors.add(e.getMessage());
			return "index.jsp";
		}
	}
}
