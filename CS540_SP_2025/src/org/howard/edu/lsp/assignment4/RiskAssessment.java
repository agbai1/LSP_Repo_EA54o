package org.howard.edu.lsp.assignment4;

import java.util.List;

//Implements safety risk analysis
public class RiskAssessment extends SafetyEvaluator {
 @Override
 public void evaluate(List<Plane> flightList) {
     System.out.println("Assessing flight safety for " + flightList.size() + " aircraft.");
 }
}
