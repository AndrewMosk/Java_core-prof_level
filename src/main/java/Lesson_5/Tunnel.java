package Lesson_5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private static Semaphore semaphore;

    Tunnel(int bandwidth) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.finishLine = false;
        semaphore = new Semaphore(bandwidth);
    }

    @Override
    public void setFinishLineTrue() {
        this.finishLine = true;
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphore.release();

                if (finishLine) c.defineWinner();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
