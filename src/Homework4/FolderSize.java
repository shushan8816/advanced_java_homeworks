package Homework4;

import java.io.File;

public class FolderSize {
    public static long currentSize;

    public static long getFileSize(File dir) {
        long size = 0;
        if (dir.isFile()) {
            return dir.length();
        } else {
            File[] subFiles = dir.listFiles();
            if (subFiles != null) {
                for (File subFile : subFiles) {
                    if (subFile.isDirectory()) {
                        size += getFileSize(subFile);
                    } else {
                        size += subFile.length();
                        currentSize += size;
                    }
                }
            }
            return size;
        }
    }
}
