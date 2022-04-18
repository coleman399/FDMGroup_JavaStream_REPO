package com.fdmgroup.threading_exercise;

public class AverageCalculator {
    private long total;
    private long count;

    public AverageCalculator() {
        this.total = 0;
        this.count = 0;
    }

    public AverageCalculator(long total, long count) {
        this.total = total;
        this.count = count;
    }

    public synchronized void addToTotal(int number) {
        this.total += number;
        this.count++;
    }

    public double calculateAverage() {
        double result = total / count;
        return result;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

}
