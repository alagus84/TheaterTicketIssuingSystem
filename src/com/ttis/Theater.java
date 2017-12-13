package com.ttis;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Theater {

	private String theaterName;
	private Map<Integer, List<RowSection>> theaterLayoutMap;

	public Theater(String theaterName) {
		super();
		this.theaterName = theaterName;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public Map<Integer, List<RowSection>> getTheaterLayoutMap() {
		return theaterLayoutMap;
	}

	public Scanner setTheaterLayoutMap() {
		this.theaterLayoutMap = new HashMap<>();

		int rowCount = 0;
		Scanner s = new Scanner(System.in);
//		try (Scanner s = new Scanner(System.in)) {
			while (true) {
				String row = s.nextLine();

				if (("").equals(row)) {
					System.out.println("Theater Layout input is done");
					return s;
				}
				else {
					try {
						this.theaterLayoutMap.put(++rowCount, validateRow(row));
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
						continue;
					}
				}

			}
//		}
	}

	private List<RowSection> validateRow(String row) throws Exception {

		StringTokenizer st = new StringTokenizer(row, " ");
		List<RowSection> rsLst = new LinkedList<>();

		int sectionNo = 0;
		while (st.hasMoreTokens()) {
			String token = st.nextToken();

			int seatCount = 0;

			try {
				seatCount = Integer.parseInt(token);
			}
			catch (NumberFormatException nfe) {
				throw new Exception("Invalid section count in the request. Please re-enter");
			}

			RowSection rs = new RowSection(++sectionNo, seatCount);
			rsLst.add(rs);
		}

		return rsLst;

	}


}
