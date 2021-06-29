package Homework4;

import java.io.File;

public class FolderSize {
    static long size;
    static public void folderSize(File file) {
        File[] files = file.listFiles();
        if (files == null) {
            return;
        }

        for (File f : files) {
            if (f.isFile()) {
                size += f.length();
            } else {
                folderSize(f);
            }
        }
    }
}
