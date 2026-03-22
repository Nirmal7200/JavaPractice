package predicate.problemNumber3;

import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        SoftwareEngineer [] list = {
                new SoftwareEngineer("Nirmal",32, true),
                new SoftwareEngineer("Vinoth", 30, true),
                new SoftwareEngineer("JabaMani", 30, false),
                new SoftwareEngineer("Kalai", 29, false)
        };


        Predicate<SoftwareEngineer> allowed = so -> so.getAge()>=18 && so.isHavingGF()==true;

        for (SoftwareEngineer sc : list){
            if (allowed.test(sc)){
                System.out.println("Software engineer " + sc + " is allowed");
            }
        }
    }
}
