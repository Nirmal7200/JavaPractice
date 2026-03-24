package function.Basic;

import java.util.function.Function;

public class BasicExample {


    public static void main(String[] args) {
        /**
         * Function interface has only apply method
         * Function interface using two parameters one is for input and another one is return Function<String, Long>
         *     Function<T,R> function
         */

        //Find the length of the String using Functional interface

        Function<String, Integer> f = s -> s.length();

        System.out.println(f.apply("Nirmal"));
    }
}
