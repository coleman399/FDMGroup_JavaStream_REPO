package com.fdmgroup.dependency_module;

public class Computer {
    private final String MODEL;
    private HardDrive hardDrive;
    private Memory memory;
    private final Processor PROCESSOR;

    public Computer(String model, HardDrive hardDrive, Memory memory, Processor processor) {
        super();
        this.MODEL = model;
        this.hardDrive = hardDrive;
        this.memory = memory;
        this.PROCESSOR = processor;
    }

    public void turnOn(){
        
    }
    
    public void turnOff(){
        
    }
    
    public void getPower(PowerSource powerSource){
        powerSource.supplyPower();
        System.out.println("Computer received power.");
    }

    public void setHardDrive(HardDrive hardDrive) {
        this.hardDrive = hardDrive;
    }
    
    public void setMemory(Memory memory) {
        this.memory = memory;
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

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "model = ( " + getMODEL() + " )";
    }
}
