package br.com.fiap;

public class Message {
	
	private int stage;
	private String value;
	
	public Message(int stage, String value) {
		this.stage = stage;
		this.value = value;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}
	
	public void goForwardStage() {
		this.stage++;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
