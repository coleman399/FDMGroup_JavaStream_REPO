public class Runner {
    public static void main(String[] args) {
        System.out.println(EnergyMatterCalculator.matterToEnergy(5.0));
        System.out.println(EnergyMatterCalculator.energyToMatter(5.0));

        Employee.setMinimumWage(9.53);

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee employee3 = new Employee();

        employee1.setHourlyWage(8.53);
        employee2.setHourlyWage(8.53);
        employee3.setHourlyWage(10.53);
        
        
        System.out.println(employee1.getHourlyWage());
        System.out.println(employee2.getHourlyWage());
        System.out.println(employee3.getHourlyWage());
        
        System.out.println();
    }
}