package lesson7;

import org.junit.Test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Iterator;

public class ReflectionApp {
    public static void main(String[] args) throws Exception {
        File file = new File("/home/safia/courses/Java2/for_lesson7_homeWork");
        String [] str = file.list();
        ArrayList<String> fileName = new ArrayList<>();

        for (String o: str) {
            String [] mass = o.split("\\.");
            if (mass[1].equalsIgnoreCase("class")) {
                fileName.add(mass[0]);
            }
        }

        Iterator iterator = fileName.iterator();
        while (iterator.hasNext()) {
            String name = String.valueOf(iterator.next());
            Class cl = URLClassLoader.newInstance(new URL[]{file.toURL()}).loadClass(name);
            Constructor constructor = cl.getConstructor();//можно указать тип параметров ожидаемых в конструкторе, например String.class
            Object test1 = constructor.newInstance();
            Method method = cl.getDeclaredMethod("myMethod", double.class, double.class, double.class,  double.class);
            Method method1 = cl.getDeclaredMethod("info");

            method1.invoke(test1);
            System.out.println(method.invoke(test1, 5.0,2.0,1.0,1.0));
        }









    }

}
