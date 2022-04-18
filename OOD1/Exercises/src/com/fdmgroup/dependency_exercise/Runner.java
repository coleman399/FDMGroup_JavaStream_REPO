package com.fdmgroup.dependency_exercise;

public class Runner {
    public static void main(String[] args) {

        HardDrive drive1 = new HardDrive("Seagate", 2048);
        HardDrive drive2 = new HardDrive("Dell", 3072);

        System.out.println(drive1.getMODEL());
        System.out.println(drive1.getCAPACITY());
        System.out.println(drive2.getMODEL());
        System.out.println(drive2.getCAPACITY());

        Processor processor1 = new Processor("Intel Xeon", 2.93, 6);
        Processor processor2 = new Processor("Intel Celeron", 2.9, 2);

        System.out.println(processor1.getMODEL());
        System.out.println(processor1.getSPEED());
        System.out.println(processor1.getNUMBER_OF_CORES());
        System.out.println(processor2.getMODEL());
        System.out.println(processor2.getSPEED());
        System.out.println(processor2.getNUMBER_OF_CORES());

        Memory memory1 = new Memory("Kingston", 4.0, 1600);
        Memory memory2 = new Memory("Corsair", 8.0, 1333);

        System.out.println(memory1.getMODEL());
        System.out.println(memory1.getSPEED());
        System.out.println(memory1.getCAPACITY());
        System.out.println(memory2.getMODEL());
        System.out.println(memory2.getSPEED());
        System.out.println(memory2.getCAPACITY());

        drive1.setUsedSpace(50);
        System.out.println(drive1.getUsedSpace());

        PowerSource powerSource = new PowerSource(5.0);

        Computer computer1 = new Computer("Dell", drive1, memory1, processor1);
        Computer computer2 = new Computer("Lenovo", drive2, memory2, processor2);

        computer1.getPower(powerSource);

        ComputerStore computerStore = new ComputerStore("The Computer Store");
        computerStore.addComputer(computer1);
        computerStore.addComputer(computer2);

        System.out.println(computerStore.getAllComputers());
    }
}
