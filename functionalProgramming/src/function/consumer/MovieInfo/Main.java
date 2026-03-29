package function.consumer.MovieInfo;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<>();

        movies.add(new Movie("Bahubali", "Prabhas", "Anushka"));
        movies.add(new Movie("Rayees", "Sharukh", "Sunny"));
        movies.add(new Movie("Dangal", "Ameer", "Ritu"));


        Consumer<Movie> consumer = m -> {
            System.out.println("Movie name "+ m.getName());
            System.out.println("Movie Hero "+ m.getHero());
            System.out.println("Movie Heroine "+ m.getHeroine());

        };

        for (Movie m : movies){
            consumer.accept(m);
        }


    }
}
