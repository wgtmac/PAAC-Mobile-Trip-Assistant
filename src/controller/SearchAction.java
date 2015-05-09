package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import formbean.SearchForm;

public class SearchAction extends Action {
	private FormBeanFactory<SearchForm> formBeanFactory = FormBeanFactory.getInstance(SearchForm.class);

	
	public SearchAction() {
	}

	public String getName() { return "search.do"; }

	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		
		try {
			
			SearchForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);

			if (!form.isPresent()) {
				return "search.jsp";
			}

			// Any validation errors?
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "search.jsp";
			}
			

	
			return "search.jsp";
		} catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "search.jsp";
		}
	}
}
