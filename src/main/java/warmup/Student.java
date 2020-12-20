package warmup;

public class Student {
    public String name = "Mark";
    private int grade = 5;
    public String course = "Java";

    public Student() {

    }

    public Student(String name, String newCourse) {
        this.name = name;
        this.course = newCourse;
    }

    public void sayHello() {
        System.out.println("Laba diena...");
        whisper();
        whisper();
    }

    private void whisper() {
        System.out.println("I am a good student!");
    }
}
