package model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import databean.Itinerary;
import databean.Transit;

public class PAAC {
	private final String paacKey = "key=E9FnEmgTkNcyY6nrJAkzXBZeR&format=json";
	private final String ggmapkey = "key=AIzaSyBRqN6BsdiUVqi2MlA41WKC_TTO40Zlw30";
	private final String paacServer = "http://realtime.portauthority.org/bustime/api/v2/";
	private final String ggmapServer = "https://maps.googleapis.com/maps/api/directions/json?mode=transit&alternatives=true";
	
	public String getTime () {
		String method = "GET";
		String url = paacServer + "gettime?" + paacKey;
		HttpUtil hu = new HttpUtil(method, url);
		hu.excute();
		return hu.getDataString();
	}
	
	// get bus line number and its name & color "71A - Negley"
	public String getRoute () {
		String method = "GET";

		String url = paacServer + "getroutes?" + paacKey;
		HttpUtil hu = new HttpUtil(method, url);
		hu.excute();
		return hu.getDataString();
	}

	// get real-time vehicle for a bus line
	public String getVehicles (String route) {
		String method = "GET";
		String url = paacServer + "getvehicles?" + paacKey + "&rt=" + route;
		HttpUtil hu = new HttpUtil(method, url);
		hu.excute();
		return hu.getDataString();
	}
	
	// get available directions for a route
	public String getDirections (String route) {
		String method = "GET";
		String url = paacServer + "getdirections?" + paacKey + "&rt=" + route;
		HttpUtil hu = new HttpUtil(method, url);
		hu.excute();
		return hu.getDataString();
	}
	
	// get all busstops for a route in one direction
	public String getStops (String route, String dir) {
		String method = "GET";
		String url = paacServer + "getstops?" + paacKey + "&rt=" + route + "&dir=" + dir;
		HttpUtil hu = new HttpUtil(method, url);
		hu.excute();
		return hu.getDataString();
	}
	
	// get the entire sequence of a bus route (src - dst - src)
	public String getPattern (String route) {
		String method = "GET";
		String url = paacServer + "getpatterns?" + paacKey + "&rt=" + route;
		HttpUtil hu = new HttpUtil(method, url);
		hu.excute();
		return hu.getDataString();
	}
	
	// predict the time for a bus to a stop
	public String getPrediction (String route, String stopid) {
		String method = "GET";
		String url = paacServer + "getpredictions?" + paacKey + "&rt=" + route + "&stpid" + stopid;
		HttpUtil hu = new HttpUtil(method, url);
		hu.excute();
		return hu.getDataString();
	}
	
	public ArrayList<Itinerary> getTripPlan (String ori, String dst) throws UnsupportedEncodingException, JSONException {
		String url = ggmapServer + "&" + ggmapkey 
				+ "&origin=" + URLEncoder.encode(ori, "UTF-8") 
				+ "&destination=" + URLEncoder.encode(dst, "UTF-8");
		HttpUtil hu = new HttpUtil("GET", url);
		hu.excute();
		
		ArrayList<Itinerary> list = new ArrayList<Itinerary> ();
		
		JSONArray routes = hu.getData().getJSONArray("routes");
		
		System.out.println("Route : " + routes.length());
		
		for (int i = 0; i < routes.length(); ++i) {
			JSONObject leg = routes.getJSONObject(i).getJSONArray("legs").getJSONObject(0);
			JSONArray steps = leg.getJSONArray("steps");
			
			Itinerary itinerary = new Itinerary();

			for (int j = 0; j < steps.length(); ++j) {
				JSONObject step = steps.getJSONObject(j);
				if(step.get("travel_mode").toString().equals("TRANSIT")) {
					Transit tran = new Transit();
					
					tran.setDistance(step.getJSONObject("distance").getString("text"));
					tran.setDuration(step.getJSONObject("duration").getString("text"));
					
					tran.setOriStop(step.getJSONObject("transit_details").getJSONObject("departure_stop").getString("name"));
					tran.setDestStop(step.getJSONObject("transit_details").getJSONObject("arrival_stop").getString("name"));
					tran.setNumStops(step.getJSONObject("transit_details").get("num_stops").toString());
					
					tran.setDepartTime(step.getJSONObject("transit_details").getJSONObject("departure_time").getString("text"));
					tran.setArrTime(step.getJSONObject("transit_details").getJSONObject("arrival_time").getString("text"));
					tran.setStartLat(step.getJSONObject("transit_details").getJSONObject("departure_stop").getJSONObject("location").get("lat").toString());
					tran.setStartLng(step.getJSONObject("transit_details").getJSONObject("departure_stop").getJSONObject("location").get("lng").toString());
					tran.setEndLat(step.getJSONObject("transit_details").getJSONObject("arrival_stop").getJSONObject("location").get("lat").toString());
					tran.setEndLng(step.getJSONObject("transit_details").getJSONObject("arrival_stop").getJSONObject("location").get("lng").toString());
					
					tran.setBusline(step.getJSONObject("transit_details").getJSONObject("line").getString("short_name"));
					itinerary.getRoutes().add(tran);
				}
			}
			
			if (itinerary.getRoutes().isEmpty())
				continue;
			
			itinerary.setOrigin(ori);
			itinerary.setDestination(dst);
			itinerary.setArrTime(leg.getJSONObject("arrival_time").getString("text"));
			itinerary.setDepartTime(leg.getJSONObject("departure_time").getString("text"));
			itinerary.setDistance(leg.getJSONObject("distance").getString("text"));
			itinerary.setDuration(leg.getJSONObject("duration").getString("text"));
			itinerary.setStartAddr(leg.getString("start_address"));
			itinerary.setEndAddr(leg.getString("end_address"));
			itinerary.setStartLat(leg.getJSONObject("start_location").get("lat").toString());
			itinerary.setEndLat(leg.getJSONObject("end_location").get("lat").toString());
			itinerary.setStartLng(leg.getJSONObject("start_location").get("lng").toString());
			itinerary.setStartLng(leg.getJSONObject("end_location").get("lng").toString());
			
			list.add(itinerary);
		}
		
		return list;
	}
	
	public String getCurrAddress (double lat, double lng) throws JSONException {
		String method = "GET";
		String url = "http://maps.googleapis.com/maps/api/geocode/json?latlng=" +
		Double.toString(lat) + "," + Double.toString(lng) + "&sensor=true_or_false";
		HttpUtil hu = new HttpUtil(method, url);
		hu.excute();
		return hu.getData().getJSONArray("results").getJSONObject(0).getString("formatted_address");
	}
	
	public static void main(String[] args) {
		try {
			URLEncoder.encode("", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
