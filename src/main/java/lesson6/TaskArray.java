package lesson6;

import java.util.Arrays;

public class TaskArray {
    public int[] outputLastElements(int...array) {
        int numberElements = array.length % 4;
        int[] outputArray = new int[numberElements];

        if (array.length <= 4) {
            throw new RuntimeException("Размер массива меньше 4!");
        }

        for (int i = 0; i < numberElements; i++) {
            outputArray[i] = array[array.length - (numberElements - i)];
            System.out.println(outputArray[i]);
        }

        return outputArray;
    }

    public boolean check1and4(int ... array){
        int count1 = 0;
        int count4 = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1 ){
                count1++;
            }
            if (array[i] == 4){
                count4++;
            }
        }

        return !(count1 == array.length || count4 == array.length || (count1 + count4) != array.length);
    }
}
