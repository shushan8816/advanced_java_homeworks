package Homework4;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Test {

    public static File getDir() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a file or folder path:");
        while (true) {
            String str = sc.nextLine();
            File dir = new File(str);
            if (!dir.exists()) {
                System.out.println("The file or folder path you entered does not exist, please re-enter:");
            } else {
                return dir;
            }
        }
    }

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
                        System.out.println(size/1024 + " KB");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return size;
        }
    }
}





