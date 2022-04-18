

import java.util.ArrayList;

public class ComputerStore {
    private String name;
    private ArrayList<Computer> computers = new ArrayList<Computer>();

    public ComputerStore(String name) {
        super();
        this.name = name;
    }

    public void addComputer(Computer computer) {
        computers.add(computer);
    }

    public ArrayList<Computer> getAllComputers() {
        for (Computer computer : computers) {
            System.out.println(computer);
        }
        return computers;
    }

    public ArrayList<Computer> getComputers() {
        return computers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComputers(ArrayList<Computer> computers) {
        this.computers = computers;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "(" + name + ")";
    }
}
