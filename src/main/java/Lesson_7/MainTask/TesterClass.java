package Lesson_7.MainTask;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

class TesterClass {
    private static Class c;

    static void Start(Class cl) {
        c = cl;
        try {
            startTest();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    static void Start(String className) {
        try {
            c = Class.forName(className);
            startTest();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException  | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void startTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("Testing started");
        //создаю экземпляр тестового класса (подписанный на интерфейс SuperTest)
        Constructor constructor = c.getDeclaredConstructor();
        SuperTest classInstance = (SuperTest) constructor.newInstance();

        Method[] methods = c.getDeclaredMethods();
        //создаю ArrayList для хранения сортированных методов и сортирую по приоритету
        ArrayList<Method> sortedMethods = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                int priority = method.getAnnotation(Test.class).priority();
                if(!(priority > 0 & priority < 10)) throw new RuntimeException("Priority out of range");
                sortedMethods.add(method);
            }
        }
        sortedMethods.sort(new PriorityComparator());

        //еще раз прохожу методы для поиска стартовой и финишной аннотации
        boolean before = false;
        boolean after = false;
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (before) throw new RuntimeException("BeforeSuite annotation occurs more than once");
                sortedMethods.add(0, method);
                before = true;
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (after) throw new RuntimeException("AfterSuite annotation occurs more than once");
                sortedMethods.add(method);
                after = true;
            }
        }

        //вызываю методы для тестирования в заданном порядке
        for (Method sortedMethod : sortedMethods) {
            sortedMethod.invoke(classInstance);
        }
        System.out.println("Testing finished" + "\n");
    }

    static class PriorityComparator implements Comparator<Method> {
        @Override
        public int compare(Method a, Method b) {
            return Integer.compare(a.getAnnotation(Test.class).priority(), b.getAnnotation(Test.class).priority());
        }
    }
}