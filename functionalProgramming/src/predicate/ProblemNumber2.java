package predicate;

import java.util.Scanner;
import java.util.function.Predicate;

public class ProblemNumber2 {

    public static void main(String[] args) {
        // Problem for user authentication by using predicate

        Predicate<User> output = user -> user.getName().equals("Nirmal") && user.getPassword().equals("Jesus");


        System.out.println("Enter User Name");

        Scanner sc = new Scanner(System.in);

        String name = sc.next();

        System.out.println("Enter Password");

        String password =  sc.next();

        User users = new User(name, password);

        if (output.test(users)){
            System.out.println("Valid user");
        }else {
            System.out.println("User not found");
        }

    }
}

class User{

    String name;
    String password;

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
