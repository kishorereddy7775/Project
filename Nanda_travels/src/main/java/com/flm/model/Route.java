package com.flm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
	private int routeId=0;
	private int numberOfSeatsAvailable;
	private int priceOfEachTicket;
}
