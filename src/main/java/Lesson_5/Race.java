package Lesson_5;

import java.util.ArrayList;

class Race {
    private ArrayList<Stage> raceStages = new ArrayList<>();

    ArrayList<Stage> getStages() { return raceStages; }

    Race(Stage... stages) {
        int size = stages.length;
        for (int i = 0; i < size; i++) {
            raceStages.add(stages[i]);

            //если участок трассы последний в списке, ставлю ему флаг Финиш
            if (i==(size-1)) stages[i].setFinishLineTrue();
        }
    }
}