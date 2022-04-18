

public class EnergyMatterCalculator {
    public static final double SPEED_OF_LIGHT = 299792458.00;

    public static double matterToEnergy(double matter) {
        double energy = matter * (SPEED_OF_LIGHT * SPEED_OF_LIGHT);
        return energy;
    }

    public static double energyToMatter(double energy) {
        double matter = energy / (SPEED_OF_LIGHT * SPEED_OF_LIGHT);
        return matter;
    }

    public static double getSpeedOfLight() {
        return SPEED_OF_LIGHT;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}