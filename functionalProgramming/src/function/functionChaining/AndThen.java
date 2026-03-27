package function.functionChaining;

import java.util.function.Function;

public class AndThen {

    public static void main(String[] args) {


        Function<String, String> f1 = s -> s.toUpperCase();

        Function<String, String> f2 = s -> s.substring(0,9);

        System.out.println(f1.apply("nirmalmanoharan"));

        System.out.println(f2.apply("nirmalmanoharan"));

        System.out.println(f1.andThen(f2).apply("nirmalmanoharan"));

        Function<Integer,Integer> f3 = i -> i + i;

        Function<Integer, Integer> f4 = i -> i * i * i;

        System.out.println("And then first f3 then f4  - "+ f3.andThen(f4).apply(2));

        System.out.println("Compose first f4 then f3   - "+ f3.compose(f4).apply(2));

    }
}
