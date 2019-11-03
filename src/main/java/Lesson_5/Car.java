package Lesson_5;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {
    private static int CARS_COUNT = 0;
    private static CyclicBarrier cyclicBarrier;
    private AtomicInteger place;

    static void setCyclicBarrier(int parties) {
        Car.cyclicBarrier = new CyclicBarrier(parties);
    }

    private Race race;
    private int speed;
    private String name;

    void defineWinner() {
        place.incrementAndGet();

        String winner = "";
        if (place.get() == 1) winner = " Победитель!!!";
        System.out.println(this.name + " гонку закончил! Место " + place + winner);

        if (place.get()==CARS_COUNT) System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

    String getName() {
        return name;
    }

    int getSpeed() {
        return speed;
    }

    Car(Race race, int speed, AtomicInteger place) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.place = place;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            //жду, пока все подготовятся
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Stage stage : race.getStages()) {
            stage.go(this);
        }
    }
}
