

public class Processor {
    private final String MODEL;
    private final double SPEED; 
    private final int NUMBER_OF_CORES;

    public Processor(String model, double speed, int numberOfCores) {
        super();
        this.MODEL = model;
        this.SPEED = speed;
        this.NUMBER_OF_CORES = numberOfCores;
    }

    public void storeData(String data){
        System.out.println("storeData method: " + data);
    }

    public String getMODEL() {
        return MODEL;
    }

    public double getSPEED() {
        return SPEED;
    }

    public int getNUMBER_OF_CORES() {
        return NUMBER_OF_CORES;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
