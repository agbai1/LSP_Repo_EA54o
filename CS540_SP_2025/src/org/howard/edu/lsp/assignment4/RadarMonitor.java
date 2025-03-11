package org.howard.edu.lsp.assignment4;

import java.util.List;

//Class for radar display updates
public class RadarMonitor extends ControlDisplay {
 @Override
 public void refresh(List<Plane> flightList) {
     System.out.println("Radar Monitor refreshed with " + flightList.size() + " aircraft.");
 }
}