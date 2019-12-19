package lesson1.box;

public class Fruit {
    public float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }
}

class Apple extends Fruit{
    public float weight = 1.0f;

    public Apple() {
        super(1.0f);

    }
}

class Orange extends Fruit{
    public float weight = 1.5f;

    public Orange() {
        super(1.5f);

    }
}
