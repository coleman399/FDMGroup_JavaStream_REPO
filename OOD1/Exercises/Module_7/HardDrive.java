public class HardDrive {
    private final String MODEL;
    private final double CAPACITY;
    private double usedSpace;

    public HardDrive(String model, double capacity) {
        super();
        this.MODEL = model;
        this.CAPACITY = capacity;
    }

    public String readData(String file){
        return "data from " + file;
    }

    public void writeData(String data, String file){
        System.out.println("writeData method: data = " + data + " file = " + file);
    }

    public double getCAPACITY() {
        return CAPACITY;
    }

    public String getMODEL() {
        return MODEL;
    }

    public void setUsedSpace(double usedSpace) {
        this.usedSpace = usedSpace;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
