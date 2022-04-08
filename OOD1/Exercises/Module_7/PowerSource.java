public class PowerSource {
    double watts;

    public PowerSource(double watts) {
        this.watts = watts;
    }

    public double supplyPower() {
        System.out.println("Power Supply sending " + watts + " watts.");
        return watts;
    }
}
