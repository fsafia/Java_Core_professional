package lesson4;

public class Monitor {
    volatile private int currentIndex = 0;
    private char [] allLetters = {'a', 'b', 'c'};
    synchronized public void print(char letter) throws InterruptedException {
        while (letter != allLetters[currentIndex]) {
            wait();
        }

        System.out.print(letter);
        changeCurrentIndex();
        notifyAll();

    }

     private void changeCurrentIndex() {
        if (currentIndex + 1 >= allLetters.length){
            currentIndex = 0;
        } else {
            currentIndex++;
        }
    }
}
