package model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class PAAC {
	private final String key = "E9FnEmgTkNcyY6nrJAkzXBZeR";
	
	public String getTime () {
		String method = "GET";
		String server_url = "http://realtime.portauthority.org/bustime/api/v2/";
		String url = server_url + "gettime?key=" + key + "&format=json";
		HttpUtil hu = new HttpUtil(method, url);
		hu.excute();
		return hu.getDataString();
	}
	
	// get bus line number and its name & color "71A - Negley"
	public String getRoute () {
		String method = "GET";
		String server_url = "http://realtime.portauthority.org/bustime/api/v2/";
		String url = server_url + "getroutes?key=" + key;
		url += "&format=json";
		HttpUtil hu = new HttpUtil(method, url);
		hu.excute();
		return hu.getDataString();
	}

	// get real-time vehicle for a bus line
	public String getVehicles (String route) {
		String method = "GET";
		String server_url = "http://realtime.portauthority.org/bustime/api/v2/";
		String url = server_url + "getvehicles?key=" + key + "&rt=" + route;
		url += "&format=json";
		HttpUtil hu = new HttpUtil(method, url);
		hu.excute();
		return hu.getDataString();
	}
	
	// get available directions for a route
	public String getDirections (String route) {
		String method = "GET";
		String server_url = "http://realtime.portauthority.org/bustime/api/v2/";
		String url = server_url + "getdirections?key=" + key + "&rt=" + route;
		url += "&format=json";
		HttpUtil hu = new HttpUtil(method, url);
		hu.excute();
		return hu.getDataString();
	}
	
	// get all busstops for a route in one direction
	public String getStops (String route, String dir) {
		String method = "GET";
		String server_url = "http://realtime.portauthority.org/bustime/api/v2/";
		String url = server_url + "getstops?key=" + key + "&rt=" + route + "&dir=" + dir;
		url += "&format=json";
		HttpUtil hu = new HttpUtil(method, url);
		hu.excute();
		return hu.getDataString();
	}
	
	// get the entire sequence of a bus route (src - dst - src)
	public String getPattern (String route) {
		String method = "GET";
		String server_url = "http://realtime.portauthority.org/bustime/api/v2/";
		String url = server_url + "getpatterns?key=" + key + "&rt=" + route;
		url += "&format=json";
		HttpUtil hu = new HttpUtil(method, url);
		hu.excute();
		return hu.getDataString();
	}
	
	// predict the time for a bus to a stop
	public String getPrediction (String route, String stopid) {
		String method = "GET";
		String server_url = "http://realtime.portauthority.org/bustime/api/v2/";
		String url = server_url + "getpredictions?key=" + key + "&rt=" + route + "&stpid" + stopid;
		url += "&format=json";
		HttpUtil hu = new HttpUtil(method, url);
		hu.excute();
		return hu.getDataString();
	}
	
	public static void main(String[] args) {
		try {
			URLEncoder.encode("", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
