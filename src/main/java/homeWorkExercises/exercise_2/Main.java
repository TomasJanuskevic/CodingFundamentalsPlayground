package homeWorkExercises.exercise_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scannerString = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            Student student = new Student();
            System.out.println("Studento vardas:");
            student.setName(scannerString.nextLine());
            System.out.println("Studento amzius:");
            student.setAge(scannerInt.nextInt());
            System.out.println("Studento pazymys:");
            student.setGrade(scannerInt.nextInt());
            students.add(student);
        }

        for (Student student : students) {
            System.out.println(student);
        }

        students.get(0).setGrade(10);

        System.out.println(students.get(0));
    }


}
