package function.totalEmpMonthSal;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {


    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<Employee>();

        employees.add(new Employee("Nirmal", 144600));
        employees.add(new Employee("Jayaganesh", 320000));
        employees.add(new Employee("Rohit", 130000));
        employees.add(new Employee("Arun", 120000));


        Function<ArrayList<Employee>, Double> function = emp -> {
            double total = 0;

            for(Employee e: employees){
                total = total + e.getSalary();
            }
            return total;
        };

        System.out.println(STR."Total salary of all employee - \{function.apply(employees)}");

        Predicate<Employee> employeePredicate = emp -> emp.getSalary()<130000;

       Function<Employee, Employee> function1 = e -> {
           e.setSalary(e.getSalary() + e.getSalary() + 10000);

           return e;
       };


       ArrayList<Employee> l2 = new ArrayList<>();

       for (Employee e : employees){
           if (employeePredicate.test(e)){
               l2.add(function1.apply(e));
           }
       }

        System.out.println(l2);

    }
}
