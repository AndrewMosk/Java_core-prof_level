package Lesson_4.Task_1;

class Print {
    private String turn = "A";

    void print(String letter) {
        while (!turn.equals(letter)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(letter);

        switch (letter) {
            case "A": turn = "B"; break;
            case "B": turn = "C"; break;
            case "C": turn = "A"; break;
        }
        notifyAll();
    }
}