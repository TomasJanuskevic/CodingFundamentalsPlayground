package filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderMain {
    private static final String FILE_LOCATION = "src/main/java/filereader/duomenys.txt";

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_LOCATION))) {

            String singleFileLine = bufferedReader.readLine();

            List<Student> studentList = new ArrayList<>();

            while (singleFileLine != null) {
                Student student = new Student(singleFileLine);
                studentList.add(student);
                singleFileLine = bufferedReader.readLine();
            }
            System.out.println(studentList.toString());


        } catch (IOException exception) {
            System.out.println("Ivyko klaida nuskaitant faila");
        }
    }
}
