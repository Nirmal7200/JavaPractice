package function.functionChaining;

import java.util.function.Function;

public class Compose {

    public static void main(String[] args) {


        Function<String, String> f1 = s -> s.toUpperCase();

        Function<String, String> f2 = s -> s.substring(0,9);

        System.out.println(f1.apply("nirmalmanoharan"));

        System.out.println(f2.apply("nirmalmanoharan"));

        System.out.println(f1.compose(f2).apply("nirmalmanoharan"));




    }
}
