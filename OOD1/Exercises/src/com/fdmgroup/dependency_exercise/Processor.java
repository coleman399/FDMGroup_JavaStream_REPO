package com.fdmgroup.dependency_exercise;

public class Processor {
    private final String MODEL;
    private final double SPEED; 
    private final int NUMBER_OF_CORES;

    public Processor(String model, double speed, int numberOfCores) {
        this.MODEL = model;
        this.SPEED = speed;
        this.NUMBER_OF_CORES = numberOfCores;
    }

    public void processData(String data){
        System.out.println("storeData : " + data);
    }

    public String getMODEL() {
        return MODEL;
    }

    public int getNUMBER_OF_CORES() {
        return NUMBER_OF_CORES;
    }

    public double getSPEED() {
        return SPEED;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.MODEL;
    }
}
