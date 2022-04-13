package com.fdmgroup.interface_exercise;

public class Toy implements BasketItem {
    private int minAge;
    private int maxAge;

    private String name;
    private double price;
    
    public Toy(int minAge, int maxAge, String name, double price) {
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public void setPrice(double price) {
        this.price = price;        
    }

    public int getMaxAge() {
        return maxAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }
}
