package predicate.predicateIsEquals;

import java.util.function.Predicate;

public class BasicExample {

    public static void main(String[] args) {

        Predicate<String> s = Predicate.isEqual("Nirmal");

        System.out.println(s.test("Nirmal"));

    }
}
