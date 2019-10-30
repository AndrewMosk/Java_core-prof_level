package Lesson_4.Task_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class User {
    private String action;
    private final String print = "print";
    private final String scan = "scan";

    User(String  action) {
        this.action = action;
    }

    void start() {
        if (action.equals(print)) {
            ExecutorService service = Executors.newCachedThreadPool();
            for(int i = 0; i < 10; i++) {
                service.submit(new Printer("text printer " + i));
            }
            service.shutdown();
        }else if (action.equals(scan)){
            ExecutorService service1 = Executors.newCachedThreadPool();
            for(int i = 0; i < 10; i++) {
                service1.submit(new Scanner("text scanner " + i));
            }
            service1.shutdown();
        }
    }
}
