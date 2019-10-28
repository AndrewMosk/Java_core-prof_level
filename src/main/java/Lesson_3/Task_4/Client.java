package Lesson_3.Task_4;

import java.io.*;
import java.net.Socket;

class Client {
    private Socket socket = null;
    private DataOutputStream out = null;

    Client(String server, int port, ObjectToTransfer object) {
        try {
            socket = new Socket(server, port);
            System.out.println("Клиент подключился");
            out = new DataOutputStream(socket.getOutputStream());

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(out);
                        oos.writeObject(object);
                        oos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
            thread.join();
            out.close();
            socket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
