package Lesson_4.Task_1;

class PrintCall implements Runnable {
    private final Print print;
    private  String letter;

    PrintCall(Print print, String letter) {
        this.print = print;
        this.letter = letter;
    }

    @Override
    public void run() {
        synchronized (print) {
            for (int i = 1; i < 6; i++) {
                print.print(letter);
            }
        }
    }
}