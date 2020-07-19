package br.com.fiap;

public class Match {
	
	private String value;
	private int distance;
	
	public Match (String value, int distance) {
		this.value = value;
		this.distance = distance;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}

}
