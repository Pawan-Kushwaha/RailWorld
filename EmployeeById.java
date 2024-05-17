package Collection;

public class EmployeeById implements Comparator<Employee> {


    @Override
    public String compare(Employee o1, Employee o2) {
        return compare(o1.geteName(),o2.geteName());
    }
}
