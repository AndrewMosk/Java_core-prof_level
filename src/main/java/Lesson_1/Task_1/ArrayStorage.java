package Lesson_1.Task_1;

import java.util.ArrayList;
import java.util.Arrays;

class ArrayStorage<T> {
    private T[] array;

    T[] getArray() {
        return array;
    }

    ArrayStorage(T[] array){
        this.array = array;
    }

    void swap(int firstIndex, int secondIndex){
        T temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    ArrayList convertToArrayList() {
        //идее не нравится не нравится unchecked вызов
        return new ArrayList(Arrays.asList(array));
    }
}
