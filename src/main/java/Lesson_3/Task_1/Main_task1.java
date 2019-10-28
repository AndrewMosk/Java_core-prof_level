package Lesson_3.Task_1;

import java.io.FileInputStream;
import java.io.IOException;

public class Main_task1 {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("Lesson3_test_files/test.txt");

            int x;
            while ((x=in.read()) !=- 1){
                System.out.print(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
