package function.consumer.consumerChaining;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {


        ArrayList<Movie> movies = new ArrayList<>();

        movies.add(new Movie("Bagubali", "Hit"));
        movies.add(new Movie("Samsun", "Hit"));
        movies.add(new Movie("polathavan", "moderate"));
        movies.add(new Movie("Over the world", "flop"));


        Consumer<Movie> c1 = movie -> System.out.println("Movie "+ movie.getName() + "is ready to release");

        Consumer<Movie> c2 = movie -> System.out.println("Movie "+ movie.getName() + "is" + movie.getResult());

        Consumer<Movie> c3 = movie -> System.out.println("Movie "+ movie.getName() + "information storing in database");

        Consumer<Movie> chainedConsumer = c1.andThen(c2).andThen(c3);

        for (Movie m : movies){
            chainedConsumer.accept(m);

        }

    }
}
