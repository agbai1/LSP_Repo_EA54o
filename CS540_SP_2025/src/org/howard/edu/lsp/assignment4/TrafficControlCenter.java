package org.howard.edu.lsp.assignment4;

//Orchestrates air traffic data collection and monitoring
public class TrafficControlCenter {
 private final FlightDatabase flightDatabase = new FlightDatabase();
 private final ControlDisplay radar = new RadarMonitor();
 private final SafetyEvaluator evaluator = new RiskAssessment();
 private final AirTrafficReceiver receiver = new AirTrafficReceiver();
 
 public void monitorAircraft(Plane plane, DataTransmitter transmitter) {
     flightDatabase.logFlight(plane);
     receiver.interceptSignal(transmitter.compileSignal(plane));
     radar.refresh(flightDatabase.getAllFlights());
     evaluator.evaluate(flightDatabase.getAllFlights());
 }
}
