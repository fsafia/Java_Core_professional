package lesson7;

public class MainClassAnnotation {
    public static void main(String[] args) {
        StartTest startTest = new StartTest(MyClass.class);
        startTest.start();
    }
}
