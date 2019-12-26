package lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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

    public void task3(String file) throws  IOException{
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long numberCharsInOnePage = 1800;
        double pageMax = randomAccessFile.length()/numberCharsInOnePage;
        System.out.println("В книге всего " + pageMax + " страниц. ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер страницы : ");
        long pageNumber = scanner.nextLong();

        if( pageNumber < pageMax){
            long pageNumberStart = numberCharsInOnePage  * (pageNumber-1);
            randomAccessFile.seek(pageNumberStart);

            for (long i = pageNumberStart; i <= numberCharsInOnePage * pageNumber -1 ; i++) {
                System.out.print((char) randomAccessFile.read());
            }
        } else System.out.println("В книге всего нет страницы с номером: " + pageNumber);



    }

    public static void main(String[] args) {
       Start start = new Start();
//        start.task1();
//
//        try{
//            start.task2();
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//        //long t = System.currentTimeMillis();

        try{
            start.task3("/home/safia/courses/Java2/OstrovSokrovish.txt");
        } catch (IOException e){
            e.printStackTrace();
        }
    }





}
