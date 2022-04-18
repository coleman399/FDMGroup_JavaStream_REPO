package com.fdmgroup.dependency_module;

public class Runner {
    public static void main(String[] args) {

        HardDrive drive1 = new HardDrive("Seagate", 2048);
        HardDrive drive2 = new HardDrive("Dell", 3072);

        System.out.println(drive1.readData(drive1.getMODEL()));
        System.out.println(drive2.readData(drive2.getMODEL()));

        Processor processor1 = new Processor("Intel Xeon", 2.93, 6);
        Processor processor2 = new Processor("Intel Celeron", 2.9, 2);

        processor1.storeData(processor1.getMODEL());
        processor2.storeData(processor2.getMODEL());

        Memory memory1 = new Memory("Kingston", 4.0, 1600);
        Memory memory2 = new Memory("Corsair", 8.0, 1333);

        memory1.storeData(memory1.getMODEL());
        memory2.storeData(memory2.getMODEL());

        Computer computer1 = new Computer("Dell", drive1, memory1, processor1);
        Computer computer2 = new Computer("Lenovo", drive2, memory2, processor2);

        PowerSource powerSource = new PowerSource(1.00);

        computer1.getPower(powerSource);
        computer2.getPower(powerSource);

        ComputerStore computerStore = new ComputerStore("The Computer Store");

        computerStore.addComputer(computer1);
        computerStore.addComputer(computer2);

        computerStore.getAllComputers();

        System.out.println(computerStore.toString());

    }
}
