package Lesson_4.Task_2;

import java.util.concurrent.BlockingQueue;

public class Printer implements Runnable {
    private final BlockingQueue<String> queue;
    private final String POISON;
    //private String text;

    Printer(BlockingQueue<String> queue, String poison) {
        this.queue = queue;
        //this.text = text;
        POISON = poison;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String take = queue.take();
                if (take.equals("poison")) break;
                MFU.print(take);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
