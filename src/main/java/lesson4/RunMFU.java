package lesson4;

public class RunMFU {
    public static void main(String[] args) {
        MFU mfu = new MFU();
        Human human1 = new Human(mfu, 1, true, true, true);
        Human human2 = new Human(mfu, 2, true, true, true);
        Human human3 = new Human(mfu, 3, true, true, false);
        Human human4 = new Human(mfu, 4, true, true, false);
        Human human5 = new Human(mfu, 5, true, false, true);
        Human human6 = new Human(mfu, 6, true, false, true);
        Human human7 = new Human(mfu, 7, true, true, true);
        Human human8 = new Human(mfu, 8, true, true, false);
        Human human9 = new Human(mfu, 9, true, false, true);
        Human human10= new Human(mfu, 10, true, true, false);

        new Thread(human1).start();
        new Thread(human2).start();
        new Thread(human3).start();
        new Thread(human4).start();
        new Thread(human5).start();
        new Thread(human6).start();
        new Thread(human7).start();
        new Thread(human8).start();
        new Thread(human9).start();
        new Thread(human10).start();
    }


}
