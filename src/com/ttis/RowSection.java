package com.ttis;

import java.util.List;

public class RowSection {

	private int sectionNo;
	private int availableSeatCount;
	private List<Requester> requestor;

	public RowSection(int sectionNo, int availableSeatCount) {
		super();
		this.setSectionNo(sectionNo);
		this.availableSeatCount = availableSeatCount;
	}

	public RowSection(int availableSeatCount, List<Requester> requestor) {
		super();
		this.availableSeatCount = availableSeatCount;
		this.requestor = requestor;
	}

	public int getSectionNo() {
		return sectionNo;
	}

	public void setSectionNo(int sectionNo) {
		this.sectionNo = sectionNo;
	}

	public int getAvailableSeatCount() {
		return availableSeatCount;
	}

	public void setAvailableSeatCount(int availableSeatCount) {
		this.availableSeatCount = availableSeatCount;
	}

	public List<Requester> getRequestor() {
		return requestor;
	}

	public void setRequestor(List<Requester> requestor) {
		this.requestor = requestor;
	}

	@Override
	public String toString() {
		return "RowSection [availableSeatCount=" + availableSeatCount + ", requestor=" + requestor + "]";
	}

}
