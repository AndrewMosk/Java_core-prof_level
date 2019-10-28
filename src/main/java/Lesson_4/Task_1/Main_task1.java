package Lesson_4.Task_1;

public class Main_task1 {
    public static void main(String[] args) {
        Message msg = new Message("обработать");
        Waiter waiter = new Waiter(msg);
        new Thread(waiter,"waiter").start();

        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter1").start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();
        System.out.println("Стартовали все потоки");
    }
}

class Message {
    // поле, с которым будут работать потоки через вызовы геттеров и сеттеров
    private String msg;
    Message(String str) {this.msg = str;}

    String getMsg() {return msg;}

    void setMsg(String str) {this.msg = str;}
}

class Waiter implements Runnable{
    private final Message msg;

    Waiter(Message m){this.msg = m;}

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try{
                System.out.println(name + " ждем вызов метода notify: " + System.currentTimeMillis());
                msg.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(name + " был вызов метода notify: " + System.currentTimeMillis());
            // обработаем наше сообщение
            System.out.println(name + " : " + msg.getMsg());
        }
    }
}

class Notifier implements Runnable {
    private final Message msg;
    Notifier(Message msg) {this.msg = msg;}

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " стартовал");
        try {
            Thread.sleep(1000);
            synchronized (msg) {
                msg.setMsg(name + " поток Notifier отработал");
                msg.notify();
                // msg.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}