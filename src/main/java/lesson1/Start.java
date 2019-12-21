package lesson1;

public class Start {
    public static void main(String[] args) {
        Tasks arr = new Tasks("a", "b", "c", "d", "e");
        arr.swapItems("b", "c");

        arr.convertArrayToArrayList();

        Tasks int1 = new Tasks(1, 2, 3, 4, 5);
        int1.swapItems(3, 4);
        int1.convertArrayToArrayList();
    }
}
