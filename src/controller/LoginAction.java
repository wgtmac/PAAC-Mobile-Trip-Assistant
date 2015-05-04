package controller;


import javax.servlet.http.HttpServletRequest;



public class LoginAction extends Action {

	public LoginAction() {
		
	}
	
	public String getName() { return "login.do"; }
    
    public String perform(HttpServletRequest request) {
    	return "index.jsp";
    }
        
}
