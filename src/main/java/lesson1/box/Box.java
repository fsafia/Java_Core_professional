package lesson1.box;

import java.util.ArrayList;

public class Box <T extends Fruit>{

    public float weight;
    ArrayList<T> a = new ArrayList<T>();

    public Box(T fruit) {
        this.weight = fruit.weight; //почему fruit.weight берется из  класса Fruit, а не  Apple
    }

    public ArrayList<T> addFruit(T  fruit){
        a.add(fruit);
        return a;
    }

    public float getWeight(){
        return a.size()*weight;
    }

    public boolean compare(Box<?> another){
        return (this.getWeight() == another.getWeight());
    }

    //пересыпание фруктов
    public Box<T> pouringFruit(Box<T> anotherBox){
        int count = a.size();
        T fruit = a.get(0);
        for (int i = 0; i < count; i++) {
            anotherBox.addFruit(fruit);
            a.remove(fruit);
        }
        System.out.println("в текущей коробке вес: " + this.getWeight());
        System.out.println("В новой коробке вес: " + anotherBox.getWeight());
        return anotherBox;

    }
}
