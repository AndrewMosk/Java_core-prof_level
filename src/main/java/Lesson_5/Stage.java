package Lesson_5;

public abstract class Stage {
    int length;
    String description;
    boolean finishLine;

    public String getDescription() {
        return description;
    }

    public abstract void setFinishLineTrue ();

    public abstract void go(Car c);
}