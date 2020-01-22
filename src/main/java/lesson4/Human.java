package lesson4;

public class Human implements Runnable {
    private MFU mfu;
    public int humanNumber;
    private boolean print = false;
    private boolean copy = false;
    private boolean scan = false;

    public Human(MFU mfu, int humanNumber, boolean print, boolean copy, boolean scan) {
        this.mfu = mfu;
        this.humanNumber = humanNumber;
        this.print = print;
        this.copy = copy;
        this.scan = scan;
    }

    @Override
    public void run() {
        if (print) {
            mfu.queuePrint.add(this);
            try {
                mfu.printMFU();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (copy) {
            mfu.queueScanOrCopy.add(this);
            try {
                mfu.scanOrCopy( "копирование");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (scan) {
            mfu.queueScanOrCopy.add(this);
            try {
                mfu.scanOrCopy( "сканирование");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
