package com.fdmgroup.static_keyword_exercise;



public class Employee {
    private String name;
    private String jobTitles;
    private double hourlyWage;
    private static double minimumWage;

    public double getHourlyWage() {
        return hourlyWage;
    }

    public String getJobTitles() {
        return jobTitles;
    }

    public static double getMinimumWage() {
        return minimumWage;
    }

    public String getName() {
        return name;
    }

    public void setHourlyWage(double hourlyWage) {
        if (hourlyWage < Employee.minimumWage) {
            this.hourlyWage = Employee.minimumWage;
        } else {
            this.hourlyWage = hourlyWage;
        }
    }

    public void setJobTitles(String jobTitles) {
        this.jobTitles = jobTitles;
    }

    public static void setMinimumWage(double minimumWage) {
        Employee.minimumWage = minimumWage;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
