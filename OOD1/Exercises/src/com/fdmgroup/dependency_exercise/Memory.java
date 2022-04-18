

public class Memory {
    private final String MODEL;
    private final double CAPACITY;
    private double usedSpace;
    private final double SPEED;

    public Memory(String model, double capacity, double speed) {
        this.MODEL = model;
        this.CAPACITY = capacity;
        this.SPEED = speed;
    }

    public void storeData(String data) {
        System.out.println("storeData method: " + data);
    }

    public double getCAPACITY() {
        return CAPACITY;
    }

    public String getMODEL() {
        return MODEL;
    }

    public double getSPEED() {
        return SPEED;
    }

    public double getUsedSpace() {
        return usedSpace;
    }

    public void setUsedSpace(double usedSpace) {
        this.usedSpace = usedSpace;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.MODEL;
    }
}
