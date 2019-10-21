package Lesson_1.Task_3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;

class Box<T extends Fruit> {
    private ArrayList<Fruit> boxContent;
    private Class fruit;

    Box(Class fruit, int count){
        try {
            this.fruit = fruit;
            this.boxContent = fillBox(count);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void addFruit(Fruit fruit){
        boxContent.add(fruit);
    }

    void moveFruits(Box<T> receiverBox){
        Iterator<Fruit> iterator = boxContent.iterator();
        Fruit currentFruit;
        while (iterator.hasNext()){
            currentFruit = iterator.next();

            iterator.remove();
            receiverBox.addFruit(currentFruit);
        }
    }

    void getInfo(){
        System.out.println("В ящике " + boxContent.size() + " объектов типа " + fruit.getName());
    }

    private ArrayList<Fruit> fillBox(int count) throws IllegalAccessException, InstantiationException,  NoSuchMethodException, InvocationTargetException {
        //тут идее, как и в классе ArrayStorage не нравится unchecked вызов
        Constructor constructor = fruit.getDeclaredConstructor();

        ArrayList<Fruit> arrayList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            //вроде как в этом случае использовать каст допустимо
            arrayList.add((Fruit) constructor.newInstance());
        }

        return arrayList;
    }

    private float getWeight(){
        float  weight = 0.f;
        for (Fruit fruit: boxContent) weight += fruit.getWeight();

        return weight;
    }

    boolean compare(Box<?> boxToCompare){
        float selfWeight = this.getWeight();
        float anotherWeight = boxToCompare.getWeight();

        return (selfWeight==anotherWeight);
    }
}