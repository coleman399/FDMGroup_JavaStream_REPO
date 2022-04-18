package com.fdmgroup.threading_exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateNumberFiles {

    public static void main(String[] args) {
        String records1 = "C:\\Users\\Pendragon\\OneDrive\\Documents\\Save\\Programming\\Project Explorer\\Java Projects\\OOD3\\src\\com\\fdmgroup\\threading_exercise\\test_files\\records1.txt";
        String records2 = "C:\\Users\\Pendragon\\OneDrive\\Documents\\Save\\Programming\\Project Explorer\\Java Projects\\OOD3\\src\\com\\fdmgroup\\threading_exercise\\test_files\\records2.txt";
        System.out.println("Creating first file");
        createNumberFile(
                records1,
                500000, 100);
        System.out.println("Creating second file");
        createNumberFile(
                records2,
                500000, 100);
        System.out.println("Second file completed");

        AverageCalculator averageCalculator = new AverageCalculator();
        FileReaderThread fileReaderThread1 = new FileReaderThread(averageCalculator, records1,
                new MyRunnable("records1"));
        FileReaderThread fileReaderThread2 = new FileReaderThread(averageCalculator, records2,
                new MyRunnable("records2"));
        Thread currentTotalThread = new Thread(new MyRunnable("currentTotalThread") {
            public void run() {
                while (true) {
                    System.out.println("records1 | total: " + fileReaderThread1.getTotal() + " | count: "
                            + fileReaderThread1.getCount() + " | average: " + fileReaderThread1.calculateAverage());
                    System.out.println("records2 | total: " + fileReaderThread2.getTotal() + " | count: "
                            + fileReaderThread2.getCount() + " | average: " + fileReaderThread2.calculateAverage());
                    try {
                        FileReaderThread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        fileReaderThread1.start();
        System.out.println("fileReaderThread1 started");
        fileReaderThread2.start();
        System.out.println("fileReaderThread2 started");
        currentTotalThread.start();
        System.out.println("currentTotalThread started");
        try {
            fileReaderThread1.join();
            fileReaderThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------");
        System.out.println("records1");
        System.out.println("-------------------------");
        System.out.println("total: " + fileReaderThread1.getTotal());
        System.out.println("count: " + fileReaderThread1.getCount());
        System.out.println("average: " + fileReaderThread1.calculateAverage());
        System.out.println("-------------------------");
        System.out.println("records2");
        System.out.println("-------------------------");
        System.out.println("total: " + fileReaderThread2.getTotal());
        System.out.println("count: " + fileReaderThread2.getCount());
        System.out.println("average: " + fileReaderThread2.calculateAverage());
        System.out.println("-------------------------");

        currentTotalThread.interrupt();
    }

    public static void createNumberFile(String fileName, int numberOfLines, int maxNumber) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (int lineNumber = 1; lineNumber <= numberOfLines; lineNumber++) {
                int numberOfRecords = (int) (Math.random() * 90);
                numberOfRecords += 10;
                String line = "";
                for (int record = 1; record <= numberOfRecords; record++) {
                    int data = (int) (Math.random() * maxNumber);
                    line = line + data + ",";
                }
                line = line.substring(0, line.length() - 1);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
