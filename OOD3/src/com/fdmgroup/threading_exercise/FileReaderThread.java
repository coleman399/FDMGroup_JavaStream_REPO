package com.fdmgroup.threading_exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderThread extends Thread {
    private AverageCalculator averageCalculator;
    private String fileName;
    private MyRunnable runnable;

    public FileReaderThread(AverageCalculator averageCalculator, String fileName) {
        this.averageCalculator = averageCalculator;
        this.fileName = fileName;
    }

    public FileReaderThread(AverageCalculator averageCalculator, String fileName, MyRunnable runnable) {
        this.averageCalculator = averageCalculator;
        this.fileName = fileName;
        this.runnable = runnable;
    }

    public AverageCalculator getAverageCalculator() {
        return averageCalculator;
    }

    public void setAverageCalculator(AverageCalculator averageCalculator) {
        this.averageCalculator = averageCalculator;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public MyRunnable getRunnable() {
        return runnable;
    }

    public void setRunnable(MyRunnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void run() {
        System.out.println("running fileReaderThread");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            reader.close();
            while (line != null) {
                String[] splitLine = line.split(",");
                for (String part : splitLine) {
                    int number = Integer.parseInt(part);
                    averageCalculator.addToTotal(number);
                }
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long getTotal() {
        return averageCalculator.getTotal();
    }

    public long getCount() {
        return averageCalculator.getCount();
    }

    public double calculateAverage() {
        return averageCalculator.calculateAverage();
    }

}
