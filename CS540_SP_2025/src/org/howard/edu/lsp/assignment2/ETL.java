package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.*;

/**
 * Eke Agbai
 * Assignment 2: Building an Object-Oriented ETL Pipeline
 */
public class ETL {
	
	public static void main(String[] args) {
		
		// Path to input file and output file 
        String inputData = "data/products.csv";
        String outputData = "data/transformed_products.csv";
        
        // Extracting the data - Read in csv file
        List<Product> products = extractData(inputData);
        if (products == null) return;
        
        // Transforming data - Modify data based on requirements
        List<Product> transformedProducts = transformData(products);
        
        // Loading - Save transformed data to a new file
        writeData(outputData, transformedProducts);
        System.out.println("Data transformed and output saved to: " + outputData);
    }
    
	/**
     * Method that reads a csv file and returns a list of string arrays.
     */
    public static List<Product> extractData(String inputData) {
    	// Create an empty array called data to hold csv rows
    	List<Product> products = new ArrayList<>();
        
    	// read each row in the csv file
    	try (BufferedReader buffreadr = new BufferedReader(new FileReader(inputData))) {
            String row;
            boolean isFirstRow = true;
            
            // iterate while row is not empty
            while ((row = buffreadr.readLine()) != null) {
                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }
                String[] data = row.split(",");
                if (data.length != 4) continue;
                
                int productId = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                double price = Double.parseDouble(data[2].trim());
                String category = data[3].trim();
                
                // concatenate csv rows to data array
                products.add(new Product(productId, name, price, category));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: The input file was not found: " + inputData);
            return null;
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return null;
        }
        return products;
    }
    
    /**
     * Transforms csv data by applying assignment requirements
     */
    public static List<Product> transformData(List<Product> products) {
        List<Product> transformedProducts = new ArrayList<>();
        for (Product product : products) {
            double newPrice = product.getPrice();
            String newCategory = product.getCategory();
            
            // Apply a 10% discount to Electronics
            if (newCategory.equalsIgnoreCase("Electronics")) {
                newPrice = Math.round((newPrice * 0.9) * 100.0) / 100.0;
            }
            // Change category to if price > 500
            if (newPrice > 500) {
                newCategory = "Premium Electronics";
            }
            // Add transformed row
            transformedProducts.add(new Product(product.getProductId(), product.getName(), newPrice, newCategory));
        }
        return transformedProducts;
    }

    /**
     * Determines the price range category.
     */
    public static void writeData(String outputData, List<Product> products) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputData))) {
            bw.write("ProductID,Name,Price,Category,PriceRange\n");
            for (Product product : products) {
                bw.write(product.toCSV() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    static class Product {
        private int productId;
        private String name;
        private double price;
        private String category;
        
        // Constructor
        public Product(int productId, String name, double price, String category) {
            this.productId = productId;
            this.name = name.toUpperCase();
            this.price = price;
            this.category = category;
        }

        public int getProductId() {
            return productId;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public String getCategory() {
            return category;
        }

        private String getPriceRange() {
            if (price <= 10) return "Low";
            else if (price <= 100) return "Medium";
            else if (price <= 500) return "High";
            else return "Premium";
        }

        public String toCSV() {
            return String.format("%d,%s,%.2f,%s,%s", productId, name, price, category, getPriceRange());
        }
    }

    
}
