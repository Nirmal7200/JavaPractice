package function.userAuthentication;

import java.util.Scanner;
import java.util.function.Function;

public class Main {


    public static void main (String[]args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your user name");

        String user = sc.next();

        System.out.println("Enter your password");

        String pwd = sc.next();

        Function<String, String> f1 = s -> s.substring(0,5);

        Function<String, String> f2 = s -> s.toLowerCase();

        if (f1.andThen(f2).apply(user).equals("nirma") && pwd.equals("java")){
            System.out.println("Valid user");
        } else {
            System.out.println("Not a valid user");
        }
    }
}
