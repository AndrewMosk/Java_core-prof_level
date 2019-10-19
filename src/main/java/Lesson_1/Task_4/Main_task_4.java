package Lesson_1.Task_4;

import java.util.HashMap;

public class Main_task_4 {
    public static void main(String[] args) {
        TestList testList =new TestList(new Test(1, "test1"), new Test(2, "test1"), new Test(1, "test2"), new Test(3, "test1"),new Test(2, "test2"));

        HashMap hashMap = testList.convertToHashMap();
        System.out.println(hashMap);
    }
}
