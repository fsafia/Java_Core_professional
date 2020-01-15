package lesson4;

import java.util.Vector;

public class MFU {
    volatile Vector<Human>  queuePrint = new Vector<>();
    volatile Vector<Human>  queueScanOrCopy = new Vector<>();

    synchronized public void printMFU() throws InterruptedException {
        while (queuePrint.size() != 0){
            System.out.println(queuePrint.get(0).humanNumber + "распечатал");
            queuePrint.remove(0);
        }
       // wait();
    }

    synchronized void scanOrCopy(String sOrC) throws InterruptedException {
        while (queueScanOrCopy.size() != 0){
            System.out.println(queueScanOrCopy.get(0).humanNumber + " выполнил " + sOrC);
            Thread.sleep(3000);
            queueScanOrCopy.remove(0);
        }
        //wait();
    }
}
