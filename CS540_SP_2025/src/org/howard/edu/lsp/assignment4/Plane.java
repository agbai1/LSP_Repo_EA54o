package org.howard.edu.lsp.assignment4;

public abstract class Plane {
    protected String identifier;
    protected String make;
    protected double altitude;
    protected double velocity;
    protected double latitude;
    protected double longitude;
    
    public Plane(String identifier, String make, double altitude, double velocity, double latitude, double longitude) {
        this.identifier = identifier;
        this.make = make;
        this.altitude = altitude;
        this.velocity = velocity;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public String getIdentifier() {
        return identifier;
    }
    
    public String getMake() {
        return make;
    }
    
    public abstract void relayData();
}