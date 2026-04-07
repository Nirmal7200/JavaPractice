package function.consumer.UsingFunctionAndPAndC;

import function.findingStudentGrade.Student;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        ArrayList<function.findingStudentGrade.Student> students = new ArrayList<>();

        students.add(new function.findingStudentGrade.Student("Nirmal", 80));
        students.add(new function.findingStudentGrade.Student("Vinoth", 90));
        students.add(new function.findingStudentGrade.Student("Josh", 50));
        students.add(new Student("trump", 30));


        Predicate<Student>  p = student -> student.getMarks()>=60;

        Function<Student, String> function = student -> {
            int marks = student.getMarks();
            if (marks>=80){
                return "A";
            } else if (marks>=60) {
                return "B";
            } else if (marks>=30) {
                return "C";
            } else {
                return "FAIL";
            }
        };

        Consumer<Student> c  = student -> {
            System.out.println("Name " + student.getName());
            System.out.println("Marks " + student.getMarks());
            System.out.println("Grade  "+ function.apply(student));

        };

        for (Student s : students){

            if (p.test(s)){
                c.accept(s);
            } else {
                c.accept(s);
            }


        }


    }
}
