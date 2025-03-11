package org.howard.edu.lsp.assignment4;


// CITAION
public class ATCSystem {
    public static void main(String[] args) {
        TrafficControlCenter controlCenter = new TrafficControlCenter();
        DataTransmitter transmitter = new DataTransmitter();

        Plane airbusA380 = new PassengerJet("QF1", "Airbus A380", 43000, 560, 40.6413, -73.7781);
        Plane concorde = new PassengerJet("AF4590", "Concorde", 60000, 1350, 48.8566, 2.3522);
        Plane f35Lightning = new CombatJet("LightningII", "F-35 Lightning II", 45000, 1199, 32.7357, -97.1081);
        Plane su57Felon = new CombatJet("SU-F57", "Sukhoi Su-57", 51000, 1210, 55.7558, 37.6173);
        
        controlCenter.monitorAircraft(airbusA380, transmitter);
        controlCenter.monitorAircraft(concorde, transmitter);
        controlCenter.monitorAircraft(f35Lightning, transmitter);
        controlCenter.monitorAircraft(su57Felon, transmitter);

    }
}


// CITATION
// Logic to implement gathered from https://github.com/saifilmaknojia/Air-Traffic-Control-System-Simulation.git