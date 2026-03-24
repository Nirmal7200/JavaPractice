package predicate.management;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();

        Employee el = new Employee("Nirmal", "Senior Software Engineer", 144000,"Chennai");
        Employee e2 = new Employee("Vinoth", "Manager", 300000,"Chennai");


        list.add(el);
        list.add(e2);


        Predicate<Employee> findingManager = emp -> emp.getDesignation().equals("Manager") && emp.getCity().equals("Chennai");

            display(findingManager, list);


            display(findingManager.negate(), list);


    }


    public static void display(Predicate<Employee> p, ArrayList<Employee> list){


        for (Employee e : list){
            if (p.test(e)){
                System.out.println(e);
            }
        }

    }
}
