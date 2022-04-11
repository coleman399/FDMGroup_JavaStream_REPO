package lambdas.employee;

@FunctionalInterface
public interface EmployeeFilter {
    
    public abstract boolean filterEmployee(Employee employee);

}
