package function.identity;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        //Functional interface contains the static method that is identity


        Function<String, String> f1 = Function.identity();

        String s2 = f1.apply("Nirmal");

        System.out.println(s2);

    }


}
