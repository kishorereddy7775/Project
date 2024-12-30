package com.flm.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Booking {
	int bookingId;
	int userId;
	int routeId;
	String source;
	String destination;
	String date;
	int numberOfSeatsRequired;
	int numberOfSeatsAvailable;
	int priceOfEachTicket;
	
	public Booking() {
		routeId=0;
		bookingId=0;
	}
	public Booking(String source, String destination, String date, int numberOfSeatsRequired) {
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.numberOfSeatsRequired = numberOfSeatsRequired;
	}
	public Booking(int routeId, String source, String destination, String date, int numberOfSeatsRequired,
			int numberOfSeatsAvailable) {
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.numberOfSeatsRequired = numberOfSeatsRequired;
		this.numberOfSeatsAvailable = numberOfSeatsAvailable;
	}
	public void updateroute(Route ro) {
		if(ro.getRouteId()>0) {
			this.routeId=ro.getRouteId();
			this.numberOfSeatsAvailable=ro.getNumberOfSeatsAvailable();
			this.priceOfEachTicket=ro.getPriceOfEachTicket();
		}
	}
	
}
