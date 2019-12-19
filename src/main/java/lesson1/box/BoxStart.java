package lesson1.box;

public class BoxStart {
    public static void main(String[] args) {
        Apple apple = new Apple();

        Box<Apple> appleBox = new Box<Apple>(apple);
        appleBox.addFruit(apple);
        appleBox.addFruit(apple );
        appleBox.addFruit(apple );
        System.out.println("ящик с яблоками весит " + appleBox.getWeight());


        Orange orange = new Orange();
        Box<Orange> orangeBox = new Box<Orange>(orange);
        orangeBox.addFruit(orange);
        orangeBox.addFruit(orange);
        orangeBox.addFruit(orange);
        orangeBox.getWeight();

        System.out.println("ящик с апельсинами весит " + orangeBox.getWeight());
        System.out.println("Ящик с яблоками весит столько же сколько ящик с апельсинами?" + orangeBox.compare(appleBox));

        Box<Apple> appleBox1 = new Box<Apple>(apple);
        appleBox.pouringFruit(appleBox1);

        Box<Orange> orangeBox1 = new Box<Orange>(orange);
        orangeBox.pouringFruit(orangeBox1);
    }
}
