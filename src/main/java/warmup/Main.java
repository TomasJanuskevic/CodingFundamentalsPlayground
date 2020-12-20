package warmup;

public class Main {
    public static void main(String[] args) {
        printIInitialStudentData();

        Student[] students = constructStudentList();

        for (Student singleStudent : students) {

            processStudentCourse(singleStudent);
        }
    }


    private static Student[] constructStudentList() {
        Student mario = new Student("Mario", "Java");
        Student marc = new Student("Marc", "Java");
        Student maria = new Student("Maria", "Php");

        Student[] students = {mario, marc, maria};
        return students;
    }

    private static void printIInitialStudentData() {
        Student student = new Student();
        student.sayHello();
        System.out.println("my name is " + student.name);
        System.out.println("I am learning " + student.course);
        student.course = "Php";
        System.out.println("Now I am learning " + student.course);
    }

    private static void processStudentCourse(Student singleStudent) {
        boolean isJavaStudent = singleStudent.course.equalsIgnoreCase("java");
        if(isJavaStudent){
            System.out.println(singleStudent.name + "is a JAVA student!");
        } else {
            System.out.println(singleStudent.name + " is PHP student... unfortunately");
        }
    }
}
