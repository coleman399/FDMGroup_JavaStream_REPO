public class Memory {
    private final String MODEL;
    private final double CAPACITY;  
    private final double USEDSPACE;
    private double speed;

    public Memory(String model, double capacity, double usedSpace) {
        super();
        this.MODEL = model;
        this.CAPACITY = capacity;
        this.USEDSPACE = usedSpace;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getCAPACITY() {
        return CAPACITY;
    }

    public String getMODEL() {
        return MODEL;
    }

    public double getUSEDSPACE() {
        return USEDSPACE;
    }
    
    public void storeData(String data) {
        System.out.println("storeData method: " + data);
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
