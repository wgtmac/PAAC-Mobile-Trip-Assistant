package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

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

	@SuppressWarnings("unchecked")
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		
		session.removeAttribute("tripresult");
		session.removeAttribute("origin");
		session.removeAttribute("dest");

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
			String dest = form.getDestination();
			if (origin.equals("Current Location")) {
				String addr = null;
				if ( session.getAttribute("currAddr") == null) {
					String lat = (String) request.getParameter("lat").trim();
					String lng = (String) request.getParameter("lng").trim();
					
					PAAC p = new PAAC();
					addr = p.getCurrAddress(Double.parseDouble(lat), Double.parseDouble(lng));
					session.setAttribute("currAddr", addr);
				} else {
					addr = (String) session.getAttribute("currAddr");
				}
				
				//System.out.println(
				origin = addr;
			}
			if (dest.equals("Current Location")) {
				String addr = null;
				if ( session.getAttribute("currAddr") == null) {
					String lat = (String) request.getParameter("lat").trim();
					String lng = (String) request.getParameter("lng").trim();
					
					PAAC p = new PAAC();
					addr = p.getCurrAddress(Double.parseDouble(lat), Double.parseDouble(lng));
					session.setAttribute("currAddr", addr);
				} else {
					addr = (String) session.getAttribute("currAddr");
				}
				
				System.out.println(addr);
				origin = addr;
			}
			
			// transfer time to milliseconds
			String diff_in_seconds = "";
			if (!form.getDatetime().isEmpty()) {
				Calendar calendar1 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
				String time = form.getDatetime().trim().replace("T", " ");
				calendar1.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(time));
			    Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			    calendar2.set(1970, Calendar.JANUARY, 1);
			    diff_in_seconds = Long.toString((calendar1.getTimeInMillis() - calendar2.getTimeInMillis()) / 1000);
			}

			PAAC paac = new PAAC();
			ArrayList<Itinerary> triplist;
			triplist = paac.getTripPlan(origin, dest, diff_in_seconds, form.getType().equals("dep"));
			
			if (triplist != null) {
				session.setAttribute("tripresult", triplist);
				session.setAttribute("origin", form.getOrigin());
				session.setAttribute("dest", form.getDestination());
			} else {
				errors.add("Not valid input");
				return "index.jsp";
			}

			return "triplist.jsp";
		} catch (UnsupportedEncodingException | JSONException | FormBeanException | ParseException e) {
			errors.add(e.getMessage());
			return "index.jsp";
		}
	}
}
