package function.Basic;

import java.util.function.Function;

public class RemoveSpaces {

    public static void main(String[] args) {


        String s ="Ni rm al";


        Function<String,String> f = str -> str.replaceAll(" ", "");

        System.out.println("Remove spaces "+ f.apply(s));

        Function<String, Integer> f1 = st1 -> st1.length() - st1.replaceAll(" ","").length();

        System.out.println(f1.apply(s));
    }
}
