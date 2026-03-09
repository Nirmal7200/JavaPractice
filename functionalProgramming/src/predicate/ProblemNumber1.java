package predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ProblemNumber1 {

    public static void main(String[] args) {
        //Predicate to remove null values in the array

        String[] name = {"Nirmal", " ", null, "Madhana", " ", "Jonathan", null, " "};

        ArrayList<String> output =  new ArrayList<>();

        Predicate<String> p = s-> s!=null && s.length()!=0;

        for (String n : name){
            if (p.test(n)){
                output.add(n);
            }

        }

        System.out.println(output);

    }
}
