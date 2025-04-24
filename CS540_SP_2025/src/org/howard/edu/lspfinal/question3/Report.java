package org.howard.edu.lspfinal.question3;

/**
 * Base class for all reports. Defines the report process.
 */
public abstract class Report {

    /**
     * Template method that runs the report steps.
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    protected abstract void loadData();
    protected abstract void formatData();
    protected abstract void printReport();
}
