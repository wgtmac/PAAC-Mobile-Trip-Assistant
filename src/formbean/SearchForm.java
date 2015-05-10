package formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class SearchForm extends FormBean {
	private String busline;
	private String busstop;
	private String action;

	public String getBusline() {
		return busline;
	}

	public void setBusline(String v) {
		this.busline = v.trim();
	}

	public String getBusstop() {
		return busstop;
	}

	public void setBusstop(String v) {
		this.busstop = v.trim();
	}

	public String getAction() {
		return action;
	}

	public void setAction(String v) {
		this.action = v;
	}

	public boolean isPresent() {
		return action != null;
	}

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (action == null) {
			errors.add("Button is required");
		}

		if (errors.size() > 0)
			return errors;

		if (!action.equals("Search Bus Line")
				&& !action.equals("Search Bus Stop")
				&& !action.equals("Search Nearby"))
			errors.add("Invalid button");

		if (action.equals("Search Bus Line")) {
			if ((busline == null || busline.length() == 0)) {
				errors.add("Bus line is required");
			}
		} else if (action.equals("Search Bus Stop")) {
			if ((busstop == null || busstop.length() == 0)) {
				errors.add("Bus stop is required");
			}
		}

		return errors;
	}
}