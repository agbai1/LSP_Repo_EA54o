package org.howard.edu.lsp.assignment4;

//Handles aircraft data communication
public class DataTransmitter {
 public String compileSignal(Plane plane) {
     return "Transmission from " + plane.identifier + " at " + plane.altitude + " feet.";
 }
}