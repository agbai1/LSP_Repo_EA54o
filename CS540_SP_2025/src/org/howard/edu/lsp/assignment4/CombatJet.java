package org.howard.edu.lsp.assignment4;

public class CombatJet extends Plane {
    public CombatJet(String identifier, String make, double altitude, double velocity, double latitude, double longitude) {
        super(identifier, make, altitude, velocity, latitude, longitude);
    }
    
    @Override
    public void relayData() {
        System.out.println("Combat Jet " + identifier + " securely transmitting mission data.");
    }
}
