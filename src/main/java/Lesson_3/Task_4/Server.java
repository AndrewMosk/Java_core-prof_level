package Lesson_3.Task_4;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
    private ServerSocket server = null;
    private Socket socket = null;
    private DataInputStream in = null;

    Server(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Сервер запущен");
            socket = server.accept();
            System.out.println("Клиент подключился");
            in = new DataInputStream(socket.getInputStream());

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        ObjectInputStream ois = new ObjectInputStream(in);
                        ObjectToTransfer object = (ObjectToTransfer)ois.readObject();
                        object.info();
                        ois.close();
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
            thread.join();
            in.close();
            socket.close();
            server.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
