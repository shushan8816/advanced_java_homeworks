package Homework4;

import Homework3.MyTimer;

import java.io.File;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

        File dir = Test.getDir();

        long fileSize = Test.getFileSize(dir);

        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("Folder size: " + df.format((double) fileSize / 1024) + "kB" + "(" + fileSize + "byte)");

    }
}

