package Lesson_3.Task_3;

import java.io.IOException;
import java.io.RandomAccessFile;

class E_book {
    private int pageLength;
    private RandomAccessFile randomAccessFile;
    private long pagesNumber;

    E_book(int pageLength, String file) throws IOException {
        this.pageLength = pageLength;
        this.randomAccessFile = new RandomAccessFile((file),"r");
        calculatePagesNumber();
    }

    long getPagesNumber() {
        return pagesNumber;
    }

    private void calculatePagesNumber() throws IOException {
        pagesNumber = 0;
        long size = randomAccessFile.getChannel().size();
        if (size%pageLength!=0) pagesNumber++;

        pagesNumber += size/pageLength;
    }

    void printPage(int page) {
        try {
            randomAccessFile.seek(page*pageLength);
            byte[] arr = new byte[pageLength];
            int x;

            x = randomAccessFile.read(arr);
            System.out.print(new String(arr,0,x));
            System.out.println("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
