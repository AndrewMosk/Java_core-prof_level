package Lesson_3.Task_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.stream.Stream;

public class Main_task5 {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("Lesson3_test_files/test_reverse.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            Stream<String> stream = bufferedReader.lines();
            stream.sorted(Collections.reverseOrder()).forEach(System.out::println);

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
