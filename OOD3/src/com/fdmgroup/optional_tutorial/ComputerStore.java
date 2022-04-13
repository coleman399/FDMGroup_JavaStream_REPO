package com.fdmgroup.optional_tutorial;

import java.util.List;
import java.util.Optional;

public class ComputerStore {
    List<Computer> computers;

    public Optional<List<Computer>> getComputers() {
        return Optional.ofNullable(computers);
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }

}
