package Lesson_4.Task_2;

import java.util.concurrent.BlockingQueue;

public class Scanner implements Runnable {
//    private final BlockingQueue<String> queue;
//    private final String POISON;
//
//    Scanner(BlockingQueue<String> queue, String poison) {
//        this.queue = queue;
//        POISON = poison;
//    }
//
//    @Override
//    public void run() {
//        try {
//            while (true) {
//                String take = queue.take();
//                if (take.equals(POISON)) break;
//                MFU.scan(take);
//            }
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//    }

    private final String text;

    Scanner(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        MFU.scan(text);
    }
}
