package com.ttis;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class IssueTheaterTickets {

	public static void main(String[] args) {

		System.out.println("Enter Theator Layout (Seat count per section in a row separated with commas):-");
		Theater theater = new Theater("DC Cinemas");
//		theater.setTheaterLayoutMap();
		Scanner s = theater.setTheaterLayoutMap();		
//		System.out.println("Total rows: " + theater.getTheaterLayoutMap().size());
//		
//		for (int key : theater.getTheaterLayoutMap().keySet()) {
//			List<RowSection> rsLst = theater.getTheaterLayoutMap().get(key);
//			
//			for(RowSection rs : rsLst) {
//				System.out.print(rs.getAvailableSeatCount() + " ");
//			}
//			System.out.println("");
//		}
		
		System.out.println("Enter Patron requests:-");
		
		List<Requester> requesterLst = new LinkedList<>();
		
//		try (Scanner s = new Scanner(System.in)) {
			while (true) {
				String requesterDetail = s.nextLine();

				if (("").equals(requesterDetail)) {
					System.out.println("Requester input is done");
					break;
				}
				else {
					try {
						requesterLst.add(validateRequester(requesterDetail));
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
						continue;
					}
				}

			}
//		}
		
//		System.out.println("Total requests: " + requesterLst.size());
		
//		for (Requester r : requesterLst) {
//			System.out.println(r.getName() + " " + r.getRequestedTicketCount());
//		}
		
		processRequests(requesterLst, theater.getTheaterLayoutMap());
		
	}

	private static void processRequests(List<Requester> requesterLst, Map<Integer, List<RowSection>> theaterMap) {
		for (Requester r : requesterLst) {
			int totalAvailableTickets = 0;
			for (int key : theaterMap.keySet()) {
				List<RowSection> rsLst = theaterMap.get(key);
				
				for(RowSection rs : rsLst) {
					totalAvailableTickets += rs.getAvailableSeatCount();
				}
			}
			if (r.getRequestedTicketCount() > totalAvailableTickets) {
				System.out.println(r.getName() + " " + "Sorry, we can't handle your party");
				continue;
			}
			
			boolean partyHandled = false;
			for (int key : theaterMap.keySet()) {
				List<RowSection> rsLst = theaterMap.get(key);
				
				for(RowSection rs : rsLst) {
					if (r.getRequestedTicketCount() <= rs.getAvailableSeatCount()) {
						rs.setAvailableSeatCount(rs.getAvailableSeatCount() - r.getRequestedTicketCount());
						System.out.println(r.getName() + " " + "Row " + key + " Section " + rs.getSectionNo());
						partyHandled = true;
						break;
					}
				}
				if (partyHandled) {
					break;
				}
			}

			if (!partyHandled) {
				System.out.println(r.getName() + " " + "Call to split party");
			}
		}
		
	}

	private static Requester validateRequester(String requesterDetail) throws Exception {
		StringTokenizer st = new StringTokenizer(requesterDetail, " ");

		if (st.countTokens() != 2) {
			throw new Exception("Invalid Format: Enter Requestor name <space> party count");
		}

		String name = st.nextToken();
		String token = st.nextToken();
		int partyCount = 0;
		try {
			partyCount = Integer.parseInt(token);
		}
		catch (NumberFormatException nfe) {
			throw new Exception("Invalid party count in the request. Please re-enter");
		}

		return new Requester(name, partyCount);
	}

}
