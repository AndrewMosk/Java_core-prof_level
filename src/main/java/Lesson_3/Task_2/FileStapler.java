package Lesson_3.Task_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class FileStapler {
    private String path;

    FileStapler(String path) {
        this.path = path;
    }

    void AttachFiles(){
        try {
            ArrayList<InputStream> inputStream = new ArrayList<>();
            String[] list = getFilesList();

            for (String file : list) {
                inputStream.add(new FileInputStream(file));
            }

            SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(inputStream));

            int x;
            while ((x = sequenceInputStream.read()) != -1) {
                System.out.print((char)x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String[] getFilesList() {
        File dir = new File(path);
        File[] arrFiles = dir.listFiles();
        String[] list = new String[arrFiles.length];

        for (int i = 0; i < arrFiles.length; i++) {
            list[i] = arrFiles[i].getPath();
        }

        return list;
    }
}
