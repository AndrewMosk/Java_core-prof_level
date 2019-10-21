package Lesson_1.Task_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main_task_1 {
    public static void main(String[] args) {
        //тестовый массив
        String[] array = {"1","2","3","4","5"};
        int firstIndex = 0;
        int secondIndex = 4;

        //создаю хранилище
        ArrayStorage<String> arrayStorage = new ArrayStorage<>(array);

        //меняю элементы местами
        arrayStorage.swap(firstIndex, secondIndex);
        System.out.println(Arrays.toString(arrayStorage.getArray()));

        //получаю ArrayList
        ArrayList arrayList = arrayStorage.convertToArrayList();
        System.out.println(arrayList);
    }
}
