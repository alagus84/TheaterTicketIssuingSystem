package com.ttis;

public class Requester {

	private String name;
	private int requestedTicketCount;


	public Requester(String name, int requestedTicketCount) {
		this.name = name;
		this.requestedTicketCount = requestedTicketCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRequestedTicketCount() {
		return requestedTicketCount;
	}

	public void setRequestedTicketCount(int requestedTicketCount) {
		this.requestedTicketCount = requestedTicketCount;
	}

	@Override
	public String toString() {
		return "Requester [name=" + name + ", requestedTicketCount=" + requestedTicketCount + "]";
	}

}
