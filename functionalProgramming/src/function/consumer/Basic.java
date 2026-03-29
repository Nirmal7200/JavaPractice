package function.consumer;

import java.util.function.Consumer;

/**
 * Consumer interface does not return anything.
 * Consumer  had the accept method.
 */


public class Basic {

    public static void main(String[] args) {


        Consumer<String> consumer = s -> System.out.println(s);

        consumer.accept("Nirmal");

    }
}
