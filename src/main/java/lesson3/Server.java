package lesson3;

import java.io.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket server;
    Socket socket;
    Book book;

    ObjectInputStream in;
    ObjectOutputStream out;

    public Server(){
        try {
            server = new ServerSocket(8191);
            System.out.println("Сервер запущен!");

            socket = server.accept();
            System.out.println("клиент подключился!");
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            while (true){
                try {
                    Book book = (Book) in.readObject();
                    book.info();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }



        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
    }
}

