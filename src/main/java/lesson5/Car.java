package lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Car implements Runnable {

    private static int CARS_COUNT;
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(MainClass.CARS_COUNT);
    private static Semaphore semaphore = new Semaphore(MainClass.CARS_COUNT / 2);
    private static volatile boolean win = true;
    private static volatile boolean start = true;

    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;



    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    public String getName() { return name; }
    public int getSpeed() {
        return speed;
    }
     public synchronized void isWin() {
        if (win) {
            System.out.println(name + " - WIN");
            win = false;
        }
    }
    public synchronized void isStart() {
        if (start) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            start = false;
        }
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");

            cyclicBarrier.await();
            isStart();

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            //если препятствие тоннель
            try {
                if (race.getStages().get(i).description.equals("Тоннель " + race.getStages().get(i).length + " метров")) {
                    System.out.println(getName() + " готовится к этапу(ждет): " + race.getStages().get(i).description);
                    semaphore.acquire();
                    race.getStages().get(i).go(this);
                    semaphore.release();
                } else {
                    race.getStages().get(i).go(this);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        isWin();
    }
}
