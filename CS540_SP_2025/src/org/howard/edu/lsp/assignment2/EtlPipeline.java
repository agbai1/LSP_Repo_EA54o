package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.*;

public class EtlPipeline {
	/**
	 * Eke Agbai
	 * Assignment 2: Building a Simple ETL Pipeline
	 * @param args
	 */
    public static void main(String[] args) {
    
    	// Path to input file and output file
        String inputData = "data/products.csv";  
        String outputData = "data/transformed_products.csv";

        // Extracting the data - Read in csv file
        List<String[]> data = extractData(inputData);
        if (data == null) return;  // Stop execution if file not found

        // Transforming data - Modify data based on requirements
        List<String[]> transformedData = transformData(data);

        // Loading - Save transformed data to a new file
        writeData(outputData, transformedData);
        System.out.println("Data transformed an output saved to: " + outputData);
    }

    /**
     * Method that reads a csv file and returns a list of string arrays.
     */
    public static List<String[]> extractData(String filePath) {
        // Create an empty array called data to hold csv rows
    	List<String[]> data = new ArrayList<>();
    	
    	// read each row in the csv file
        try (BufferedReader buffreadr = new BufferedReader(new FileReader(filePath))) {
        	String row;
            boolean isFirstRow = true;
            
            // iterate while row is not empty
            while ((row = buffreadr.readLine()) != null) {
                if (isFirstRow) { // Skips the header row in the csv file
                	isFirstRow = false;
                    continue;
                }
                // concatenate csv rows to data array
                data.add(row.split(","));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: The input file was not found: " + filePath);
            return null;
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return null;
        }

        return data;
    }

    /**
     * Transforms csv data by applying assignment requirements
     */
    public static List<String[]> transformData(List<String[]> data) {
        List<String[]> newData = new ArrayList<>();

        // Add the header row to the output
        newData.add(new String[]{"ProductID", "Name", "Price", "Category", "PriceRange"});

        for (String[] row : data) {
        	if (row.length != 4) continue; // Skip invalid rows
        	
            int productId = Integer.parseInt(row[0].trim());
            String name = row[1].trim().toUpperCase();
            double price = Double.parseDouble(row[2].trim());
            String category = row[3].trim();

            // Apply a 10% discount to Electronics
            if (category.equalsIgnoreCase("Electronics")) {
                price = Math.round((price * 0.9) * 100.0) / 100.0;
            }

            // Change category to if price > 500
            if (price > 500) {
                category = "Premium Electronics";
            }

            String priceRange = getPriceRange(price);

            // Add transformed row
            newData.add(new String[]{String.valueOf(productId), name, String.format("%.2f", price), category, priceRange});
        }
        return newData;
    }

    /**
     * Determines the price range category.
     */
    public static String getPriceRange(double price) {
        if (price <= 10) return "Low";
        else if (price <= 100) return "Medium";
        else if (price <= 500) return "High";
        else return "Premium";
    }

    /**
     * Writes transformed data to a new csv file.
     */
    public static void writeData(String filePath, List<String[]> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                bw.write(String.join(",", row) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
