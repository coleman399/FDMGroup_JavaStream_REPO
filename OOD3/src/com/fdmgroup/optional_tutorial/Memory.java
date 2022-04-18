

public class Memory {
    private String model;

    public Memory(String model) {
        this.model = model;
    }

    public void accessData() {
        System.out.println("accessing data");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Memory [model=" + model + "]";
    }

}
