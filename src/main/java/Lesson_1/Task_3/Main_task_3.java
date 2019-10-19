package Lesson_1.Task_3;

public class Main_task_3 {
    public static void main(String[] args) throws ClassNotFoundException {

        Box<Apple> boxApple = new Box<>(Apple.class, 15);
        Box<Orange> boxOrange = new Box<>(Orange.class, 10);

        System.out.println(boxApple.compare(boxOrange));
        Box<Apple> boxAppleNew = new Box<>(Apple.class, 10);
        boxApple.moveFruits(boxAppleNew);

        boxApple.getInfo();
        boxAppleNew.getInfo();
    }
}
