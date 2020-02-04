package lesson8;

import java.util.ArrayList;

public class TreeId {
    int [][] ar;
    int size ;
    int mass[][];
    int nStol = 0;
    int nStr = 0;

    ArrayList<Integer> listId = new ArrayList<>();

    public TreeId(int [][] ar){
        this.ar = ar;
        this.size = ar.length;
        this.mass = new int[size][size];
        initMass();

    }

    public int [][] initMass() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mass[i][j] = 0;
            }
        }
        return mass;
    }

    public void printMass() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(mass[i][j] == 0) {
                    System.out.print("--");
                }else {
                    //System.out.print(mass[i][j] + ",");
                    System.out.print(mass[i][j] + "-" );
                }

            }
            System.out.println();
        }
    }
    public void printListId() {
        for (int i = 0; i < listId.size(); i++) {
            System.out.print(listId.get(i));
        }
    }

    public int checkChild(int id){
        int a = 0;
        int childId = 0;
        for (int i = 0; i < size; i++) {
            if (ar[i][1] == id) {
                a=1;
                for (int k = 0; k < listId.size(); k++ ) {
                    if (listId.get(k) == ar[i][0]) {
                       // childId = 0;
                        a=0;
                        break;
                    }
                }
                if (a==1){childId = ar[i][0];return childId;}
            }
        }
        //listId.add();
        return childId;

    }

    public void buildTree() {
        for (int i = 0; i < ar.length ; i++) {

            if (ar[i][1] == 0) {
                nStol = 0;
                rec(ar[i][0]);
            }
        }
    }


    public void rec(int id) {
        mass[nStr][nStol] = id;
        listId.add(id);
        //int childId ;
        while(checkChild(id)!=0) {
            nStol = nStol + 1;
            rec(checkChild(id));
        }
                nStol = nStol - 1;
                nStr = nStr + 1;


    }
}
