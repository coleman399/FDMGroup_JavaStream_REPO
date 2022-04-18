package com.fdmgroup.dependency_exercise;

public class Computer {
    private final String MODEL;
    private HardDrive hardDrive;
    private Memory memory;
    private final Processor PROCESSOR;

    public Computer(String model, HardDrive hardDrive, Memory memory, Processor processor) {
        this.MODEL = model;
        this.hardDrive = hardDrive;
        this.memory = memory;
        this.PROCESSOR = processor;
    }

    public void turnOn() {
        System.out.println("turn on method called");
    }

    public void turnOff() {
        System.out.println("turn off method called");
    }

    public void getPower(PowerSource powerSource) {
        System.out.println("Power : " + powerSource.supplyPower());
    }

    public HardDrive getHardDrive() {
        return hardDrive;
    }

    public String getMODEL() {
        return MODEL;
    }

    public Memory getMemory() {
        return memory;
    }

    public Processor getPROCESSOR() {
        return PROCESSOR;
    }

    public void setHardDrive(HardDrive hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.MODEL;
    }
}
