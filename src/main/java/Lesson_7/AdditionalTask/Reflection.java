package Lesson_7.AdditionalTask;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Reflection {
    static String path = "F:/Lesson7_reflection";

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        File file = new File(path);
        String[] files = file.list();

        for (String fileName: files) {
            String[] mass = fileName.split("\\.");

            if (!mass[1].equalsIgnoreCase("class")) throw new RuntimeException(fileName, new Exception());

            Class ch = URLClassLoader.newInstance(new URL[]{new File(path).toURL()}).loadClass(mass[0]);
            Constructor constructor = ch.getConstructor();
            Object cl = constructor.newInstance();

            Method[] methods = ch.getDeclaredMethods();

            for (int i = 0; i < methods.length; i++) {

                Object[] params = new Object[methods[i].getParameterTypes().length];
                methods[i].setAccessible(true);
                System.out.println(methods[i].getName());
                int j = 0;

                for (Class clas: methods[i].getParameterTypes()) {

                    if ((methods[i].getName().equals("calculate"))|| (methods[i].getName().equals("checkTwoNumbers"))) {
                        int k = 0;
                    }

                    if (clas.isPrimitive() || clas.equals(String.class)) {
                        if (clas.equals(byte.class)) {
                            params[j] = (byte) 125;
                        } else if (clas.equals(short.class)) {
                            params[j] = (short) 200;
                        } else if (clas.equals(char.class)) {
                            params[j] = 'c';
                        } else if (clas.equals(int.class)) {
                            params[j] = 18;
                        } else if (clas.equals(long.class)) {
                            params[j] = 555L;
                        } else if (clas.equals(float.class)) {
                            params[j] = 125.0f;
                        } else if (clas.equals(double.class)) {
                            params[j] = 125.0;
                        } else if (clas.equals(boolean.class)) {
                            params[j] = true;
                        } else if (clas.equals(String.class)) {
                            params[j] = "Bob";
                        }
                    }else {
                        //использовать конструктор класса
                    }
                    j++;
                }
                System.out.println(methods[i].invoke(cl, params));

            }


            //Constructor constructor = ch.getConstructor(String.class);
        }
    }




}
