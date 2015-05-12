package formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class SearchBusLineForm extends FormBean {
	private String busline;
	private String action;

	public String getBusline() {
		return busline;
	}

	public void setBusline(String busline) {
		this.busline = busline;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	public boolean isPresent() {
		return action != null;
	}
	
	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (action == null) {
			errors.add("Button is required");
		}

		if (errors.size() > 0) {
			return errors;
		}

		if (!action.equals("Search Bus Line")) {
			errors.add("Invalid button");
		}

		if ((busline == null || busline.length() == 0)) {
			errors.add("Bus line is required");
		}

		return errors;
	}
}
