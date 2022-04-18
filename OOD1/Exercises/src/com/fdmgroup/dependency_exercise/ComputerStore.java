

import java.util.ArrayList;

public class ComputerStore {
    private String name;
    private ArrayList<Computer> computers = new ArrayList<Computer>();

    public ComputerStore(String name) {
        this.name = name;
    }

    public void addComputer(Computer computer) {
        computers.add(computer);
    }

    public ArrayList<Computer> getAllComputers() {
        return computers;
    }

    public String getName() {
        return name;
    }

    public void setComputers(ArrayList<Computer> computers) {
        this.computers = computers;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name;
    }
}
