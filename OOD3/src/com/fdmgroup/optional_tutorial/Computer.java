package com.fdmgroup.optional_tutorial;

import java.util.Optional;

public class Computer {
    private String model;
    private Motherboard motherboard;

    public Computer(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Optional<Motherboard> getMotherboard() {
        return Optional.ofNullable(motherboard);
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    @Override
    public String toString() {
        return "Computer [model=" + model + ", motherboard=" + motherboard + "]";
    }
}
