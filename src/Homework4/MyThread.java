package Homework4;

import java.io.File;
import java.text.DecimalFormat;

public class MyThread extends Thread {

    public static long getFileSize(File dir) {
        long size = 0;
        if (dir.isFile()) {
            return dir.length();
        } else {
            File[] subFiles = dir.listFiles();
            if (subFiles != null) {
                for (File subFile : subFiles) {
                    if (subFile.isFile()) {
                        size = size + getFileSize(subFile);
                    }
                }
            }
            return size;
        }
    }

    @Override
    public void run() {
        File dir = Test.getDir();
        long fileSize = getFileSize(dir);
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Folder size: " + df.format((double) fileSize / 1024) + "kB" + "(" + fileSize + "byte)");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
