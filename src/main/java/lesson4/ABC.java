package lesson4;

public class ABC implements Runnable {
    private Monitor monitor;
    private char letter;

    public ABC(Monitor monitor, char letter) {
        this.monitor = monitor;
        this.letter = letter;
    }

    @Override
    public void run(){

        for (int i = 0; i < 5; i++) {
            try {
                monitor.print(letter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

