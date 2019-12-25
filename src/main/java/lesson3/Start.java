package lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Start {
    public void task1(){
        try(FileInputStream in = new FileInputStream("/home/safia/courses/Java2/text.txt")) {
            int x;
            byte[] ar =  new byte[50];
            while ((x = in.read(ar)) != -1){
                System.out.print(new String(ar, 0, x, "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void task2() throws IOException{
        ArrayList<InputStream> arrayList = new ArrayList<>();
        arrayList.add(new FileInputStream("/home/safia/courses/Java2/homeWork/song1.txt"));
        arrayList.add(new FileInputStream("/home/safia/courses/Java2/homeWork/song2.txt"));
        arrayList.add(new FileInputStream("/home/safia/courses/Java2/homeWork/song3.txt"));
        arrayList.add(new FileInputStream("/home/safia/courses/Java2/homeWork/song4.txt"));
        arrayList.add(new FileInputStream("/home/safia/courses/Java2/homeWork/song5.txt"));
        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(arrayList));

        int x;

        while ((x = in.read()) !=  -1){
            System.out.print((char) x);
        }
        in.close();
    }


    public static void main(String[] args) {
        Start start = new Start();
        start.task1();

        try{
            start.task2();
        } catch (IOException e){
            e.printStackTrace();
        }
        long t = System.currentTimeMillis();


    }
}
