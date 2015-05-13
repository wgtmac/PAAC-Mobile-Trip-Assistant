package controller;

import javax.servlet.http.HttpServletRequest;

public class RequestUberAction extends Action {

	public RequestUberAction() {
	}

	public String getName() {
		return "uber.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		return "uber.jsp";
	}

}
