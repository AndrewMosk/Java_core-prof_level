package Lesson_4.Task_2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.*;

public class Main_task2 {

    public static void main(String[] args) {

//        ExecutorService service = Executors.newSingleThreadExecutor();
//        for (int i = 0; i < 10; i++) {
//            service.execute(new Printer("printer text " + i));
//        }
//        service.shutdown();
//
//
//        ExecutorService service1 = Executors.newSingleThreadExecutor();
//        for (int i = 0; i < 10; i++) {
//            service1.execute(new Scanner("scanner text " + i));
//        }
//        service1.shutdown();



//        //очередь на печать
//        BlockingQueue<String> queue = new LinkedBlockingQueue<>(11);
//        String POISON = "poison";
//
//        for (int i = 0; i < 10; i++) {
//            try {
//                queue.put("text printer " + i);
//                if (i==9) queue.put(POISON);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        //очередь на сканирование
//        BlockingQueue<String> queue1 = new LinkedBlockingQueue<>(11);
//        String POISON1 = "poison";
//        for (int i = 0; i < 10; i++) {
//            try {
//                queue1.put("text scan " + i);
//                if (i==9) queue1.put(POISON1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//        new Thread(new Printer(queue,POISON)).start();
//        new Thread(new Scanner(queue1,POISON1)).start();
//

//        ExecutorService service = Executors.newCachedThreadPool();
//        for(int i = 0; i < 10; i++) {
//            service.submit(new Printer("text printer " + i));
//        }
//        service.shutdown();
//
//        ExecutorService service1 = Executors.newCachedThreadPool();
//        for(int i = 0; i < 10; i++) {
//            service1.submit(new Scanner("text scanner " + i));
//        }
//        service1.shutdown();

        User user1 = new User("print");
        User user2 = new User("scan");
        user1.start();
        user2.start();

    }


}
