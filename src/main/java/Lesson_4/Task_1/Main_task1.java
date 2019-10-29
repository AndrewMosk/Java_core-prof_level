package Lesson_4.Task_1;

public class Main_task1 {
    public static void main(String[] args) {
        Print print = new Print();

        PrintCall printCall_a = new PrintCall(print, "A");
        PrintCall printCall_b = new PrintCall(print, "B");
        PrintCall printCall_c = new PrintCall(print, "C");

        new Thread(printCall_a).start();
        new Thread(printCall_b).start();
        new Thread(printCall_c).start();

        /*
        выполняется условие на вход в поток, который печатает А , потоки В и С засыпают
        поток А напечатал, ход на В перекинул и будит все остальные потоки
        выполняется условие на вход в поток В, потоки А и С засыпают
        поток В напечатал, ход на С перекинул и будит все остальные потоки
        выполняется условие на вход в поток С, потоки А и В засыпают
        поток С напечатал, ход на А перекинул и будит все остальные потоки
        */
    }
}