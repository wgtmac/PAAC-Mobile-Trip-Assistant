package formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class TripPlanForm extends FormBean {
	private String origin;
	private String destination;
	private String time;
	private String type;
	private String action;

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String v) {
		this.origin = v;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String v) {
		this.destination = v;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String v) {
		this.time = v;
	}

	public String getType() {
		return type;
	}

	public void setType(String v) {
		this.type = v;
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

		if (!action.equals("Go"))
			errors.add("Invalid button");

		if ((origin == null || origin.length() == 0)
				|| (destination == null || destination.length() == 0)) {
			errors.add("Both addresses are required");
		}

		if (time != null && time.length() != 0) {
			if (type == null || type.length() == 0)
				errors.add("Type of date/time is required");
		}

		return errors;
	}
}