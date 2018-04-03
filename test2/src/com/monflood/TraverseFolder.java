package com.monflood;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TraverseFolder {
    public List<String> GetFlilesPath(String path) {
        File file = new File(path);
        List<String> listfile=new ArrayList<String>();
        if (file.exists()) {
            LinkedList<File> list = new LinkedList<File>();
            File[] files = file.listFiles();
            for (File file2 : files) {
                if (file2.isDirectory()) {
                    list.add(file2);
                } else {
                    listfile.add(file2.getAbsolutePath());
                }
            }
            File temp_file;
            while (!list.isEmpty()) {
                temp_file = list.removeFirst();
                files = temp_file.listFiles();
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        list.add(file2);
                    } else {
                        listfile.add(file2.getAbsolutePath());
                    }
                }
            }
        }
        return listfile;
    }
}
