package lesson7;

public class MyClass {
    public MyClass() {
    }

    @MyTest(priotity = 4)
    public void info5() { System.out.println("info5");    }

    @MyTest(priotity = 1)
    public void info1() {
        System.out.println("info1");
    }

    @MyTest(priotity = 2)
    public void info2() {
        System.out.println("info2");
    }

    @MyTest(priotity = 3)
    public void info3() {
        System.out.println("info3");
    }

    @MyTest(priotity = 4)
    public void info4() {
        System.out.println("info4");
    }



    @AfterSuite
    public  void by() {
        System.out.println("by");
    }

    @BeforeSuite
    public  void hello() {
        System.out.println("hello");
    }


}
