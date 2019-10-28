package Lesson_3.Task_4;

import java.io.Serializable;

class ObjectToTransfer implements Serializable {
    private int intDataField;
    private String stringDataField;

    ObjectToTransfer(int intDataField, String stringDataField) {
        this.intDataField = intDataField;
        this.stringDataField = stringDataField;
    }

    void info() {
        System.out.println("Число " + intDataField + ", строка " + stringDataField);
    }
}
