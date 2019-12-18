package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class  Tasks <T>{
    private T [] items;

    public Tasks(T... items) {
        this.items = items;
    }

    public  T [] swapItems( T item1, T item2){
        int index1 = 0, index2 = 0;
        for (int i = 0; i < items.length; i++) {
            if(items[i] == item1) {
                index1 = i;
                break;
            }
        }

        for (int i = 0; i < items.length; i++) {
            if(items[i] == item2) {
                index2 = i;
                break;
            }
        }

        items[index1] = item2;
        items[index2] = item1;
        System.out.println(Arrays.toString(items));
        return items;
    }

    public ArrayList<T> convertArrayToArrayList(){
        ArrayList <T> arrayList = new ArrayList<T>();
        for (T item : items){
            arrayList.add(item);
        }
        for (int i = 0; i < arrayList.size() ; i++) {
            System.out.println(arrayList.get(i));
        }
        return arrayList;
    }
}
