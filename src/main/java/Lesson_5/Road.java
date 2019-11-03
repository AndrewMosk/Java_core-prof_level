package Lesson_5;

public class Road extends Stage {
    Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
        this.finishLine = false;
    }

    @Override
    public void setFinishLineTrue () {
        this.finishLine = true;
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);

            if (finishLine) c.defineWinner();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
