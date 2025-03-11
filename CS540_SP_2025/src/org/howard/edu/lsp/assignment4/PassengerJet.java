package org.howard.edu.lsp.assignment4;

public class PassengerJet extends Plane {
    public PassengerJet(String identifier, String make, double altitude, double velocity, double latitude, double longitude) {
        super(identifier, make, altitude, velocity, latitude, longitude);
    }
    
    @Override
    public void relayData() {
        System.out.println("Passenger Jet " + identifier + " broadcasting position and flight data.");
    }
}
