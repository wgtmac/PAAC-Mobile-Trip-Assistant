package databean;

import java.util.ArrayList;

public class Itinerary {
	private String origin;
	private String destination;
	
	private String arrTime;
	private String departTime;
	
	private String distance;
	private String duration;
	
	private String startAddr;
	private String endAddr;
	private String startLat;
	private String startLng;
	private String endLat;
	private String endLng;
	
	private String predTime;
	
	
	
	public String getPredTime() {
		return predTime;
	}

	public void setPredTime(String v) {
		this.predTime = v;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getArrTime() {
		return arrTime;
	}

	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getStartAddr() {
		return startAddr;
	}

	public void setStartAddr(String startAddr) {
		this.startAddr = startAddr;
	}

	public String getEndAddr() {
		return endAddr;
	}

	public void setEndAddr(String endAddr) {
		this.endAddr = endAddr;
	}

	public String getStartLat() {
		return startLat;
	}

	public void setStartLat(String startLat) {
		this.startLat = startLat;
	}

	public String getStartLng() {
		return startLng;
	}

	public void setStartLng(String startLng) {
		this.startLng = startLng;
	}

	public String getEndLat() {
		return endLat;
	}

	public void setEndLat(String endLat) {
		this.endLat = endLat;
	}

	public String getEndLng() {
		return endLng;
	}

	public void setEndLng(String endLng) {
		this.endLng = endLng;
	}

	public ArrayList<Transit> getRoutes() {
		return routes;
	}

	public void setRoutes(ArrayList<Transit> routes) {
		this.routes = routes;
	}

	private ArrayList<Transit> routes = new ArrayList<Transit>();
	
	public String getRouteName () {
		String name = routes.isEmpty() ? "" : routes.get(0).getBusline();
		for (int i = 1; i < routes.size(); ++i) {
			name += " - " + routes.get(i).getBusline();
		}
		return name;
	}
	
	@Override
	public String toString() {
		return "Itinerary [origin=" + origin + ", destination=" + destination
				+ ", arrTime=" + arrTime + ", departTime=" + departTime
				+ ", distance=" + distance + ", duration=" + duration
				+ ", startAddr=" + startAddr + ", endAddr=" + endAddr
				+ ", startLat=" + startLat + ", startLng=" + startLng
				+ ", endLat=" + endLat + ", endLng=" + endLng + ", routes="
				+ routes + "]";
	}
}
