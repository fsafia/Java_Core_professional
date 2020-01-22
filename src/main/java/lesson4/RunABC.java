package lesson4;

public class RunABC {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        ABC a = new ABC(monitor,'a');
        ABC b = new ABC(monitor,'b');
        ABC c = new ABC(monitor,'c');
        new Thread(c).start();
        new Thread(b).start();
        new Thread(a).start();
    }
}
