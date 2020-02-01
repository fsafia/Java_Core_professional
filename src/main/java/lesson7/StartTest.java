package lesson7;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class StartTest {
    public Class cl;


    public StartTest(Class cl) {
        this.cl = cl;
    }

    public void start() {
        Method [] methods = cl.getDeclaredMethods();
        ArrayList<Method> methodsTest = new ArrayList<>();
        for (Method o : methods ) {
            if (o.isAnnotationPresent(MyTest.class)) {
                methodsTest.add(o);
            }
        }

        methodsTest.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o1.getAnnotation(MyTest.class).priotity() - o2.getAnnotation(MyTest.class).priotity();
            }
        });

        for (Method o : methods ) {
            int countAfter = 0;
            int countBefore = 0;
            if (o.isAnnotationPresent(AfterSuite.class )) {
                countAfter++;
                methodsTest.add(methodsTest.size(), o);
            }

            if (o.isAnnotationPresent(BeforeSuite.class)) {
                countBefore++;
                methodsTest.add(0, o);
            }

            if (countAfter > 1 || countBefore > 1) {
                throw new RuntimeException();
            }
        }

            try {
                Constructor constructor = cl.getConstructor();
                Object myCl = constructor.newInstance();
                for (Method o : methodsTest ) {
                    o.invoke(myCl);
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
