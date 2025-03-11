package org.howard.edu.lsp.assignment4;

import java.util.*;

//Stores and retrieves aircraft flight data
public class FlightDatabase {
 private final List<Plane> trackedFlights = new ArrayList<>();
 
 public void logFlight(Plane plane) {
     trackedFlights.add(plane);
 }
 
 public void printLoggedFlights() {
     System.out.println("Tracked Aircraft:");
     for (Plane p : trackedFlights) {
    	    System.out.println(p.getIdentifier() + " - " + p.getMake());
    	}
 }
 
 public List<Plane> getAllFlights() {
     return trackedFlights;
 }
}
