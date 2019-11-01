package Lesson_5;

import java.util.concurrent.atomic.AtomicInteger;

public class Main_lesson5 {
    private static final int CARS_COUNT = 4;
    private static AtomicInteger place = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(2), new Road(40));
        Car.setCyclicBarrier(CARS_COUNT);
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), place);
        }

        for (Car car : cars) {
            new Thread(car).start();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
    }
}
