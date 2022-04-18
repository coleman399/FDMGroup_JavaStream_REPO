package com.fdmgroup.dependency_exercise;

public class PowerSource {
    double watts;

    public PowerSource(double watts) {
        this.watts = watts;
    }

    public double supplyPower() {
        return this.watts;
    }

    public double getWatts() {
        return this.watts;
    }

    public void setWatts(double watts) {
        this.watts = watts;
    }
}
