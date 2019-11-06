package Lesson_6.Task_3;

import java.util.Arrays;
import java.util.Optional;

public class FindNumbers {

    public Boolean numbersSearch(Integer[] input) {
        for (int i : input) {
            if (i!=1 & i!=4) {
                return Boolean.FALSE;
            }
        }
        Optional optional_1 = Arrays.stream(input).filter(x -> 1==x).findFirst();
        Optional optional_4 = Arrays.stream(input).filter(x -> 4==x).findFirst();

        return optional_1.isPresent() & optional_4.isPresent();
    }
}