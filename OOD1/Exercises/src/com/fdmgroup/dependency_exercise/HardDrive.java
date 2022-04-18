package com.fdmgroup.dependency_exercise;

public class HardDrive {
    private final String MODEL;
    private final double CAPACITY;
    private double usedSpace;

    public HardDrive(String model, double capacity) {
        this.MODEL = model;
        this.CAPACITY = capacity;
    }

    public String readData(String file) {
        return "readData : " + file;
    }

    public void writeData(String data, String file) {
        System.out.println("writeData : " + data + " & " + file);
    }

    public double getCAPACITY() {
        return CAPACITY;
    }

    public String getMODEL() {
        return MODEL;
    }

    public double getUsedSpace() {
        return usedSpace;
    }

    public void setUsedSpace(double usedSpace) {
        this.usedSpace = usedSpace;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.MODEL;
    }

}
