package Homework4;

import java.io.File;
import java.text.DecimalFormat;


public class Main {

    private static long currentSize;

    public static void main(String[] args) {

        File dir = Test.getDir();
        DecimalFormat df = new DecimalFormat("0.00");
        Thread t1 = new Thread(() -> {
            currentSize = FolderSize.getFileSize(dir);
        });
        Thread t2 = new Thread(() -> {
            while (t1.isAlive()) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                System.out.println("Folder size: " + df.format((double) currentSize / 1024) +
                        "kB " + "(" + currentSize + " byte)");
            }
        });
        t1.start();
        t2.start();
    }
}





