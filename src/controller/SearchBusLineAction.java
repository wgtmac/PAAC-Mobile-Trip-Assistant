package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.PAAC;

import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databean.BusStop;
import formbean.SearchBusLineForm;

public class SearchBusLineAction extends Action {
	private FormBeanFactory<SearchBusLineForm> formBeanFactory = FormBeanFactory.getInstance(SearchBusLineForm.class);

	public SearchBusLineAction() {
		
	}
	
	public String getName() { return "searchBusLine.do"; }
	
	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		
		
		try {
			SearchBusLineForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);
			
			if (!form.isPresent()) {
				System.out.println("wrong 1");
				return "search.jsp";
			}
			
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				System.out.println("wrong 2");
				return "search.jsp";
			}
			
			String route = form.getBusline();
			if(route == null || route.length() == 0) {
				errors.add("Please input the busline");
				return "search.jsp";
			}
			
			boolean isInBound = true;
			PAAC p = new PAAC();
			ArrayList<BusStop> busStops = p.getBusStops(route, isInBound);
			request.setAttribute("route", route);
			request.setAttribute("busStops", busStops);
			
		} catch (FormBeanException e) {
			e.printStackTrace();
		}
		
		
		return "showBusLine.jsp";
	}
}
