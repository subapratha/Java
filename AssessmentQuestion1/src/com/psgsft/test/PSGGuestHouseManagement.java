package com.psgsft.test;

import com.psgsft.test.Employees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.psgsft.test.Address;
import com.psgsft.test.Customer;
import com.psgsft.test.Rooms;
import com.psgsft.test.RoomType;
import com.psgsft.test.Services;

@SuppressWarnings("unused")
public class PSGGuestHouseManagement {
	public static void main(String[] args) {
		try {

			/*
			 * Employees class has list of employees like supervisors and
			 * approvers. Supervisors is in charge of allocation of room based
			 * on rooms availability in room class and based on guests
			 * requests.. They maintain details regarding the guests in customer
			 * class find available rooms to allocate and generate reports based
			 * on daily usage percentage and check in out , occupancy reports
			 * and gets approval from concerned people. Supervisors also looks
			 * after cancellation of rooms.. Type of rooms ac or non ac fetched
			 * from roomtype class and facilities availed like food are taken
			 * from services class address table
			 */
			// room reservation
			List<String> reservation = RoomReservation();
			for (String result : reservation) {
				System.out.println("reservation==> " + result);
			}
			List<String> occupancydetails = occupancydetails();
			for (String result1 : occupancydetails) {
				System.out.println("occupancydetails==> " + result1);
			}
			List<String> availabilitydetails = availabilitydetails();
			for (String result2 : availabilitydetails) {
				System.out.println("availabilitydetails==> " + result2);
			}
			List<String> allotment = allotment();
			for (String result3 : allotment) {
				System.out.println("allotment==> " + result3);
			}
			List<String> cancellation = cancellation();
			for (String result4 : cancellation) {
				System.out.println("cancellation==> " + result4);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static List<String> cancellation() {
		// TODO Auto-generated method stub
		/*
		 * supervisor cancelles the room based on the customers reservation on
		 * the given date and room
		 * 
		 */
		List<String> cancelledinfo = new ArrayList<>();
		return cancelledinfo;
	}

	private static List<String> allotment() {
		// TODO Auto-generated method stub
		/*
		 * supervisors allots the rooms based on rooms that is free and based on
		 * the date guests reserved for and based on the facilities they request
		 * for
		 */
		List<String> allotment = new ArrayList<>();
		return allotment;
	}

	private static List<String> availabilitydetails() {
		// TODO Auto-generated method stub
		// loops through the data related to rooms and its availability and
		// based on reservation
		// and room vacated details a from the room class
		List<String> availability = new ArrayList<>();
		return availability;
	}

	private static List<String> occupancydetails() {
		// TODO Auto-generated method stub
		// loops through checked details of the rooms based occupied on and
		// reserved till date from rooms
		// and checked in date to generte the report

		List<String> occupancydetails = new ArrayList<>();
		return occupancydetails;
	}

	private static List<String> RoomReservation() {
		// TODO Auto-generated method stub
		// gets the guests details and fill in reservation form and save it in
		// rooms classand its related class
		List<String> reservationlist = new ArrayList<>();
		// fill the map with the reservation details and return the data to
		// add the data into room class and related classes roomtype,employee
		// who filled in and approved checkedin date and time
		return reservationlist;
	}

}
