package Lesson_4.Task_2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main_task2 {
    public static void main(String[] args) {
//        //Queue<String> stack = Collections.asLifoQueue(new ArrayDeque<>());
//        Queue<Printer> stack = new ArrayDeque<>();
//        stack.addAll(Arrays.asList(new Printer("text printer 1"), new Printer("text printer 2"), new Printer("text printer 3"), new Printer("text printer 4")));
//        stack.forEach(element -> new Thread(element).start());
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);
        String POISON = "poison";

        for (int i = 0; i < 10; i++) {
            try {
                queue.put("text printer " + i);
                //if (i==9) queue.put(POISON);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        new Thread(new Printer(queue,POISON)).start();

    }
}
