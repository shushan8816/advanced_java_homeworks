package Homework4;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Please enter a file or folder path:");
        String path = s.nextLine();
        File file = new File(path);

        Thread t1 = new Thread(() -> FolderSize.folderSize(file));
        t1.start();
        while (t1.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Folder size: " + df.format((double) FolderSize.size/ 1024) +
                    "kB " + "(" + FolderSize.size + " byte)");
        }
    }
}





