package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.xpath.XPathExpressionException;

import model.PAAC;

import org.json.JSONException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;
import org.xml.sax.SAXException;

import databean.Itinerary;
import formbean.TripPlanForm;

public class TripPlanAction extends Action {
	private FormBeanFactory<TripPlanForm> formBeanFactory = FormBeanFactory
			.getInstance(TripPlanForm.class);

	public TripPlanAction() {
	}

	public String getName() {
		return "tripplan.do";
	}

	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {
			
			TripPlanForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);

			if (!form.isPresent()) {
				return "index.jsp";
			}

			// Any validation errors?
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "index.jsp";
			}
			
			String origin = form.getOrigin();
			if (origin.equals("Current Location")) {
				String lat = (String) request.getParameter("lat");
				String lng = (String) request.getParameter("lng");
				
				PAAC p = new PAAC();
				String addr = p.getCurrAddress(Double.parseDouble(lat), Double.parseDouble(lng));
				System.out.println(addr);
				origin = addr;
			}


			PAAC paac = new PAAC();
			ArrayList<Itinerary> triplist;
			triplist = paac.getTripPlan(origin, form.getDestination());

			if (triplist != null) {
				request.setAttribute("tripresult", triplist);
				request.setAttribute("origin", form.getOrigin());
				request.setAttribute("dest", form.getDestination());
			} else {
				errors.add("Not valid input");
				return "index.jsp";
			}

			return "triplist.jsp";
		} catch (UnsupportedEncodingException | JSONException | FormBeanException e) {
			errors.add(e.getMessage());
			return "index.jsp";
		}
	}
}
