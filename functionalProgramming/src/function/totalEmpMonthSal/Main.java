package function.totalEmpMonthSal;

import java.util.ArrayList;
import java.util.function.Function;

public class Main {


    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<Employee>();

        employees.add(new Employee("Nirmal", 144600));
        employees.add(new Employee("Jayaganesh", 320000));
        employees.add(new Employee("Rohit", 130000));
        employees.add(new Employee("Arun", 350000));


        Function<ArrayList<Employee>, Double> function = emp -> {
            double total = 0;

            for(Employee e: employees){
                total = total + e.getSalary();
            }
            return total;
        };

        System.out.println(function.apply(employees));
    }
}
