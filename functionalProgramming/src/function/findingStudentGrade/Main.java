package function.findingStudentGrade;

import java.util.ArrayList;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {


        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Nirmal", 80));
        students.add(new Student("Vinoth", 90));
        students.add(new Student("Josh", 50));
        students.add(new Student("trump", 30));

        Function<Student, String> function = student -> {
            int marks = student.getMarks();

            if (marks>=80){
                return "Distinction";
            } else if (marks>=50) {
                return "First class";
            } else if (marks>=35) {
                return "Second class";
            } else {
                return "Fail";
            }
        };


        for (Student student: students){

            System.out.println(student.getName());
            System.out.println(student.getMarks());
            System.out.println(function.apply(student));
        }

    }
}
