package predicate;

import java.util.function.Predicate;

public class ProblemNumber0 {


    public static void main(String[]args){

        String[] name = {"Jesus", "Father", "Son"};

        Predicate<String> startWithJ = n -> n.startsWith("J");

        for (String s : name){
            if (startWithJ.test(s)){
                System.out.println(s);
            }
        }


    }


}
