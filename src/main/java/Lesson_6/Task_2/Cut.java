package Lesson_6.Task_2;

import java.util.Arrays;

public class Cut {
    private Integer intFrom = null;

    public Integer[] cutArray(Integer[] inputArray) {
        try {
            for (int i = inputArray.length - 1; i >= 0; i--) {
                if (inputArray[i]==4) {
                    intFrom = i+1;
                    break;
                }
            }
            return Arrays.copyOfRange(inputArray,intFrom,inputArray.length);
        }
        catch (NullPointerException e) {
            throw new RuntimeException();
        }
    }
}