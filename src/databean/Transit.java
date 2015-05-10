package databean;

/**
 * Transit class represents a route from one bus-stop to another bus-stop
 * It is only on one bus. One trip plan may combine several transits
 * */
public class Transit {
	
	private String departTime;
	private String arrTime;
	
	private String distance;
	private String duration;
	
	private String oriStop;
	private String startLat;
	private String startLng;
	
	private String destStop;
	private String endLat;
	private String endLng;
	
	private String numStops;
	private String busline;

	public String getBusline() {
		return busline;
	}

	public void setBusline(String busline) {
		this.busline = busline;
	}

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public String getArrTime() {
		return arrTime;
	}

	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
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

	public String getOriStop() {
		return oriStop;
	}

	public void setOriStop(String oriStop) {
		this.oriStop = oriStop;
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

	public String getDestStop() {
		return destStop;
	}

	public void setDestStop(String destStop) {
		this.destStop = destStop;
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

	public String getNumStops() {
		return numStops;
	}

	public void setNumStops(String numStops) {
		this.numStops = numStops;
	}

	@Override
	public String toString() {
		return "Transit [departTime=" + departTime + ", arrTime=" + arrTime
				+ ", distance=" + distance + ", duration=" + duration
				+ ", oriStop=" + oriStop + ", startLat=" + startLat
				+ ", startLng=" + startLng + ", destStop=" + destStop
				+ ", endLat=" + endLat + ", endLng=" + endLng + ", numStops="
				+ numStops + "]";
	}
	
}
