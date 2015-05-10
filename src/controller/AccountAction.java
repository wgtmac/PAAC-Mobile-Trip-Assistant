package controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONException;

import model.HttpUtil;
import model.PAAC;

public class AccountAction extends Action {
	//private FormBeanFactory<SearchForm> formBeanFactory = FormBeanFactory.getInstance(SearchForm.class);

	
	public AccountAction() {
	}

	public String getName() { return "account.do"; }

	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		
//		try {
			
			//SearchForm form = formBeanFactory.create(request);
			//request.setAttribute("form", form);

//			if (!form.isPresent()) {
//				return "account.jsp";
//			}

			// Any validation errors?
//			errors.addAll(form.getValidationErrors());
//			if (errors.size() != 0) {
//				return "search.jsp";
//			}
			

	
			return "account.jsp";
//		} catch (FormBeanException e) {
//        	errors.add(e.getMessage());
//        	return "search.jsp";
//		}
	}
}
