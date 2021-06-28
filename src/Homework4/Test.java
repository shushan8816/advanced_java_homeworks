package Homework4;

import java.io.File;
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
}







