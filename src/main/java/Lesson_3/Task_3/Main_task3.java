package Lesson_3.Task_3;

import java.io.IOException;
import java.util.Scanner;

public class Main_task3 {
    public static void main(String[] args) {
        try {
            E_book e_book = new E_book(2048, "Lesson3_test_files/mac masks.txt");

            while (true) {
                long pages = e_book.getPagesNumber();
                Scanner sc = new Scanner(System.in);
                System.out.println("Для выхода введите -1");
                System.out.println("В файле " + pages + " страницы. Введите требуемую страницу: ");

                int page = sc.nextInt()-1;
                if (page == -2) break;//-2 т.к. отнимаю единицу
                if (page<pages && page>=0) {
                    e_book.printPage(page);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
